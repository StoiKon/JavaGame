/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import gameObjects.Player;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class DeathAnimation extends Animation {

    private BufferedImage blood;
    private char direction;
    private static Player p;

    public DeathAnimation(int x, int y, Player p) {
        super(x, y, 9 * 6000);
        this.p = p;
        try {
            blood = ImageIO.read(new File("resources\\2.animations\\death\\blood\\blood.png"));

        } catch (IOException ex) {
            Logger.getLogger(DeathAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(blood, this.getX() - p.getX()*100, this.getY() - p.getY()*100, null);
    }

    @Override
    public void tick() {
        this.timePasses();
    }

}
