/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package itemsTier2;

import items.Item;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class Sword2Ht2 extends Item {

    public Sword2Ht2(int x, int y) throws IOException {
        super("iron sword(two handed)", "2H", 2, "normal", x, y,
                 ImageIO.read(new File("resources\\Items\\Tier 2\\2H weapon\\2Hsword\\sword2HIcon.png")),
                 ImageIO.read(new File("resources\\Items\\Tier 2\\2H weapon\\2Hsword\\sword2H.png")));
        this.setValue(340);
        this.setPhysDmg(32);

    }
}
