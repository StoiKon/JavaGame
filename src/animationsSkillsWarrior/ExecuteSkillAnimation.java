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
public class ExecuteSkillAnimation extends Animation{

    public ExecuteSkillAnimation(int x, int y) {
        super(x, y, 6*6000);
    }

    @Override
    public void paint(Graphics g) {
        
    }

    @Override
    public void tick() {
        timePasses();
    }
    
}
