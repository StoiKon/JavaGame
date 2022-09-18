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
public class ManaRegenSkill extends Skill {

    public ManaRegenSkill(Player player) {
        super(5, "active");
        this.setCooldown(7);
        this.setCurrent_cooldown(0);
        this.setSkill_lvl(1);

        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

                if (player.getMana() <= player.getMaxMana()) {
                    player.setMana(player.getMana() + skillpower(skillLvl()));
                }

            }

            public void actionPerformed(Entity e) {

            }
        });
    }

    private int skillLvl() {
        return this.getSkill_lvl();
    }

    public int skillpower(int lvl) {
        switch (lvl) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 120;
            case 4:
                return 140;
            case 5:
                return 150;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "ManaRegenSkill{" +this.toString2()+ '}';
    }

}
