/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameMobsThiefDungeon;

import Klasses.Klass;
import gameObjects.Entity;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Skeleton extends Entity{
    
    public Skeleton(int x, int y,int level) throws IOException {
        super(x, y, "skeleton", "undead", new Klass(), "hostile",ImageIO.read(new File("resources\\NPcs\\demons\\other demons\\daemon.png")));
        this.setLvl(level);
        this.setLife(level*15);
        this.setStr(29);
        
    }
    
}
