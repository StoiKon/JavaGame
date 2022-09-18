/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Name
 */
public class SlashAnimation extends Animation {

    private BufferedImage left, right, up, down;
    private char direction;
    

    public SlashAnimation(int x, int y, char direction) {
        super(x, y, 3*6000);
        this.down = null;
        this.up = null;
        this.right = null;
        this.left = null;
        this.direction=direction;
        try {
            switch (direction) {
                case 'l':
                    left=ImageIO.read(new File("resources\\2.animations\\sword_slash\\0left.png"));
                    break;
                case 'r':
                    right=ImageIO.read(new File("resources\\2.animations\\sword_slash\\1right.png"));
                    break;
                case 'u':
                    up=ImageIO.read(new File("resources\\2.animations\\sword_slash\\2up.png"));
                    break;
                case 'd':
                    down=ImageIO.read(new File("resources\\2.animations\\sword_slash\\3down.png"));
                    break;
            }
        } catch (Exception error) {
            System.out.println("this lousy stupid shitty slash animation didnt what did you do wrong mr programmer");
        }
    }

    @Override
    public void paint(Graphics g) {
        
        switch (direction) {
                case 'l':
                    g.drawImage(left, this.getX()-100, this.getY(), null);
                    break;
                case 'r':
                    g.drawImage(right, this.getX()+100, this.getY(), null);
                    break;
                case 'u':
                    g.drawImage(up, this.getX(), this.getY()-100, null);
                    break;
                case 'd':
                    g.drawImage(down, this.getX(), this.getY()+100, null);
                    break;
            }
    }

    @Override
    public void tick() {
        this.timePasses();
        
    }

}
