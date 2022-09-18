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
public class Thief extends Entity{
    
    public Thief(int x, int y,int level) throws IOException {
        super(x, y, "thief", "human", new Klass(), "hostile",ImageIO.read(new File("resources\\NPcs\\thiefs\\thief_armed.png")));
        this.setLvl(level);
        this.setLife(level*10);
        this.setStr(28);
        
    }
    
}
