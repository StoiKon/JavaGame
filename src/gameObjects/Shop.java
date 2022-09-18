/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import Klasses.Klass;
import items.Armour;
import items.Boots;
import items.Helmet;
import items.Inventory;
import items.Knife;
import items.Sword1H;
import items.Sword2H;
import itemsTier2.Armourt2;
import itemsTier2.Bootst2;
import itemsTier2.Helmet2;
import itemsTier2.Shieldt2;
import itemsTier2.Sword1Ht2;
import itemsTier2.Sword2Ht2;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Shop extends Entity{
private Inventory inventory;    

    public Shop(int x, int y) throws IOException {
        super(x, y, "Shop", "merchant", null, "Capitalist", ImageIO.read(new File("resources\\NPcs\\shops\\tier1\\shop.png")));
        this.inventory=new Inventory(10,6);
    }
    public Shop(int x, int y,int tier) throws IOException {
        super(x, y, "Shop", "merchant", null, "Capitalist", ImageIO.read(new File("resources\\NPcs\\shops\\tier1\\shop.png")));
        this.inventory=new Inventory(10,6);
        this.inventory.addItem(new Sword1H(1,0,0));
        this.inventory.addItem(new Sword2H(1,0,0));
        this.inventory.addItem(new Knife(1,0,0));
        this.inventory.addItem(new Helmet(1,0,0));
        this.inventory.addItem(new Armour(1,0,0));
        this.inventory.addItem(new Boots(1,0,0));
        this.inventory.addItem(new Sword2Ht2(0,0));
        this.inventory.addItem(new Shieldt2(0,0));
        this.inventory.addItem(new Sword1Ht2(0,0));
        this.inventory.addItem(new Armourt2(0,0));
        this.inventory.addItem(new Helmet2(0,0));
        this.inventory.addItem(new Bootst2(0,0));
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public String toString() {
        return "Shop";
    }
    
    
    
   
    
}
