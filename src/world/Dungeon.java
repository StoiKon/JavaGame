/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author Name
 */
public class Dungeon {

    private String name;

    private int x, y;
    private Image dungeon_img;
    private ArrayList<Map> maps;

    public Dungeon(String name, int x, int y, Image dungeon_img) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.dungeon_img = dungeon_img;
        this.maps = new ArrayList<Map>();
    }

    public void addMap(Map map) {
        this.maps.add(map);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Map getMap(int index) {
        if (index < maps.size()) {
            return this.maps.get(index);
        } else {
            return null;
        }

    }

    public String getName() {
        return name;
    }

    public Image getDungeon_img() {
        return dungeon_img;
    }

    @Override
    public String toString() {
        return "Dungeon{" + name + '}';
    }
    
}
