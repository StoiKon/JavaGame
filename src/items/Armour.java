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
public class Armour extends Item{
    public Armour( int tier, String rarity, int x, int y) throws IOException {
        super("Iron Armour", "armour", tier, rarity, x, y
                
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\armour\\armourIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\armour\\armour.png")));
        this.setValue(150);
        this.setArmour(7);
        
    }
    public Armour( int tier, int x, int y) throws IOException {
        super("Iron Armour", "armour", tier, "normal", x, y
                
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\armour\\armourIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\armour\\armour.png")));
        this.setValue(150);
        this.setArmour(7);
        
    }
    
}
