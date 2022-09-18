/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import gameObjects.Entity;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import source.Handler;

/**
 *
 * @author Name
 */
public class ShopMenuMouseListener implements MouseListener {

    private Handler handler;
    private Entity shop;

    public ShopMenuMouseListener(Handler handler,Entity shop) {
        this.handler = handler;
        this.shop=shop;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {

            for (int i = 100; i < 1100; i += 100) {
                for (int j = 300; j < 900; j += 100) {
                    if (shop.getInventory().getItem((i / 100) - 1, (j / 100) - 3) != null && inside(e.getX(), e.getY(), i, j)) {
                        handler.getPlayer().buy(shop.getInventory().getItem((i / 100) - 1, (j / 100) - 3));
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
