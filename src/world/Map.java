package world;

import Klasses.Klass;
import gameMobs.Rat;
import gameMobs.RatBoss;
import gameMobsThiefDungeon.Skeleton;
import gameMobsThiefDungeon.Thief;
import gameMobsThiefDungeon.ThiefBoss;
import gameObjects.Entity;
import items.Item;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import tools.Position;

public class Map {

    private String name;
//map layout
    private String tiles[][];
    private int height = 0, width = 0;
    private boolean gotWidth = false;
//npcs
    private ArrayList<Entity> entities;
//items
    private ArrayList<Item> droppedItems;

    public Map(File tiles, File npcs, String name) {
        this.name = "Map";
        loadTiles(tiles);
        loadNpcs(npcs);
        droppedItems=new ArrayList<Item>();
        

    }

    private void loadTiles(File file) {
        String text = "";
        String textLine;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                text = text.concat(read.nextLine()) + "\n";
                if (!gotWidth) {
                    char chars[] = text.toCharArray();
                    for (char c : chars) {
                        if (c == '|') {
                            width += 1;
                        }
                    }
                    gotWidth = true;
                }
                height += 1;
            }
            //System.out.println("height -> " + this.height + "\nwidth -> " + this.width);
            //format text into tiles array
            tiles = new String[width][height];
            read = new Scanner(text);

            for (int i = 0; i < width; i++) {
                for (int j = 0; j < height; j++) {
                    tiles[i][j] = "";
                }
            }
            int y = 0;//for height
            while (read.hasNextLine()) {
                textLine = read.nextLine();
                for (int i = 0; i < width; i++) {
                    for (char c : textLine.toCharArray()) {
                        if (c != '|') {
                            tiles[i][y] = tiles[i][y] + c;
                        }
                        if (c == '|') {
                            i++;
                        }
                    }
                }
                y++;
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Map Class the fucking scanner doesnt work");
        }
    }

    public void showTiles() {
        String line = "";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                line = line + tiles[j][i];

            }
            System.out.println(line);
            line = "";
        }
    }

//getters
    public String getName() {
        return name;
    }

    public String[][] getTiles() {
        return tiles;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    private void loadNpcs(File npcs) {
        this.entities = new ArrayList<Entity>();
        try {
            Scanner read = new Scanner(npcs);
            ArrayList<Position> freePositions = new ArrayList<Position>();
            int freeLength = 0;
            String currentLine = "", str = "";
            Position pos = null;

            int plithos;
            String type;
            int lvl;
            Random rand = new Random();

            for (int i = 0; i < this.width; i++) {
                for (int j = 0; j < this.height; j++) {
                    if (!this.tiles[i][j].equals("w")) {
                        freePositions.add(new Position(i, j));
                        freeLength++;
                    }
                }
            }
            while (read.hasNextLine()) {
                currentLine = read.nextLine();
                currentLine = currentLine.replace("plithos:", "");
                str = currentLine.substring(0, currentLine.indexOf('|'));
                plithos = Integer.parseInt(str);
                System.out.println("plithos -> " + plithos);
                currentLine = currentLine.replace(plithos + "|type:", "");
                str = currentLine.substring(0, currentLine.indexOf('|'));
                type = str;
                System.out.println("type->" + type);
                lvl = Integer.parseInt(currentLine.substring(currentLine.lastIndexOf(':') + 1, currentLine.length()));
                System.out.println("lvl->" + lvl);
                for (int i = 0; i < plithos; i++) {
                    if (!freePositions.isEmpty()) {
                        switch (type) {
                            case "rat":
                                pos = freePositions.get(rand.nextInt(freeLength - 1));
                                 {
                                    try {
                                        this.entities.add(new Rat(pos.getX(), pos.getY(), new Klass(),lvl));
                                        
                                        freeLength--;
                                        freePositions.remove(pos);
                                    } catch (IOException ex) {
                                        System.out.println("the fucking rat didnt initialise check in Map class");
                                    }
                                }
                                pos = null;
                                break;
                            case "ratBoss":
                                pos = freePositions.get(rand.nextInt(freeLength - 1));
                                 {
                                    try {
                                        this.entities.add(new RatBoss(pos.getX(), pos.getY(),lvl));
                                        
                                        freeLength--;
                                        freePositions.remove(pos);
                                    } catch (IOException ex) {
                                        System.out.println("the fucking rat didnt initialise check in Map class");
                                    }
                                }
                                pos = null;
                                break;
                                case "thief":
                                pos = freePositions.get(rand.nextInt(freeLength - 1));
                                 {
                                    try {
                                        this.entities.add(new Thief(pos.getX(), pos.getY(),lvl));
                                        
                                        freeLength--;
                                        freePositions.remove(pos);
                                    } catch (IOException ex) {
                                        System.out.println("the fucking rat didnt initialise check in Map class");
                                    }
                                }
                                pos = null;
                                break;
                                case "skeleton":
                                pos = freePositions.get(rand.nextInt(freeLength - 1));
                                 {
                                    try {
                                        this.entities.add(new Skeleton(pos.getX(), pos.getY(),lvl));
                                        
                                        freeLength--;
                                        freePositions.remove(pos);
                                    } catch (IOException ex) {
                                        System.out.println("the fucking rat didnt initialise check in Map class");
                                    }
                                }
                                pos = null;
                                break;
                                case "thiefBoss":
                                pos = freePositions.get(rand.nextInt(freeLength - 1));
                                 {
                                    try {
                                        this.entities.add(new ThiefBoss(pos.getX(), pos.getY(),lvl));
                                        
                                        freeLength--;
                                        freePositions.remove(pos);
                                    } catch (IOException ex) {
                                        System.out.println("the fucking rat didnt initialise check in Map class");
                                    }
                                }
                                pos = null;
                                break;

                        }

                    } else {
                        System.out.println("you filled the fucken map you imbecile");
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            System.out.println("Npcs File could not be openned check how you initialised it ");
        }

    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public ArrayList<Item> getDroppedItems() {
        return droppedItems;
    }
    

}
