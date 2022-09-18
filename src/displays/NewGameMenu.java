/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

import Klasses.Mage;
import Klasses.Rogue;
import Klasses.Warrior;
import gameObjects.Player;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import source.Game;
import user_input.NewGameMenuMouse;


/**
 *
 * @author Name
 */
public class NewGameMenu {

    private Game game;
    private Image im_background;
    private ArrayList<Button> buttons_List;
    private ArrayList<TextOption> textOptions_List;
    private NewGameMenuMouse mickeyMouse;
    private String race = "null";
    private String clasS = "null";
    private Image warrior_icon;

    public NewGameMenu(Game game) {
        this.game = game;
        try {
            warrior_icon = ImageIO.read(new File("resources\\New game\\warrior_icon.png"));
        } catch (IOException ex) {
            System.out.println("the images didnt load");
        }

        //buttons
        buttons_List = new ArrayList<Button>();
        this.addButton(1200, 880, 200, 100, "Play");
        this.setButtonAction(new Action() {
            public void go() {
                if (!race.equals("null") && !clasS.equals("null")) {
                    switch (clasS) {
                        case "Warrior":
                            
                            game.setPlayer(new Player(0, 0, "name", race, new Warrior(), "player"));
                            break;
                            case "Rogue":
                            game.setPlayer(new Player(0, 0, "name", race, new Rogue(), "player"));
                            break;
                            case "Mage":
                            game.setPlayer(new Player(0, 0, "name", race, new Mage(), "player"));
                            break;
                    }
                    game.setMenu_int(-1);
                }
            }
        }, 0);

        //TextOptions
        textOptions_List = new ArrayList<TextOption>();

        this.addTextOption(30, 120, "Human");
        this.setTextOptionAction(new Action() {
            public void go() {
                race = "Human";
                toggleOptions();

            }
        }, 0);

        this.addTextOption(480, 120, "Warrior");
        this.setTextOptionAction(new Action() {
            public void go() {
                clasS = "Warrior";
                toggleOptions();

            }
        }, 1);

        this.addTextOption(30, 140, "Elf");
        this.setTextOptionAction(new Action() {
            public void go() {
                race = "Elf";
                toggleOptions();

            }
        }, 2);

        this.addTextOption(480, 140, "Rogue");
        this.setTextOptionAction(new Action() {
            public void go() {
                clasS = "Rogue";
                toggleOptions();

            }
        }, 3);

        this.addTextOption(480, 160, "Mage");
        this.setTextOptionAction(new Action() {
            public void go() {
                clasS = "Mage";
                toggleOptions();

            }
        }, 4);

        //background image
        try {
            this.im_background = ImageIO.read(new File("resources\\New game\\background.png"));
        } catch (IOException ex) {
            Logger.getLogger(StartMenu.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("you fucked up, dickhead : displays StartMenu Image");
        }
        //mouseListener
        this.mickeyMouse = new NewGameMenuMouse(this);
    }

    private void addButton(int x, int y, int width, int height, String text) {
        buttons_List.add(new Button(x, y, width, height, text));

    }

    //set action listener to buttons
    private void setButtonAction(Action a, int index) {
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

    //set action listener to textOptions
    private void addTextOption(int x, int y, String text) {
        this.textOptions_List.add(new TextOption(x, y, text));
    }

    private void setTextOptionAction(Action a, int index) {
        this.textOptions_List.get(index).setAction(a);
    }

    public TextOption getTextOption(int x, int y) {
        for (TextOption t : textOptions_List) {
            if (x >= t.getX()
                    && x <= t.getX() + t.getText().length() * 10
                    && y >= t.getY() - 10
                    && y <= t.getY() + 10) {
                return t;
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
        for (TextOption t : this.textOptions_List) {
            t.paint(g);
        }
        if (this.clasS.equals("Warrior")) {
            g.drawImage(warrior_icon, 1186, 50, game);
            g.drawString("Warriors are powerfull characters", 909, 272);
            g.drawString("that specialize in physical combat\n", 909, 284);
            g.drawString("while having a lot of armour", 909, 296);
        }

    }

    public NewGameMenuMouse getMouseL() {
        return mickeyMouse;
    }

    //automatically show which options are selected
    private void toggleOptions() {
        TextOption reis = null, klass = null;
        for (TextOption t : this.textOptions_List) {
            t.toggle(false);
            if (t.getText().equals(this.race)) {
                reis = t;
            }
            if (t.getText().equals(this.clasS)) {
                klass = t;
            }

        }
        if (reis != null) {
            reis.toggle(true);
        }
        if (klass != null) {
            klass.toggle(true);
        }
    }

}
