/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import source.Handler;

/**
 *
 * @author Name
 */
public class PlayerStats_n_SkillsMenuMouseL implements MouseListener {

    private Handler handler;
    PlayerStats_n_SkillsMenu menu;

    PlayerStats_n_SkillsMenuMouseL(Handler handler, PlayerStats_n_SkillsMenu menu) {
        this.handler = handler;
        this.menu = menu;
    }

    private boolean inside(int x, int y, int bx, int by, int height, int width) {
        return ((x >= bx) && (x <= bx + width)) && ((y >= by) && (y <= by + height));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x = e.getX(), y = e.getY();
        System.out.println("x->"+x+"\ny->"+y);
        if (inside(x, y, menu.getStrBut().getX()
                , menu.getStrBut().getY()
                , menu.getStrBut().getHeight()
                , menu.getStrBut().getWidth())) {
            menu.getStrBut().action();
        }else if (inside(x, y, menu.getDexBut().getX()
                , menu.getDexBut().getY()
                , menu.getDexBut().getHeight()
                , menu.getDexBut().getWidth())) {
            menu.getDexBut().action();
        }else if (inside(x, y, menu.getVitBut().getX()
                , menu.getVitBut().getY()
                , menu.getVitBut().getHeight()
                , menu.getVitBut().getWidth())) {
            menu.getVitBut().action();
        }else if (inside(x, y, menu.getStamBut().getX()
                , menu.getStamBut().getY()
                , menu.getStamBut().getHeight()
                , menu.getStamBut().getWidth())) {
            menu.getStamBut().action();
        }else if(inside(x, y, menu.getStrBut().getX()
                , menu.getInteBut().getY()
                , menu.getInteBut().getHeight()
                , menu.getInteBut().getWidth())) {
            menu.getInteBut().action();
        }
        if(inside(x, y, menu.getSkill_1().getX()
                , menu.getSkill_1().getY()
                , menu.getSkill_1().getHeight()
                , menu.getSkill_1().getWidth())) {
            menu.getSkill_1().action();}
        if(inside(x, y, menu.getSkill_1().getX()
                , menu.getSkill_2().getY()
                , menu.getSkill_2().getHeight()
                , menu.getSkill_2().getWidth())) {
            menu.getSkill_2().action();}
        if(inside(x, y, menu.getSkill_3().getX()
                , menu.getSkill_3().getY()
                , menu.getSkill_3().getHeight()
                , menu.getSkill_3().getWidth())) {
            menu.getSkill_3().action();}
        if(inside(x, y, menu.getSkill_4().getX()
                , menu.getSkill_4().getY()
                , menu.getSkill_4().getHeight()
                , menu.getSkill_4().getWidth())) {
            menu.getSkill_4().action();}
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
