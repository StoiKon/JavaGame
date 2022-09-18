/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animationsSkillsMage;

import animations.Animation;
import java.awt.Graphics;

/**
 *
 * @author Name
 */
public class ArcaneAvatarAnimation extends Animation{

    public ArcaneAvatarAnimation() {
        super(0, 0, 3*6000);
    }

    @Override
    public void paint(Graphics g) {
        
    }

    @Override
    public void tick() {
        this.timePasses();
    }
    
}
