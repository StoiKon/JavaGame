/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animations;

import java.awt.Graphics;

/**
 *
 * @author Name
 */
public abstract class Animation {
    private int x;
    private int y;
    private int duration;
    public Animation(int x, int y,int duration) {
        this.x = x;
        this.y = y;
        this.duration=duration;//*6000;
    }
public abstract void paint(Graphics g);
public abstract void tick();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDuration() {
        return duration;
    }
    public void timePasses(){
    duration--;
    }

}
