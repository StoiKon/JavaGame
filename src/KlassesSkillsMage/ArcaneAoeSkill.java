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
public class ArcaneAoeSkill extends Skill {

    private Player player;

    public ArcaneAoeSkill(Player player) {
        super(15, "active");
        this.setCooldown(5);
        this.setCurrent_cooldown(0);
        this.setSkill_lvl(1);
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {

                e.reduceLife(spellDmg(getSkillLvl())+player.getMagicDamage());
            }
        });
        this.player=player;
    }

    private int getSkillLvl() {
        return this.getSkill_lvl();
    }

    public int spellDmg(int level) {
        switch (level) {
            case 1:
                return 50 + player.getMagicDamage();
            case 2:
                return 100 + player.getMagicDamage();
            case 3:
                return 125 + player.getMagicDamage();
            case 4:
                return 150 + player.getMagicDamage();

        }
        return 0;
    }

    @Override
    public String toString() {
        return "ArcaneAoeSkill{"  +this.toString2()+ '}';
    }
    

}
