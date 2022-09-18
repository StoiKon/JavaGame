/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import gameObjects.Entity;
import items.Inventory;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import source.Handler;

/**
 *
 * @author Name
 */
public class ShopMenu {

    private Inventory inv;
    private Handler handler;
    private Entity shop;
    private ShopMenuMouse mouse;
    private ShopMenuMouseListener mouseL;

    public ShopMenu(Entity e, Handler handler) {
        this.inv = e.getInventory();
        this.handler = handler;
        this.shop = e;
        mouse = new ShopMenuMouse(handler, e);
        mouseL = new ShopMenuMouseListener(handler, e);
    }

    public void paint(Graphics g) {
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.setColor(Color.yellow);
        g.drawString("Gold : " + handler.getPlayer().getGold(), 610, 130);
        g.drawString("SHOP", 100, 130);
        g.setFont(new Font("Arial", Font.PLAIN, 10));

        inv.paintContents2(g);
    }

    public ShopMenuMouse getMouse() {
        return mouse;
    }

    public ShopMenuMouseListener getMouseL() {
        return mouseL;
    }

}
