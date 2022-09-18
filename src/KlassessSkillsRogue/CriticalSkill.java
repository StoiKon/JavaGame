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
public class CriticalSkill extends Skill{
private Player player;    
    public CriticalSkill(Player player) {
        super(1, "passive");
        this.player=player;
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {

                
            }
        });
    }
    public void passiveEffect(){
    switch(this.getSkill_lvl()){
        case 1:
            player.addCritical_chance(player.getInte()/10);
        case 2:
            player.addCritical_chance(player.getInte()/15);
        case 3:
            player.addCritical_chance(player.getInte()/20);
        case 4:
            player.addCritical_chance(player.getInte()/10);
    }
    }

    @Override
    public String toString() {
        return "CriticalSkill{" +this.toString2()+ '}';
    }
    
}
