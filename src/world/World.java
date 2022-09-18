
package world;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import worldDungeons.RatDungeon;
import worldDungeons.ThiefDungeon;

public class World {
private Map worldMap;
private ArrayList<Dungeon> dungeons;
    public World() {
        worldMap=new Map(new File("maps\\World Map\\worldMap.map"),new File("maps\\World Map\\worldMap.en"),"World Map");
        this.dungeons=new ArrayList<Dungeon>();
    try {
        this.dungeons.add(new RatDungeon(4,4));
        this.dungeons.add(new ThiefDungeon(7,7));
    } catch (IOException ex) {
        Logger.getLogger(World.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public Map getWorldMap() {
        return worldMap;
    }

    public ArrayList<Dungeon> getDungeons() {
        return dungeons;
    }
   
    

}
