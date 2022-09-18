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
public class Shieldt2 extends Item{
    
    public Shieldt2( int x, int y) throws IOException {
        super("Legion Shield", "1H", 2, "normaal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\shield\\legionShieldIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\shield\\legionShield2.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 2\\shield\\legionShield.png")));
        this.setValue(300);
        this.setPhysDmg(8);
        this.setArmour(5);
    }
    
}
