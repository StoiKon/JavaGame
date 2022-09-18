/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationsSkillsRogue;

import animations.Animation;
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
public class DoubleStrikeSkillAnimation extends Animation {

    private BufferedImage left, right;

    public DoubleStrikeSkillAnimation(int x, int y) {
        super(x, y, 6 * 6000);

        this.right = null;
        this.left = null;

        try {
            left = ImageIO.read(new File("resources\\2.animations\\sword_slash\\0left.png"));
            right = ImageIO.read(new File("resources\\2.animations\\sword_slash\\1right.png"));

        } catch (IOException ex) {
            Logger.getLogger(DoubleStrikeSkillAnimation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paint(Graphics g) {

        if (this.getDuration() > 3 * 6000) {
            g.drawImage(right, this.getX(), this.getY()-100, null);
        } else {
            g.drawImage(left, this.getX() , this.getY()-100, null);
        }

    }

    @Override
    public void tick() {
        this.timePasses();

    }

}
