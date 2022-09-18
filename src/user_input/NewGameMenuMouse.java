/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_input;

import displays.Button;
import displays.NewGameMenu;
import displays.TextOption;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class NewGameMenuMouse implements MouseListener{
private NewGameMenu newgame;
private Button b;
private TextOption t;
    public NewGameMenuMouse(NewGameMenu newgame) {
        this.newgame = newgame;
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        t=newgame.getTextOption(x, y);
        if(t!=null){
        t.action();
        
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
        
        //BUTTONS
        int x=e.getX();
        int y=e.getY();
        System.out.println("x "+e.getX());
        System.out.println("y "+e.getY());
        b=newgame.getButton(x, y);
        if(b!=null){
        b.action();
        }
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Button
        b=null;
        
        //TextOption
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
