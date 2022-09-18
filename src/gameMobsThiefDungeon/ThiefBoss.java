/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMobsThiefDungeon;

import Klasses.Klass;
import gameMobs.Rat;
import gameObjects.Entity;
import items.Item;
import itemsDrops.KingCrownDrop;
import itemsDrops.RatBossHide;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class ThiefBoss extends Entity{
    
    public ThiefBoss(int x, int y,int level) throws IOException {
        super(x, y, "thief", "human", new Klass(), "hostile",ImageIO.read(new File("resources\\NPcs\\thiefs\\thiefBoss_armed.png")));
        this.setLvl(level);
        this.setLife(level*40);
        this.setStr(40);
        
    }
    public Item getDrop() {
        try {
            return new KingCrownDrop(this.getX(), this.getY());
        } catch (IOException ex) {
            Logger.getLogger(Rat.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
