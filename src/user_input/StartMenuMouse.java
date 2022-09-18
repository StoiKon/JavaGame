/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user_input;

import displays.Button;
import displays.StartMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Name
 */
public class StartMenuMouse implements MouseListener{
private StartMenu startMenu;
private Button b=null;

    public StartMenuMouse(StartMenu startMenu) {
        this.startMenu = startMenu;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
       
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int x=e.getX();
        int y=e.getY();
        b=startMenu.getButton(x, y);
        if(b!=null){
        b.action();
        }
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        b=null;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
