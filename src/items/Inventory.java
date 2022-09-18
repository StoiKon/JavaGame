/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Inventory {

    private Item[][] items;
    private int x_slots, y_slots;
    private Image empty;

    public Inventory(int x_slot, int y_slot) {
        this.x_slots = x_slot;
        this.y_slots = y_slot;
        items = new Item[x_slots][y_slots];
        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                items[i][j] = null;
            }
        }
        try {
            empty = ImageIO.read(new File("resources\\Items\\EmptyInvSlot\\empty.png"));
        } catch (IOException ex) {
            Logger.getLogger(Inventory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paintContents(Graphics g) {

        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                if (items[i][j] == null) {
                    g.drawImage(empty, 100 + i * 100, j * 100 + 300, null);

                } else {
                    g.drawImage(items[i][j].getIcon_onMap(), 100 + i * 100, j * 100 + 300, null);
                }
            }
        }
    }
    public void paintContents2(Graphics g){
        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                if (items[i][j] == null) {
                    g.drawImage(empty, 100 + i * 100, j * 100 + 300, null);

                } else {
                    g.drawImage(items[i][j].getIcon_onMap(), 100 + i * 100, j * 100 + 300, null);
                }
            }
        }
    }

    public int getX_slots() {
        return x_slots;
    }

    public int getY_slots() {
        return y_slots;
    }

    public Item getItem(int x, int y) {
        return this.items[x][y];
    }

    public void removeItem(Item item) {
        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                if (items[i][j] == item) {
                    items[i][j] = null;
                    return;
                }
            }
        }
    }

    public void addItem(Item item) {
        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                if (items[i][j] == null) {
                    items[i][j] = item;
                    return;
                }
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < x_slots; i++) {
            for (int j = 0; j < y_slots; j++) {
                if (items[i][j] == null) {

                    return false;
                }
            }
        }return true;
        
    }
}
