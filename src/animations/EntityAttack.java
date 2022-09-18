/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Name
 */
public class EntityAttack extends Animation{

    public EntityAttack() {
        super(800,500, 4*6000);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.drawRect(800, 500, 100, 100);
        g.setColor(Color.white);
    }

    @Override
    public void tick() {
        timePasses();
    }
    
}
