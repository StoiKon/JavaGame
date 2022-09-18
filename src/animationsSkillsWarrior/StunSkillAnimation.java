/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationsSkillsWarrior;

import animations.Animation;
import java.awt.Graphics;

/**
 *
 * @author Name
 */
public class StunSkillAnimation extends Animation {

    public StunSkillAnimation(int x, int y) {
        super(x, y, 9 * 6000);
    }

    @Override
    public void paint(Graphics g) {
        if (this.getDuration() <= 6000) {
            g.drawRect(this.getX(), this.getY(), 100, 100);
        }
        if (this.getDuration() <= 2*6000) {
            g.drawRect(this.getX(), this.getY(), 110, 110);
        }
        if (this.getDuration() <= 3*6000) {
            g.drawRect(this.getX(), this.getY(), 120, 120);
        }
        if (this.getDuration() <= 4*6000) {
            g.drawRect(this.getX(), this.getY(), 130, 130);
        }
        if (this.getDuration() <= 5*6000) {
            g.drawRect(this.getX(), this.getY(), 140, 140);
        }
        if (this.getDuration() <= 6*6000) {
            g.drawRect(this.getX(), this.getY(), 150, 150);
        }
        if (this.getDuration() <= 7*6000) {
            g.drawRect(this.getX(), this.getY(), 160, 160);
        }
        if (this.getDuration() <= 8*6000) {
            g.drawRect(this.getX(), this.getY(), 170, 170);
        }
        if (this.getDuration() <= 9*6000) {
            g.drawRect(this.getX(), this.getY(), 180, 180);
        }
    }

    @Override
    public void tick() {
        timePasses();
    }

}
