/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMobs;

import Klasses.Klass;
import gameObjects.Mob;
import items.Item;
import itemsDrops.RatBossHide;
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
public class RatBoss extends Mob{
    
    public RatBoss(int x, int y,int level) throws IOException {
        super(x, y, "Rat Boss", "rat", new Klass(), "boss", ImageIO.read(new File("resources\\NPcs\\animals\\rats\\rat_boss.png")));
        this.setLvl(level);
        this.setLife(100);
        this.setStr(10+1*level);
    }
    @Override
    public Item getDrop() {
        try {
            return new RatBossHide(this.getX(), this.getY());
        } catch (IOException ex) {
            Logger.getLogger(Rat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
