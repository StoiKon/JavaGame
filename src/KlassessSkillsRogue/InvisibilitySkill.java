/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassessSkillsRogue;

import KlassesSkills.Skill;
import KlassesSkills.SkillEvent;
import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class InvisibilitySkill extends Skill{
    
     private Player player;

    public InvisibilitySkill(Player player) {
        super(20, "passive");
        this.player = player;
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {

            }
        });
    }

    @Override
    public String toString() {
        return "InvisibilitySkill{" +this.toString2()+ '}';
    }
    
}
