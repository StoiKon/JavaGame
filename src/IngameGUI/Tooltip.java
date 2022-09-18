/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

/**
 *
 * @author Name
 */
//to be used in handler class
public class Tooltip {

    private String string;
    private int x, y;
    
    public Tooltip(int x, int y, String string) {
        this.string = string;
        this.x = x;
        this.y = y;
    }

    public String getString() {
        return string;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    

}
