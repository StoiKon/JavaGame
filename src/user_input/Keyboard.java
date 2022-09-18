/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_input;

import KlassesSkills.Skill;
import KlassesSkillsMage.ArcaneBeamSkill;
import animations.SlashAnimation;
import animationsSkillsMage.ArcaneAoeAnimation;
import animationsSkillsMage.ArcaneBeamAnimation;
import animationsSkillsMage.ManaRegenAnimation;
import gameObjects.Entity;
import items.Item;
import java.awt.MouseInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import source.Handler;
import tools.Position;
import world.Dungeon;

/**
 *
 * @author Name
 */
public class Keyboard implements KeyListener {

    private Handler handler;
    private int level = 0;
    private Dungeon current_dungeon = null;

    public Keyboard(Handler handler) {
        this.handler = handler;
    }
//all movement checks here

    public boolean checkBeforeYouMove(int x, int y) {
//item bumping
        itemBumping(x, y);
//player stays inside map area
        return this.stayInsideMapBounds(x, y) && !tileCollision(x, y) && !entityBumping(x, y);

    }
// these are the checks

    public boolean stayInsideMapBounds(int x, int y) {

        return (x >= 0 && x < handler.getMapWidth()) && (y >= 0 && y < handler.getMapHeight());
        //return true;
    }

    public boolean tileCollision(int x, int y) {
        for (Position p : handler.getTileCollisions()) {
            if (p.getX() == x && p.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean entityBumping(int x, int y) {
        for (Entity e : handler.getEntities()) {
            if (e.getX() == x && e.getY() == y) {
                return true;
            }
        }
        return false;
    }

    public boolean entityBumping(int x, int y, Entity entity) {

        if (entity.getX() == x && entity.getY() == y) {
            return true;
        }

        return false;
    }

    public Entity getEntity(int x, int y) {
        for (Entity e : handler.getEntities()) {
            if (e.getX() == x && e.getY() == y) {
                return e;
            }
        }
        return null;
    }

    public void itemBumping(int x, int y) {
        if (!handler.getPlayer().getInventory().isFull()) {
            Item item = null;
            for (Item drop : handler.getDroppedItems()) {
                if (drop.getX() == x && drop.getY() == y) {
                    handler.getPlayer().pickUp(drop);
                    item = drop;
                }

            }

            if (item != null) {
                handler.getDroppedItems().remove(item);
            }
        }
    }

    public boolean entityBumping_withBattle(int x, int y) {
        for (Entity e : handler.getEntities()) {
            if (e.getX() == x && e.getY() == y && hostileFanction(e.getFaction())) {
                handler.getPlayer().physAttack(e);
                return true;
            }
            if (e.getX() == x && e.getY() == y && e.getFaction() == "Capitalist") {
                handler.toggleShopMenu(true, e);
            }
        }
        return false;
    }

    public boolean hostileFanction(String fanction) {
        return fanction.equals("hostile");//more to be added later
    }
// what happens when someone slams their head on the keyboard

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        handler.toggleShopMenu(false, null);
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            if (handler.is_onWorldMap()) {
                for (Dungeon d : handler.dungeons()) {
                    if (d.getX() == handler.getPlayer().getX() && d.getY() == handler.getPlayer().getY()) {
                        handler.setCurrentMap(d.getMap(0));
                        level++;
                        this.current_dungeon = d;
                    }
                }

            }
            if (this.current_dungeon != null) {
                if (handler.getTile(handler.getPlayer().getX(), handler.getPlayer().getY()).equals("e")) {
                    if (this.current_dungeon.getMap(level) != null) {
                        handler.setCurrentMap(this.current_dungeon.getMap(level));
                        handler.getPlayer().setX(2);
                        handler.getPlayer().setY(2);
                        level++;
                        System.out.println(level);
                    } else {
                        handler.worldMap();
                        handler.getPlayer().setX(current_dungeon.getX());
                        handler.getPlayer().setY(current_dungeon.getY());
                        level = 0;
                        this.current_dungeon=null;
                    }
                }
            }
        }

        //skills
        if (e.getKeyCode() == KeyEvent.VK_1) {
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

            //handler.addAnimation(new ArcaneBeamAnimation(x, y));
            int i = x / 100 - 8 + handler.getPlayer().getX();
            int j = y / 100 - 5 + handler.getPlayer().getY();

            //Skill skill = new ArcaneBeamSkill(handler.getPlayer());
            if (getEntity(i, j) != null) {
                handler.getPlayer().performSkill(handler, x, y, (getEntity(i, j)), 0);

            } else {
                handler.getPlayer().performSkill(handler, x, y, 0);
            }
            handler.ai_tick();
        }
        if (e.getKeyCode() == KeyEvent.VK_2) {
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

            //handler.addAnimation(new ArcaneBeamAnimation(x, y));
            int i = x / 100 - 8 + handler.getPlayer().getX();
            int j = y / 100 - 5 + handler.getPlayer().getY();

            //Skill skill = new ArcaneBeamSkill(handler.getPlayer());
            if (getEntity(i, j) != null) {
                handler.getPlayer().performSkill(handler, x, y, (getEntity(i, j)), 1);

            } else {
                handler.getPlayer().performSkill(handler, x, y, 1);
            }
            handler.ai_tick();

        }
        //Aoe key put aoe skills in 3
        if (e.getKeyCode() == KeyEvent.VK_3) {
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

            //handler.addAnimation(new ArcaneBeamAnimation(x, y));
            // int i = x / 100 - 8 + handler.getPlayer().getX();
            //int j = y / 100 - 5 + handler.getPlayer().getY();
            handler.getPlayer().performSkill(handler, x, y, 2);
            //Skill skill = new ArcaneBeamSkill(handler.getPlayer());
            int size = handler.getEntities().size();

            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < handler.getEntities().size(); i++) {
                    if (i < handler.getEntities().size()) {
                        if (this.entityBumping(handler.getPlayer().getX() + j, handler.getPlayer().getY(), handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX() - j, handler.getPlayer().getY(), handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX(), handler.getPlayer().getY() + j, handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX(), handler.getPlayer().getY() - j, handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX() + j, handler.getPlayer().getY() + j, handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX() - j, handler.getPlayer().getY() - j, handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX() + j, handler.getPlayer().getY() - j, handler.getEntities().get(i))
                                || this.entityBumping(handler.getPlayer().getX() - j, handler.getPlayer().getY() + j, handler.getEntities().get(i))) {
                            if (handler.getEntities().get(i) != null && this.hostileFanction(handler.getEntities().get(i).getFaction())) {
                                handler.getPlayer().performSkill(handler, handler.getPlayer().getX(), handler.getPlayer().getY(), handler.getEntities().get(i), 2);
                                try {
                                    handler.checkForDeadEntities();
                                } catch (Exception exception) {
                                    System.out.println("this has started to get on my nerves");
                                }
                            }
                        }
                    }
                }
            }
            handler.ai_tick();

        }
        if (e.getKeyCode() == KeyEvent.VK_4) {
            int x = (int) MouseInfo.getPointerInfo().getLocation().getX();
            int y = (int) MouseInfo.getPointerInfo().getLocation().getY();

            //handler.addAnimation(new ArcaneBeamAnimation(x, y));
            int i = x / 100 - 8 + handler.getPlayer().getX();
            int j = y / 100 - 5 + handler.getPlayer().getY();

            //Skill skill = new ArcaneBeamSkill(handler.getPlayer());
            if (getEntity(i, j) != null) {
                handler.getPlayer().performSkill(handler, x, y, (getEntity(i, j)), 3);

            } else {
                handler.getPlayer().performSkill(handler, x, y, 3);
                System.out.println("here");
            }
            handler.ai_tick();
        }

