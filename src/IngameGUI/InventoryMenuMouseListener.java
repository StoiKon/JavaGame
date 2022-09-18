/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import source.Handler;

/**
 *
 * @author Name
 */
public class InventoryMenuMouseListener implements MouseListener {

    private Handler handler;

    public InventoryMenuMouseListener(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (inside(e.getX(), e.getY(), 100, 100) && handler.getPlayer().getEquipment().getMainHand() != null) {
                handler.getPlayer().unequip(handler.getPlayer().getEquipment().getMainHand());

            }
            if (inside(e.getX(), e.getY(), 200, 100) && handler.getPlayer().getEquipment().getOffHand() != null) {
                handler.getPlayer().unequip(handler.getPlayer().getEquipment().getOffHand());

            }
            if (inside(e.getX(), e.getY(), 300, 100) && handler.getPlayer().getEquipment().getBodyarmour() != null) {
                handler.getPlayer().unequip(handler.getPlayer().getEquipment().getBodyarmour());
            }
            if (inside(e.getX(), e.getY(), 400, 100) && handler.getPlayer().getEquipment().getBoots() != null) {
                handler.getPlayer().unequip(handler.getPlayer().getEquipment().getBoots());

            }
            if (inside(e.getX(), e.getY(), 500, 100) && handler.getPlayer().getEquipment().getHelmet() != null) {
                handler.getPlayer().unequip(handler.getPlayer().getEquipment().getHelmet());

            }

            for (int i = 100; i < 1100; i += 100) {
                for (int j = 300; j < 800; j += 100) {
                    if (handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3) != null && inside(e.getX(), e.getY(), i, j)) {
                        handler.getPlayer().equip(handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3));
                    }
                }
            }
        }
        if(e.getButton()==MouseEvent.BUTTON3){
            for (int i = 100; i < 1100; i += 100) {
                for (int j = 300; j < 800; j += 100) {
                    if (handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3) != null && inside(e.getX(), e.getY(), i, j)) {
                        handler.getPlayer().sell(handler.getPlayer().getInventory().getItem((i / 100) - 1, (j / 100) - 3));
                    }
                }
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean inside(int x, int y, int x2, int y2) {
        return (x >= x2 && x <= x2 + 100) && (y >= y2 && y <= y2 + 100);
    }

}
