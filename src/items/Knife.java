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
public class Knife extends Item {

    public Knife(int tier, String rarity, int x, int y) throws IOException {
        super("iron knife", "1H", tier, rarity, x, y,
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeIcon.png")),
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeMainHand.png")),
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeOffHand.png")));
        this.setValue(100);
        this.setPhysDmg(6);

    }
    public Knife(int tier, int x, int y) throws IOException {
        super("iron knife", "1H", tier, "normal", x, y,
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeIcon.png")),
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeMainHand.png")),
                 ImageIO.read(new File("resources\\Items\\Tier 1\\1H weapon\\knife\\knifeOffHand.png")));
        this.setValue(100);
        this.setPhysDmg(6);

    }

}
