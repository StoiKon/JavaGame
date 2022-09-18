package source;

import AI.AI;
import IngameGUI.InventoryMenu;
import IngameGUI.PlayerStats_n_SkillsMenu;
import IngameGUI.ShopMenu;
import IngameGUI.Tooltip;
import animations.Animation;
import animations.DeathAnimation;
import gameObjects.Entity;
import gameObjects.Player;
import gameObjects.Shop;
import items.Item;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import tools.Position;
import user_input.Keyboard;
import world.Dungeon;
import world.Map;
import world.World;

public class Handler {

    private Game game;
    private Player player = null;//is itialized in new game menu and set by the setplayer function
//Keyboard Input
    private Keyboard keyboard;
//Maps
    private World world;
//
    private Map currentMap;
    private String[][] currentMap_str;
//for rendering purposes
    private Image grass, stoneWall, black, stoneFloor, stoneExit;
//collision checking needables
    private ArrayList<Position> tile_collisions;
//Animations
    private ArrayList<Animation> animations;
//Invetory Gui
    private InventoryMenu inv_menu;
    private boolean toggle_inv_menu;
//Tooltip
    private Tooltip tooltip;
//Shop gui
    private ShopMenu shopMenu;
    private boolean toggle_shopMenu = false;
//stats and skills
    private PlayerStats_n_SkillsMenu statsMenu;
    private boolean toggle_statsMenu = false;

//AI
    private AI ai;

