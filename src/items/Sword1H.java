/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Sword1H extends Item{
    
    public Sword1H( int tier, String rarity, int x, int y) throws IOException {
        super("iron sword(one handed)", "1H", tier, rarity, x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordMainHand.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordOffHand.png")));
        this.setValue(120);
        this.setPhysDmg(8);
        
    }
    public Sword1H( int tier, int x, int y) throws IOException {
        super("iron sword(one handed)", "1H", tier, "normal", x, y
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordIcon.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordMainHand.png"))
                ,ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\sword\\swordOffHand.png")));
        this.setValue(120);
        this.setPhysDmg(8);
        
    }
    
}
