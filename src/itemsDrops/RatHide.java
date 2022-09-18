/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsDrops;

import items.Item;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class RatHide extends Item{
    
    public RatHide( int x, int y) throws IOException {
        super("rat hide", "sellables", 0, x, y, ImageIO.read(new File("resources\\Items\\Drop\\Animals\\ratHide\\ratHide.png")),null);
        this.setValue(50);
    }
    
}
