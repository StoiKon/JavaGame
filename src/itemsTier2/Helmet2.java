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
public class Helmet2 extends Item{
    
    public Helmet2( int x, int y) throws IOException {
        super("iron helmet", "helm", 2, "normal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\helmet\\helmetIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\helmet\\helmet.png")));
        this.setValue(280);
        this.setArmour(7);
    }
    
}
