/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import gameObjects.Player;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import source.Handler;

/**
 *
 * @author Name
 */
public class InventoryMenu {
private Handler handler;
private InventoryMenuMouse mouse;
private InventoryMenuMouseListener mouseL;

    public InventoryMenu(Handler handler) {
        this.handler = handler;
        this.mouse=new InventoryMenuMouse(handler);
        this.mouseL=new InventoryMenuMouseListener(handler);
    }
    public void paint(Graphics g){
    g.setColor(Color.yellow);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 32)); 
    g.drawString("Gold : "+handler.getPlayer().getGold(), 610, 130);
    g.setFont(new Font("Arial", Font.PLAIN, 10));
    handler.getPlayer().getEquipment().paintContents(g);
    handler.getPlayer().getInventory().paintContents(g);
        
    }

    public InventoryMenuMouse getMouse() {
        return mouse;
    }

    public InventoryMenuMouseListener getMouseL() {
        return mouseL;
    }
    
    
    
}
