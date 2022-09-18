package source;

import displays.NewGameMenu;
import displays.StartMenu;
import gameObjects.Player;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;


/*
 * why are these stupid comment even here
 */
/**
 *
 * @author Name
 */
public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1680, HEIGHT = 1050;
    private Thread thread;
    private boolean running = false;
    //window
    private Window window;
    //menus
    private StartMenu startmenu;
    private NewGameMenu newgamemenu;
    /*menu option 
    -1=game
    0=starting menu      
    1=new game
    2=load game
    3=options
    4=exit
    
    
     */
    private int menu_handling = 0;
    //
    private Handler handler;

    public Game() {
        //starting the game with the menu
        startmenu = new StartMenu(this);
        newgamemenu = new NewGameMenu(this);
        this.addMouseListener(startmenu.getMouseL());
        window = new Window(WIDTH, HEIGHT, "Winter", this);

    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;

    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running) {
                render();

            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    public static void main(String[] args) {
        new Game();

    }

    private void tick() {
        if (handler != null) {
            handler.tick();
        }

    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(4);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        //no flashing shit default background
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.red);
        g.drawString("Loading", 100, 950);

        //interfases first     
        //menus choosing which menu to show
        
        switch (menu_handling) {
            case -1://show game
                handler.paint_all(g);
                break;
            case 0:
                if (this.startmenu != null) {
                    this.startmenu.paint(g);
                }
                break;
            case 1:
                if (this.newgamemenu != null) {
                    this.newgamemenu.paint(g);
                }

                break;
            default:

        }

        //pop up windows
        //g.setColor(Color.red);
        //g.fillRect(0, 0, 100, 100);
        //drop here shit you want shown like world character and npcs
        g.dispose();
        bs.show();

    }

    public Window getWindow() {
        return window;
    }
    //handling menus

    public void setMenu_int(int neue) {
        //free previous memory
        switch (menu_handling) {
            case 0:
                this.removeMouseListener(startmenu.getMouseL());
                this.startmenu = null;
                break;
            case 1:
                this.removeMouseListener(newgamemenu.getMouseL());
                this.newgamemenu = null;
                break;
            case 2:
                break;
            case 3:
                break;

        }
        //load new menu
        switch (neue) {
            case -1:
                //initialise handler
                //handler inited via setPlayer function
                break;
            case 0:
                this.loadStartMenu();
                break;
            case 1:
                this.loadNewGame();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                this.window.exit();
                this.stop();
                break;

        }

        this.menu_handling = neue;

    }

    public void loadStartMenu() {
        this.startmenu = new StartMenu(this);
        this.addMouseListener(startmenu.getMouseL());
    }

    public void loadNewGame() {
        this.newgamemenu = new NewGameMenu(this);
        this.addMouseListener(newgamemenu.getMouseL());
    }

    public void loadGame() {
        handler = new Handler(this);
    }

    public void setPlayer(Player player) {
        loadGame();
        if (handler != null) {
            handler.setPlayer(player);
            System.out.println("new player " + player.toString());
        } else {
            System.out.println("Error setting player handler not inited");
        }
    }

    void exit() {
        this.window.exit();
        this.stop();
    }

}
