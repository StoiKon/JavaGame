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
public class Boots extends Item{
       public Boots( int tier, String rarity, int x, int y) throws IOException {
        super("iron Boots", "boots", tier, rarity, x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\boots\\bootsIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\boots\\boots.png")));
        this.setValue(80);
        this.setArmour(2);
        
    } 
       public Boots( int tier, int x, int y) throws IOException {
        super("iron Boots", "boots", tier, "normal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\boots\\bootsIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\boots\\boots.png")));
        this.setValue(80);
        this.setArmour(2);
        
    } 
}