    public Handler(Game game) {
        this.game = game;
        //world map is first
        world = new World();
        currentMap = world.getWorldMap();
        //adding shop for testing
        try {
            currentMap.getEntities().add(new Shop(13, 1, 1));
        } catch (IOException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //for map generation
        load_tileImages();
        loadMapInfo();

        //add Keyboard to the game
        keyboard = new Keyboard(this);
        game.addKeyListener(keyboard);
        //Inventory menu initialised in setPlayer function
        //init animations
        animations = new ArrayList<Animation>();
        
        //tooltip
        tooltip = null;

    }
//i might need this    

    public void tick() {
        Animation finished = null;
        try {
            if (!animations.isEmpty()) {
                for (Animation a : animations) {
                    a.tick();
                    if (a.getDuration() <= 0) {
                        finished = a;
                    }
                }
                if (finished != null) {
                    try {

                        animations.remove(finished);
                    } catch (Exception e) {

                    }
                }
                finished = null;
            }
        } catch (Exception e) {

        }

    }
//

    private void loadMapInfo() {

        load_currentMapString();
        this.tile_collisions = new ArrayList<Position>();
        addtileCollisions();

        ai = new AI(currentMap.getEntities(), this);
    }

    private void load_currentMapString() {
        this.currentMap_str = this.currentMap.getTiles();
        this.currentMap.showTiles();
    }

    private void load_tileImages() {
        try {
            stoneWall = ImageIO.read(new File("resources\\1.Enviroment\\tiles\\wall\\stoneWall.png"));
            grass = ImageIO.read(new File("resources\\1.Enviroment\\tiles\\grass\\grass.png"));
            black = ImageIO.read(new File("resources\\1.Enviroment\\tiles\\black tile\\black.png"));

            stoneFloor = ImageIO.read(new File("resources\\1.Enviroment\\tiles\\stoneFloor\\floor.png"));
            stoneExit = ImageIO.read(new File("resources\\1.Enviroment\\tiles\\wallExit\\exit.png"));

        } catch (IOException ex) {
            System.out.println("the freaking images didnt load");
        }

    }

    //if they are inside spectrum of the going to be drawn
    private boolean checkX(int x) {
        //is around player and inside bounds
        return (player.getX() - 8 <= x && x <= player.getX() + 9) && (x >= 0 && x < this.currentMap.getWidth());

    }

    private boolean checkY(int y) {
        //is around player and inside bounds
        return (player.getY() - 5 <= y && y <= player.getY() + 6) && (y >= 0 && y < this.currentMap.getHeight());
    }

    //add to tile_collision List for collision checking in movement
    private void addCollisionTileCoords(int x, int y) {
        this.tile_collisions.add(new Position(x, y));
    }

    private void addtileCollisions() {
        for (int j = 0; j < this.getMapHeight(); j++) {
            for (int i = 0; i < this.getMapWidth(); i++) {
                if (this.currentMap_str[i][j].equals("w")) {
                    addCollisionTileCoords(i, j);

                }
            }
        }

    }

    public ArrayList<Position> getTileCollisions() {
        return this.tile_collisions;
    }

    private void paint_Items(Graphics g) {
        if (!currentMap.getDroppedItems().isEmpty()) {
            try {
                for (Item droppedItem : this.currentMap.getDroppedItems()) {
                    g.drawImage(droppedItem.getIcon_onMap(),
                            (8 + droppedItem.getX() - player.getX()) * 100,
                            (5 + droppedItem.getY() - player.getY()) * 100, game);
                }
            } catch (Exception e) {
                System.out.println("paint_Items");
            }
        }
    }

    private void paint_Map(Graphics g) {
        //
        g.setColor(Color.black);
        g.fillRect(0, 0, 1680, 1050);
        for (int j = 0; j < this.getMapHeight(); j++) {
            for (int i = 0; i < this.getMapWidth(); i++) {
                if (checkX(i) && checkY(j)) {
                    switch (this.currentMap_str[i][j]) {
                        //printing the player in the middle and the terrain aroun his position
                        case "g":
                            g.drawImage(grass, (8 + i - player.getX()) * 100, (5 + j - player.getY()) * 100, game);
                            break;
                        case "w":
                            g.drawImage(stoneWall, (8 + i - player.getX()) * 100, (5 + j - player.getY()) * 100, game);
                            break;
                        case "s":
                            g.drawImage(stoneFloor, (8 + i - player.getX()) * 100, (5 + j - player.getY()) * 100, game);
                            break;
                        case "e":
                            g.drawImage(stoneExit, (8 + i - player.getX()) * 100, (5 + j - player.getY()) * 100, game);
                            break;

                    }
                }
            }
        }
    }

    private void paint_npcs(Graphics g) {
        try {
            for (Entity e : this.currentMap.getEntities()) {
                if (checkX(e.getX()) && checkY(e.getY())) {
                    g.drawImage(e.getAvatar(), (8 + e.getX() - player.getX()) * 100, (5 + e.getY() - player.getY()) * 100, game);
                    switch (e.getRarity()) {
                        case "rare":
                            g.setColor(Color.red);
                            break;
                        case "unique":
                            g.setColor(Color.magenta);
                            break;
                        case "boss":
                            g.setColor(Color.orange);
                            break;
                        default:
                            g.setColor(Color.white);
                            break;
                    }
                    if (!e.toString().equals("Shop")) {
                        g.drawString(e.getName() + "\n health:" + e.getLife(), (8 + e.getX() - player.getX()) * 100, (6 + e.getY() - player.getY()) * 100);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("concurent modification nothing to worry about");
        }
    }

    private void paint_Dungeons(Graphics g) {
        if (world != null) {
            if (this.currentMap == world.getWorldMap()) {
                for (Dungeon dun : this.world.getDungeons()) {
                    g.drawImage(dun.getDungeon_img(), (8 + dun.getX() - player.getX()) * 100, (5 + dun.getY() - player.getY()) * 100, game);
                    g.setColor(Color.white);
                    g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                    g.drawString(dun.toString(), (8 + dun.getX() - player.getX()) * 100, (6 + dun.getY() - player.getY()) * 100 + 20);
                }
            }
        }
    }

    private void paint_player(Graphics g) {
//g.drawImage(player.getAvatar(), player.getX()*100,player.getY()*100, game);
        g.drawImage(player.getAvatar(), 800, 500, game);
        player.paint_equipment_onPlayerAvatar(g, game);
        g.setColor(Color.white);
        g.drawString("Life " + player.getLife() + "  Mana" + player.getMana(), 100, 100);
    }

    private void paint_animations(Graphics g) {
        for (int i = 0; i < animations.size(); i++) {
            animations.get(i).paint(g);
        }

    }

    private void paint_tooltip(Graphics g) {
        try {
            if (tooltip != null) {
                int i = 0;
                for (String s : tooltip.getString().split("\n")) {
                    g.setColor(Color.black);
                    g.fillRect(tooltip.getX(), tooltip.getY() + i - 10, 200, 20);
                    g.setColor(Color.white);
                    g.setFont(new Font("Arial", Font.PLAIN, 14));
                    g.drawString(s, tooltip.getX(), tooltip.getY() + i);
                    i += 14;
                }
                i = 0;

            }
        } catch (Exception e) {
            System.out.println("whenever i see an error i cant correct i throw an exception");
        }

    }

    public void paint_all(Graphics g) {
        paint_Map(g);

        this.paint_Dungeons(g);

        paint_Items(g);

        paint_npcs(g);

        paint_player(g);

        paint_animations(g);

        if (this.toggle_inv_menu == true) {
            this.inv_menu.paint(g);
        }
        if (this.toggle_shopMenu == true && this.shopMenu != null) {
            this.shopMenu.paint(g);
        }
        if (this.toggle_statsMenu == true && this.statsMenu != null) {
            this.statsMenu.paint(g);
        }
        paint_tooltip(g);
    }
//open inventory menu and add mouseMotionListenner

    public void openInventoryMenu() {
        tooltip = null;
        this.toggle_inv_menu = !this.toggle_inv_menu;
        if (this.toggle_inv_menu == true) {
            game.addMouseMotionListener(this.inv_menu.getMouse());
            game.addMouseListener(inv_menu.getMouseL());
        } else {
            game.removeMouseMotionListener(this.inv_menu.getMouse());
            game.removeMouseListener(inv_menu.getMouseL());
        }
    }

    public void setTooltip(int x, int y, String string) {
        this.tooltip = new Tooltip(x, y, string);

    }

    public void removeTooltip() {
        this.tooltip = null;
    }

//set Player
    public void setPlayer(Player player) {
        this.player = player;
        //inventory menu init
        this.inv_menu = new InventoryMenu(this);
        this.toggle_inv_menu = false;

    }

    public Player getPlayer() {
        return player;
    }
    //get map bounds

    public int getMapHeight() {
        return currentMap.getHeight();
    }

    public int getMapWidth() {
        return currentMap.getWidth();
    }

    public ArrayList<Entity> getEntities() {
        return currentMap.getEntities();
    }

    public void addAnimation(Animation a) {
        animations.add(a);
    }

    public void checkForDeadEntities() {
        for (int i = 0; i < this.getEntities().size(); i++) {
            if (this.getEntities().get(i).getLife() <= 0) {
                if (this.getEntities().get(i).getDrop() != null) {
                    this.currentMap.getDroppedItems().add(this.getEntities().get(i).getDrop());
                }
                this.addAnimation(new DeathAnimation((8 + this.getEntities().get(i).getX()) * 100,
                        (5 + this.getEntities().get(i).getY()) * 100, this.player));
                this.player.addXp(this.getEntities().get(i).getLvl());
                this.getEntities().remove(i);
            }
        }
    }

    public ArrayList<Item> getDroppedItems() {
        return this.currentMap.getDroppedItems();
    }

    public void toggleShopMenu(boolean toggle, Entity e) {
        this.toggle_shopMenu = toggle;
        if (this.toggle_shopMenu == true && e != null) {
            this.shopMenu = new ShopMenu(e, this);
            game.addMouseMotionListener(this.shopMenu.getMouse());
            game.addMouseListener(shopMenu.getMouseL());

        }
        if (this.toggle_shopMenu == false) {
            if (this.shopMenu != null) {
                game.removeMouseMotionListener(this.shopMenu.getMouse());
                game.removeMouseListener(shopMenu.getMouseL());
                this.shopMenu = null;
            }
        }

    }

    public void toggleStatsMenu(boolean toggle) {
        this.toggle_statsMenu = toggle;
        if (this.toggle_statsMenu == true) {
            this.statsMenu = new PlayerStats_n_SkillsMenu(this);
            game.addMouseListener(statsMenu.getMouseL());

        }
        if (this.toggle_statsMenu == false) {
            if (this.statsMenu != null) {
                game.removeMouseListener(statsMenu.getMouseL());
                this.shopMenu = null;
            }
        }

    }

    public void toggleStatsMenu() {
        this.toggle_statsMenu = !(this.toggle_statsMenu);
        System.out.println(this.toggle_statsMenu);

        if (this.toggle_statsMenu == true) {
            this.statsMenu = new PlayerStats_n_SkillsMenu(this);
            game.addMouseListener(statsMenu.getMouseL());

        }
        if (this.toggle_statsMenu == false) {

            game.removeMouseListener(statsMenu.getMouseL());
            this.shopMenu = null;

        }

    }

    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
        loadMapInfo();

    }

    public ArrayList<Dungeon> dungeons() {
        return this.world.getDungeons();
    }

    public boolean is_onWorldMap() {
        if (world != null) {
            return this.currentMap == world.getWorldMap();
        } else {
            return false;
        }
    }

    public String getTile(int x, int y) {
        return this.currentMap_str[x][y];
    }

    public void ai_tick() {
        try {
            ai.tick();
        } catch (Exception ex) {
            System.out.println("ai_tick");
        }
    }

    public void worldMap() {
        this.currentMap = world.getWorldMap();
        this.loadMapInfo();
    }

}
