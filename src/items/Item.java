/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Image;

/**
 *
 * @author Name
 */
public class Item {

    private int x;
    private int y;
    private Image icon_onMap, icon_onPlayer, icon_onPlayer2;
    private String name;
    private String type;

    private int tier;
    private String rarity;

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
//damage
    private int physDmg;
    private int magicDmg;
//value
    private int value;
//armour
    private int armour;

    public Item(String name, String type, int tier, int x, int y, Image icon_onMap, Image icon_onPlayer) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.rarity = "normal";
        this.value = 0;

        this.x = x;
        this.y = y;
        this.icon_onMap = icon_onMap;
        this.icon_onPlayer = icon_onPlayer;
        this.icon_onPlayer2 = null;

        this.str = 0;
        this.dex = 0;
        this.vit = 0;
        this.inte = 0;
        this.stam = 0;
        this.life = 0;
        this.energy = 0;
        this.mana = 0;
        this.physDmg = 0;
        this.magicDmg = 0;

    }

    public Item(String name, String type, int tier, int x, int y, Image icon_onMap, Image icon_onPlayer, Image icon_onPlayer2) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.rarity = "normal";
        this.value = 0;

        this.x = x;
        this.y = y;
        this.icon_onMap = icon_onMap;
        this.icon_onPlayer = icon_onPlayer;
        this.icon_onPlayer2 = icon_onPlayer2;

        this.str = 0;
        this.dex = 0;
        this.vit = 0;
        this.inte = 0;
        this.stam = 0;
        this.life = 0;
        this.energy = 0;
        this.mana = 0;
        this.physDmg = 0;
        this.magicDmg = 0;

    }

    public Item(String name, String type, int tier, String rarity, int x, int y, Image icon_onMap, Image icon_onPlayer) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.rarity = rarity;
        this.value = 0;

        this.x = x;
        this.y = y;
        this.icon_onMap = icon_onMap;
        this.icon_onPlayer = icon_onPlayer;
        this.icon_onPlayer2 = null;

        this.str = 0;
        this.dex = 0;
        this.vit = 0;
        this.inte = 0;
        this.stam = 0;
        this.life = 0;
        this.energy = 0;
        this.mana = 0;
        this.physDmg = 0;
        this.magicDmg = 0;

    }

    public Item(String name, String type, int tier, String rarity, int x, int y, Image icon_onMap, Image icon_onPlayer, Image icon_onPlayer2) {
        this.name = name;
        this.type = type;
        this.tier = tier;
        this.rarity = rarity;
        this.value = 0;

        this.x = x;
        this.y = y;
        this.icon_onMap = icon_onMap;
        this.icon_onPlayer = icon_onPlayer;
        this.icon_onPlayer2 = icon_onPlayer2;

        this.str = 0;
        this.dex = 0;
        this.vit = 0;
        this.inte = 0;
        this.stam = 0;
        this.life = 0;
        this.energy = 0;
        this.mana = 0;
        this.physDmg = 0;
        this.magicDmg = 0;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getVit() {
        return vit;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public int getInte() {
        return inte;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public int getStam() {
        return stam;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPhysDmg() {
        return physDmg;
    }

    public void setPhysDmg(int physDmg) {
        this.physDmg = physDmg;
    }

    public int getMagicDmg() {
        return magicDmg;
    }

    public void setMagicDmg(int magicDmg) {
        this.magicDmg = magicDmg;
    }

    public Image getIcon_onMap() {
        return icon_onMap;
    }

    public Image getIcon_onPlayer() {
        return icon_onPlayer;
    }

    public Image getIcon_onPlayer2() {
        return icon_onPlayer2;
    }

    @Override
    public String toString() {
        String x = "name=" + name + "\n, type=" + type + "\n, tier=" + tier + "\n, rarity=" + rarity + "\n, energy=" + energy;
        if (this.type.equals("1H") || this.type.equals("2H")) {
            x = x + "\n, physDmg=" + physDmg + "\n, magicDmg" + magicDmg  + "\n, armour=" + this.armour;
        }
        if (this.type.equals("armour") || this.type.equals("boots") || this.type.equals("helm")) {
            x = x + "\n, armour=" + this.armour;
        }
        x = x + "\nprice " + this.value;
        if (this.getStr() > 0) {
            x = x + "\n strength + " + this.getStr();
        }
        if (this.getDex() > 0) {
            x = x + "\n strength + " + this.getDex();
        }
        if (this.getInte() > 0) {
            x = x + "\n strength + " + this.getInte();
        }
        if (this.getStam() > 0) {
            x = x + "\n strength + " + this.getStam();
        }
        if (this.getVit() > 0) {
            x = x + "\n strength + " + this.getVit();
        }
        if (this.getLife() > 0) {
            x = x + "\n strength + " + this.getLife();
        }

        return x;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

}
