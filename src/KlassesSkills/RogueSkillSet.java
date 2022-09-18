/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkills;

import KlassessSkillsRogue.CriticalSkill;
import KlassessSkillsRogue.DexKnifeDmg;
import KlassessSkillsRogue.DoubleStrikeSkill;
import KlassessSkillsRogue.InvisibilitySkill;
import animations.Animation;
import animationsSkillsMage.ArcaneAoeAnimation;
import animationsSkillsMage.ArcaneAvatarAnimation;
import animationsSkillsMage.ArcaneBeamAnimation;
import animationsSkillsMage.ManaRegenAnimation;
import animationsSkillsRogue.DoubleStrikeSkillAnimation;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class RogueSkillSet extends SkilSet{

    public RogueSkillSet(Player player) {
    this.addSkill(new CriticalSkill(player));
    this.addSkill(new DoubleStrikeSkill(player));
    this.addSkill(new DexKnifeDmg(player));
    this.addSkill(new InvisibilitySkill(player));
    }
    public Animation getAnimation(int x,int y,int index){
   switch(index){
       case 0:
           return null;
       case 1:
           return new DoubleStrikeSkillAnimation(x,y);
       case 2:
           return null;
       case 3:
           return null;
       default:
           return null;
   }
   }
}
