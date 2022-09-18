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
public class ExecuteSkill extends Skill {

    private Player player;

    public ExecuteSkill(Player player) {
        super(20, "active");
        this.setEvent(new SkillEvent() {
            public void actionPerformed() {

            }

            public void actionPerformed(Entity e) {
                if (around(player.getX(), player.getY(), e.getX(), e.getY())) {
                    e.reduceLife(e.getLife() * margin() / 10);
                }

            }
        });
    }

    private int margin() {
        switch (this.getSkill_lvl()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 2;
            case 4:
                return 3;
            default:
                return 0;
        }
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
        return "ExecuteSkill{" +this.toString2()+ '}';
    }
    
}
