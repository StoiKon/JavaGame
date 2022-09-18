/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsTier2;

import items.Item;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Bootst2 extends Item{
    
    public Bootst2( int x, int y) throws IOException {
        super("iron Boots", "boots", 2, "normal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\boots\\bootsIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\boots\\boots.png")));
        this.setValue(200);
        this.setArmour(5);
    }
    
}
