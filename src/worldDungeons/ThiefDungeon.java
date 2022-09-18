/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldDungeons;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import world.Dungeon;
import world.Map;

/**
 *
 * @author Name
 */
public class ThiefDungeon extends Dungeon{
    
    public ThiefDungeon( int x, int y) throws IOException {
        super("ThiefDungeon", x, y,ImageIO.read(new File("resources\\3.Dungeon\\thiefDungeon.png")));
        this.addMap(new Map(new File("maps\\ThiefDungeon\\map1.map"),new File("maps\\ThiefDungeon\\ent1.en"),"World Map"));
        this.addMap(new Map(new File("maps\\ThiefDungeon\\map2.map"),new File("maps\\ThiefDungeon\\ent2.en"),"World Map"));
        this.addMap(new Map(new File("maps\\ThiefDungeon\\map3.map"),new File("maps\\ThiefDungeon\\ent3.en"),"World Map"));
    }
    
}
