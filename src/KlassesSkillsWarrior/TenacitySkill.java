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
public class TenacitySkill extends Skill {

    private Player player;

    public TenacitySkill(Player player) {
        super(1, "passive");
        this.player = player;
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {

            }
        });
    }

    public void passiveEffect() {
        switch (this.getSkill_lvl()) {
            case 1:
                player.setMaxLife(player.getMaxLife() * (12 / 10));
            case 2:
                player.setMaxLife(player.getMaxLife() * (12 / 10));
            case 3:
                player.setMaxLife(player.getMaxLife() * (12 / 10));
            case 4:
                player.setMaxLife(player.getMaxLife() * (12 / 10));
        }
    }

    @Override
    public String toString() {
        return "Tenacity {" +this.toString2()+ '}';
    }

}
