/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Klasses;

import KlassesSkills.Skill;
import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class Klass {

    private String name;
//Stats
    private int str;
    private int dex;
    private int vit;
    private int inte;
    private int stam;
//more Stats
    private int life;
    private int energy;
    private int mana;


    public Klass(String name, int str, int dex, int vit, int inte, int stam, int life, int energy, int mana) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.vit = vit;
        this.inte = inte;
        this.stam = stam;
        this.life = life;
        this.energy = energy;
        this.mana = mana;

        
    }

    public Klass() {
        this.name = "null";
        this.str = 0;
        this.dex = 0;
        this.vit = 0;
        this.inte = 0;
        this.stam = 0;
        this.life = 0;
        this.energy = 0;
        this.mana = 0;
    }
    

    public String getName() {
        return name;
    }
    //normal functions

    //abstract ones
    //insert code ones setter getters
    public int getStr() {
        return str;
    }

    public int getDex() {
        return dex;
    }

    public int getVit() {
        return vit;
    }

    public int getInte() {
        return inte;
    }

    public int getStam() {
        return stam;
    }

    public int getLife() {
        return life;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMana() {
        return mana;
    }
    
    
    
}
