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
public class ManaRegenAnimation extends Animation {

    public ManaRegenAnimation() {
        super(0, 0, 8 * 6000);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.magenta);
        for (int i=0;i<300;i+=100){
        g.drawRoundRect(850-i/2, 550-i/2, i, i, i, i);
        }
    }

    @Override
    public void tick() {
        timePasses();
    }

}
