/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import gameObjects.Player;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JButton;
import source.Handler;

/**
 *
 * @author Name
 */
public class InventoryMenuMouse extends MouseMotionAdapter {

    private Handler handler;

    public InventoryMenuMouse(Handler handler) {
        this.handler = handler;

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if (inside(e.getX(), e.getY(), 100, 100) && handler.getPlayer().getEquipment().getMainHand() != null) {
            handler.setTooltip(100, 200, handler.getPlayer().getEquipment().getMainHand().toString());
            

        }
        if (inside(e.getX(), e.getY(), 200, 100) && handler.getPlayer().getEquipment().getOffHand() != null) {
            handler.setTooltip(200, 200, handler.getPlayer().getEquipment().getOffHand().toString());

        }
        if (inside(e.getX(), e.getY(), 300, 100) && handler.getPlayer().getEquipment().getBodyarmour() != null) {
            handler.setTooltip(300, 200, handler.getPlayer().getEquipment().getBodyarmour().toString());
        }
        if (inside(e.getX(), e.getY(), 400, 100) && handler.getPlayer().getEquipment().getBoots() != null) {
            handler.setTooltip(400, 200, handler.getPlayer().getEquipment().getBoots().toString());

        }
        if (inside(e.getX(), e.getY(), 500, 100) && handler.getPlayer().getEquipment().getHelmet() != null) {
            handler.setTooltip(500, 200, handler.getPlayer().getEquipment().getHelmet().toString());

        }
        //handler.removeTooltip();
        //inventory=new Inventory(10,5);
        for (int i = 100; i < 1100; i += 100) {
            for (int j = 300; j < 800; j += 100) {
                if (handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3) != null && inside(e.getX(),e.getY(),i,j)) {
                    handler.setTooltip(i, j+100, handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3).toString());
                }
            }
        }
    }

    public boolean inside(int x, int y, int x2, int y2) {
        return (x >= x2 && x <= x2 + 100) && (y >= y2 && y <= y2 + 100);
    }

}
