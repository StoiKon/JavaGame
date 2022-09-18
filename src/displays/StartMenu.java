package displays;

import source.Game;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import user_input.StartMenuMouse;

public class StartMenu {

    private Image im_background;
    private Game game;
    private ArrayList<Button> buttons_List;
    private StartMenuMouse mickeyMouse;

    public StartMenu(Game game) {
        //adding buttons
        buttons_List = new ArrayList<Button>();
        addButton(440, 575, 200, 100, " new Game");
        addButton(740, 575, 200, 100, "load Game");
        addButton(1040, 575, 200, 100, " options ");
        addButton(440, 775, 200, 100, "   exit  ");
        this.setAction(new Action(){
        public void go(){
        game.setMenu_int(1);
        }
        }, 0);
        this.setAction(new Action(){
        public void go(){
        game.setMenu_int(2);
        }
        }, 1);
        this.setAction(new Action(){
        public void go(){
        game.setMenu_int(3);
        }
        }, 2);
        this.setAction(new Action(){
        public void go(){
        game.setMenu_int(4);
        }
        }, 3);
        //Mouse Listener
        mickeyMouse=new StartMenuMouse(this);

        try {
            this.im_background = ImageIO.read(new File("resources\\StartinMenu\\background.png"));
        } catch (IOException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("you fucked up, dickhead : displays StartMenu Image");
        }
        this.game = game;

    }
    //add buttons to the display
    private void addButton(int x, int y, int width, int height, String text) {
        buttons_List.add(new Button(x, y, width, height, text));
        
    }
    private void addButton(Button b) {
        buttons_List.add(b);
        
    }
    //set action listener to buttons
    private void setAction(Action a,int index){
        buttons_List.get(index).setAction(a);
    }

    public Button getButton(int x, int y) {
        for (Button b : buttons_List) {
            if (x >= b.getX()
                    && x <= b.getX() + b.getWidth()
                    && y >= b.getY()
                    && y <= b.getY() + b.getHeight()) {
                return b;
            }
        }
        return null;
    }

    public void paint(Graphics g) {
        g.drawImage(im_background, 0, 0, game);
        //drawing buttons
        for (Button b : buttons_List) {
            b.paint(g);
        }
    }

    public StartMenuMouse getMouseL() {
        return mickeyMouse;
    }
    

}
