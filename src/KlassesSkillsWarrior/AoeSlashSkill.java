/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkillsWarrior;

import KlassesSkills.Skill;
import KlassesSkills.SkillEvent;
import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class AoeSlashSkill extends Skill{
private Player player;
    public AoeSlashSkill(Player player) {
        super(10, "active");
        this.player=player;
         this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {

                player.physAttack(e);
            }
        });
    }

    @Override
    public String toString() {
        return "AoeSlashSkill{" +this.toString2()+ '}';
    }
    
}
