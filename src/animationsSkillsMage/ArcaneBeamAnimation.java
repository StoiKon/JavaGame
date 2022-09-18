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
public class ArcaneBeamAnimation extends Animation {

    private int x_destination, y_destination;

    public ArcaneBeamAnimation(int x_dest, int y_dest) {
        super(800, 500, 9 * 6000);
        this.x_destination = x_dest;
        this.y_destination = y_dest;
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.magenta);

        g.fillRoundRect(860, 550, 20, 20, 20, 20);
        //destination blast
        for(int i=0;i<41;i++){
            g.fillRoundRect(x_destination-20, y_destination-20, i, i,40, 40);
        }
        for (int i = 0; i < 11; i++) {
            if (i >= 4 && i <= 6) {
                g.setColor(Color.white);
            } else {
                g.setColor(Color.magenta);
            }
            g.drawLine(865 + 2, 555 + 2 + i, x_destination, y_destination + i);
        }
        g.setColor(Color.white);
        g.fillRoundRect(x_destination-10, y_destination-10, 20, 20,40, 40);
        
    }

    @Override
    public void tick() {
        this.timePasses();
    }

}
