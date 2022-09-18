/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import gameObjects.Entity;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import source.Handler;

/**
 *
 * @author Name
 */
public class ShopMenuMouse extends MouseMotionAdapter {

    private Handler handler;
    private Entity shop;
    
    
    public ShopMenuMouse(Handler handler,Entity shop) {
        this.handler = handler;
        this.shop=shop;
        

    }

    @Override
    public void mouseMoved(MouseEvent e) {

        //handler.removeTooltip();
        //inventory=new Inventory(10,5);
        for (int i = 100; i < 1100; i += 100) {
            for (int j = 300; j < 900; j += 100) {
                if (shop.getInventory().getItem((i / 100) - 1, (j / 100) - 3) != null && inside(e.getX(), e.getY(), i, j)) {
                    handler.setTooltip(i, j + 100, shop.getInventory().getItem((i / 100) - 1, (j / 100) - 3).toString());
                }
            }
        }
    }

    public boolean inside(int x, int y, int x2, int y2) {
        return (x >= x2 && x <= x2 + 100) && (y >= y2 && y <= y2 + 100);
    }
}
