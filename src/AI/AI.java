/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import animations.EntityAttack;
import gameObjects.Entity;
import java.util.ArrayList;
import source.Handler;
import tools.Position;

/**
 *
 * @author Name
 */
public class AI {

    private ArrayList<Entity> entities;
    private Handler handler;
    private Entity currentEntity;

    public AI(ArrayList<Entity> entities, Handler handler) {
        this.entities = entities;
        this.handler = handler;
    }

    public void tick() throws Exception {
        if (entities != null) {
            int x = handler.getPlayer().getX();
            int y = handler.getPlayer().getY();

            for (Entity e : entities) {
                this.currentEntity = e;
                if (!e.getFaction().equals("Capitalist")) {
                    if (e.getX() >= x) {

                        if (e.getY() > y) {
                            if (!collt(e.getX() - 1, e.getY() - 1)) {
                                e.setX(e.getX() - 1);
                                e.setY(e.getY() - 1);
                            }
                        } else if (e.getY() < y) {
                            if (!collt(e.getX() - 1, e.getY() + 1)) {
                                e.setX(e.getX() - 1);
                                e.setY(e.getY() + 1);
                            }
                        } else if (e.getY() == y) {
                            if (!collt(e.getX() - 1, e.getY())) {
                                e.setX(e.getX() - 1);
                            }
                        }
                    } else if (e.getX() < x) {
                        if (e.getY() > y) {
                            if (!collt(e.getX() + 1, e.getY() - 1)) {
                                e.setX(e.getX() + 1);
                                e.setY(e.getY() - 1);
                            }
                        } else if (e.getY() < y) {
                            if (!collt(e.getX() + 1, e.getY() + 1)) {
                                e.setX(e.getX() + 1);
                                e.setY(e.getY() + 1);
                            }
                        } else if (e.getY() == y) {
                            if (!collt(e.getX() + 1, e.getY())) {
                                e.setX(e.getX() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean collt(int x, int y) {

        int i = 0;

        if (handler.getPlayer().getX() == x && handler.getPlayer().getY() == y) {
            System.out.println("xy");
            if (this.currentEntity != null) {
                System.out.println("xy2");
                this.currentEntity.physAttack(handler.getPlayer());
                handler.addAnimation(new EntityAttack());
                return true;
                
            }
            
        }
        for (Entity e : entities) {
            if (e.getX() == x && e.getY() == y) {
                i++;
                if (i == 1) {
                    return true;
                }
            }
        }
        for (Position p : handler.getTileCollisions()) {
            if (p.getX() == x && p.getY() == y) {
                return true;
            }
        }
        return false;

    }
}
