/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationsSkillsMage;

import animations.Animation;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Name
 */
public class ArcaneAoeAnimation extends Animation {

    public ArcaneAoeAnimation() {
        super(0, 0, 9 * 6000);
    }

    @Override
    public void paint(Graphics g) {

        for (int i = 0; i < 300; i+=10) {
            if (i % 20 == 0) {
                g.setColor(Color.magenta);
            }else{g.setColor(Color.red);}

            g.drawRoundRect(850 - i / 2, 550 - i / 2, i, i, i, i);
        }
    }

    @Override
    public void tick() {
        this.timePasses();
    }

}
