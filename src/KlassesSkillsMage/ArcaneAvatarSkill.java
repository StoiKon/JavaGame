/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkillsMage;

import KlassesSkills.Skill;
import KlassesSkills.SkillEvent;
import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class ArcaneAvatarSkill extends Skill {

    private Player player;

    public ArcaneAvatarSkill(Player player) {
        super(10, "passive");
        this.player = player;
        

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
            player.setInte(player.getInte()+3);
        case 2:
            player.setInte(player.getInte()+3);
        case 3:
            player.setInte(player.getInte()+3);
        case 4:
            player.setInte(player.getInte()+3);
    }
    }

    @Override
    public String toString() {
        return "ArcaneAvatarSkill{" +this.toString2()+ '}';
    }

}
