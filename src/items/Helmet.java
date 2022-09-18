/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Helmet extends Item{
    public Helmet( int tier, String rarity, int x, int y) throws IOException {
        super("iron helmet", "helm", tier, rarity, x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\helmet\\helmetIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\helmet\\helmet.png")));
        this.setValue(80);
        this.setArmour(3);
        
    }
    public Helmet( int tier, int x, int y) throws IOException {
        super("iron helmet", "helm", tier, "normal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\helmet\\helmetIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\helmet\\helmet.png")));
        this.setValue(80);
        this.setArmour(3);
        
    }
}
