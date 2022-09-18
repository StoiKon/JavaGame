/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import Klasses.Klass;
import java.awt.Image;

/**
 *
 * @author Name
 */
public class Mob extends Entity{
    
    public Mob(int x, int y, String name, String race, Klass klass, String rarity, Image avatar) {
        super(x, y, name, race, klass, "hostile", rarity, avatar);
        this.setLife(20+this.getLvl()*3);
        switch(super.getRarity()){
            case "rare":
                break;
            case "unique":
                break;
            case "boss":
                break;
        }
    }
    
}
