/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author Name
 */
public class TextOption {

    private int x, y;
    private boolean selected = false;
    private String text;
    private Action action;

    public TextOption(int x, int y, String text) {
        this.x = x;
        this.y = y;
        this.text = text;
    }

    public void paint(Graphics g) {
        if (selected) {
            g.setColor(Color.black);
            g.fillRect(x, y-15 , text.length() * 10, 20);
        }
        g.setColor(Color.white);
        g.drawString(text, x, y);

    }

    //add action listenner
    public void setAction(Action a) {
        this.action = a;
    }

    //perform action
    public void action() {
        System.out.println("clicked TextOption");
        if (action != null) {
            action.go();
        }

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getText() {
        return text;
    }

    public void toggle() {
        this.selected = !selected;
    }
    public void toggle(boolean selected) {
        this.selected = selected;
    }

}
