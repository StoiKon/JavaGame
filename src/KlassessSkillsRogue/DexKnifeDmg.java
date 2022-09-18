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
public class DexKnifeDmg extends Skill {

    private Player player;

    public DexKnifeDmg(Player player) {
        super(15, "passive");
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
                player.setBonusPhysDmg(player.getDex() * 1);
            case 2:
                player.setBonusPhysDmg(player.getDex() * 2);
            case 3:
                player.setBonusPhysDmg(player.getDex() * 3);
            case 4:
                player.setBonusPhysDmg(player.getDex() * 3 + 10);
        }
    }

    @Override
    public String toString() {
        return "DexKnifeDmg{"  +this.toString2()+ '}';
    }

}
