/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkillsMage;

import KlassesSkills.*;

import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class ArcaneBeamSkill extends Skill {

    private Player player;

    public ArcaneBeamSkill(Player player) {

        super(1, "active");//lvl requirement , type
        this.setCooldown(2);
        this.setCurrent_cooldown(0);
        this.setSkill_lvl(1);
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {
              player.reduceMana(15);  
            }

            public void actionPerformed(Entity e) {
                player.reduceMana(15);
                if (player.getMana() >= 0) {
                    e.reduceLife(spellDmg(getSkillLvl()) + player.getMagicDamage() - e.getArmour());
                }

            }
        });

    }

    private int getSkillLvl() {
        return this.getSkill_lvl();
    }

    public int spellDmg(int level) {
        switch (level) {
            case 1:
                return 50;
            case 2:
                return 100;
            case 3:
                return 125;
            case 4:
                return 150;

        }
        return 0;
    }

    @Override
    public String toString() {
        return "ArcaneBeamSkill{" +this.toString2()+ '}';
    }
    

}
