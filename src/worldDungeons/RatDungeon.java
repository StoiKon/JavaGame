/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldDungeons;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import world.Dungeon;
import world.Map;

/**
 *
 * @author Name
 */
public class RatDungeon extends Dungeon{
    
    public RatDungeon( int x, int y) throws IOException {
        super("RatDungeon", x, y, ImageIO.read(new File("resources\\3.Dungeon\\ratDungeon.png")));
        this.addMap(new Map(new File("maps\\RatDungeon\\map1.map"),new File("maps\\RatDungeon\\ent1.en"),"World Map"));
        this.addMap(new Map(new File("maps\\RatDungeon\\map2.map"),new File("maps\\RatDungeon\\ent2.en"),"World Map"));
    }
    
}