        //menus
        if (e.getKeyCode() == KeyEvent.VK_I) {
            handler.openInventoryMenu();
        }
        if (e.getKeyCode() == KeyEvent.VK_P) {
            handler.toggleStatsMenu();

        }
        //movement
        if (e.getKeyCode() == KeyEvent.VK_W) {

            if (checkBeforeYouMove(handler.getPlayer().getX(), handler.getPlayer().getY() - 1)) {
                handler.getPlayer().addPos(0, -1);
            }
            //attack animation
            if (entityBumping_withBattle(handler.getPlayer().getX(), handler.getPlayer().getY() - 1)) {
                handler.addAnimation(new SlashAnimation(800, 500, 'u'));
            }
            //up
            handler.ai_tick();

        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            if (checkBeforeYouMove(handler.getPlayer().getX(), handler.getPlayer().getY() + 1)) {
                handler.getPlayer().addPos(0, +1);
            }
            //attack animation
            if (entityBumping_withBattle(handler.getPlayer().getX(), handler.getPlayer().getY() + 1)) {
                handler.addAnimation(new SlashAnimation(800, 500, 'd'));
            }
            //down
            handler.ai_tick();

        }
        if (e.getKeyCode() == KeyEvent.VK_A) {
            if (checkBeforeYouMove(handler.getPlayer().getX() - 1, handler.getPlayer().getY())) {
                handler.getPlayer().addPos(-1, 0);
            }
            //attack animation
            if (entityBumping_withBattle(handler.getPlayer().getX() - 1, handler.getPlayer().getY())) {
                handler.addAnimation(new SlashAnimation(800, 500, 'l'));
            }
            //left
            handler.ai_tick();

        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            //right
            if (checkBeforeYouMove(handler.getPlayer().getX() + 1, handler.getPlayer().getY())) {
                handler.getPlayer().addPos(+1, 0);
            }
            //attack animation
            if (entityBumping_withBattle(handler.getPlayer().getX() + 1, handler.getPlayer().getY())) {
                handler.addAnimation(new SlashAnimation(800, 500, 'r'));
            }
            handler.ai_tick();
        }
        //System.out.println("x " + handler.getPlayer().getX() + "y " + handler.getPlayer().getY()); checking
        handler.checkForDeadEntities();

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
