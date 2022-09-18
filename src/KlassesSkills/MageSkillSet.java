/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkills;

import KlassesSkillsMage.ArcaneAoeSkill;
import KlassesSkillsMage.ArcaneAvatarSkill;
import KlassesSkillsMage.ArcaneBeamSkill;
import KlassesSkillsMage.ManaRegenSkill;
import animations.Animation;
import animationsSkillsMage.ArcaneAoeAnimation;
import animationsSkillsMage.ArcaneAvatarAnimation;
import animationsSkillsMage.ArcaneBeamAnimation;
import animationsSkillsMage.ManaRegenAnimation;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class MageSkillSet extends SkilSet{

    public MageSkillSet(Player player) {
    this.addSkill(new ArcaneBeamSkill(player));
    this.addSkill(new ManaRegenSkill(player));
    this.addSkill(new ArcaneAoeSkill(player));
    this.addSkill(new ArcaneAvatarSkill(player));
    
    
    }
    @Override
   public Animation getAnimation(int x,int y,int index){
   switch(index){
       case 0:
           return new ArcaneBeamAnimation(x,y);
       case 1:
           return new ManaRegenAnimation();
       case 2:
           return new ArcaneAoeAnimation();
       case 3:
           return new ArcaneAvatarAnimation();
       default:
           return null;
   }
   }
}
