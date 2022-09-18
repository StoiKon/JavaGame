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
import KlassesSkillsWarrior.AoeSlashSkill;
import KlassesSkillsWarrior.ExecuteSkill;
import KlassesSkillsWarrior.StunSkill;
import KlassesSkillsWarrior.TenacitySkill;
import animations.Animation;
import animationsSkillsMage.ArcaneAoeAnimation;
import animationsSkillsMage.ArcaneAvatarAnimation;
import animationsSkillsMage.ArcaneBeamAnimation;
import animationsSkillsMage.ManaRegenAnimation;
import animationsSkillsWarrior.AoeSlashSkillAnimation;
import animationsSkillsWarrior.ExecuteSkillAnimation;
import animationsSkillsWarrior.StunSkillAnimation;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class WarriorSkillSet extends SkilSet{

    public WarriorSkillSet(Player player) {
    this.addSkill(new TenacitySkill(player));
    this.addSkill(new StunSkill(player));
    this.addSkill(new AoeSlashSkill(player));
    this.addSkill(new ExecuteSkill(player));
    
    
    }
    @Override
   public Animation getAnimation(int x,int y,int index){
   switch(index){
       case 0:
           return null;
       case 1:
           return new StunSkillAnimation(x,y);
       case 2:
           return new AoeSlashSkillAnimation();
       case 3:
           return new ExecuteSkillAnimation(x,y);
       default:
           return null;
   }
   }
}
