/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;

/**
 *
 * @author Name
 */
public class Button {
private int x,y;
private int width,height;
private String text;
private Color front_color,back_color;
private Color string_color;
//what to do when clicked
private Action action;


    public Button(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        front_color=Color.BLACK;
        back_color=Color.white;
        string_color=Color.white;
        
        
    }


public void paint(Graphics g){
    g.setColor(back_color);
    g.fillRect(x, y, width, height);
    g.setColor(front_color);
    g.fillRect(x+3, y+3, width-6, height-6);
    g.setColor(string_color);
    g.drawString(text, x+width/3, y+3+height/2);
}

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    //add action listenner
    public void setAction(Action a){
    this.action=a;
    }
    //perform action
    public void action() {
        System.out.println("clicked button");
        if(action!=null){
        action.go();
        }
        
        
        
    }

    

    
    
    
}
