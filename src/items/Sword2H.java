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
public class Sword2H extends Item{
    
    public Sword2H( int tier, String rarity, int x, int y) throws IOException {
        super("iron sword(two handed)", "2H", tier, rarity, x, y
                , ImageIO.read(new File("resources\\Items\\Tier 1\\2H weapon\\2Hsword\\sword2HIcon.png"))
                , ImageIO.read(new File("resources\\Items\\Tier 1\\2H weapon\\2Hsword\\sword2H.png")));
        this.setValue(150);
        this.setPhysDmg(13);
    }
    public Sword2H( int tier, int x, int y) throws IOException {
        super("iron sword(two handed)", "2H", tier, "normal", x, y
                , ImageIO.read(new File("resources\\Items\\Tier 1\\2H weapon\\2Hsword\\sword2HIcon.png"))
                , ImageIO.read(new File("resources\\Items\\Tier 1\\2H weapon\\2Hsword\\sword2H.png")));
        this.setValue(150);
        this.setPhysDmg(16);
    }
    
    
}
