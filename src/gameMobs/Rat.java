/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMobs;

import Klasses.Klass;
import gameObjects.Mob;
import items.Item;
import itemsDrops.RatHide;
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
public class Rat extends Mob {

    public Rat(int x, int y, Klass klass, int level) throws IOException {
        super(x, y, "Rat", "rat", klass, "normal", ImageIO.read(new File("resources\\NPcs\\animals\\rats\\rat.png")));
        this.setLife(30);
        this.setLvl(level);
        this.setStr(9);

    }

    @Override
    public Item getDrop() {
        try {
            return new RatHide(this.getX(), this.getY());
        } catch (IOException ex) {
            Logger.getLogger(Rat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
