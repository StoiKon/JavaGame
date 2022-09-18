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
public class StunSkill extends Skill {

    private Player player;

    public StunSkill(Player player) {
        super(5, "active");
        this.player = player;
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {
                if (around(player.getX(), player.getY(), e.getX(), e.getY())) {
                    player.physAttack(e);
                }
            }
        });
    }

    private boolean around(int x, int y, int x1, int y1) {
        return (x == x1) && (y == y1)
                || (x == x1 + 1) && (y == y1)
                || (x == x1 - 1) && (y == y1)
                || (x == x1) && (y == y1 + 1)
                || (x == x1) && (y == y1 - 1)
                || (x == x1 + 1) && (y == y1 + 1)
                || (x == x1 + 1) && (y == y1 - 1)
                || (x == x1 - 1) && (y == y1 + 1)
                || (x == x1 - 1) && (y == y1 - 1);
    }

    @Override
    public String toString() {
        return "StunSkill{" +this.toString2()+ '}';
    }
    
}
