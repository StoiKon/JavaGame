package gameObjects;

import Klasses.Klass;
import items.Inventory;
import items.Item;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Entity {

    int x, y;
    int width = 1;
    int height = 1;
//
    private String name;
    private String race;
    private Klass klass;
//
    private int lvl = 1;
//Stats
    private int str = 9;
    private int dex = 9;
    private int vit = 9;
    private int inte = 9;
    private int stam = 9;
//more Stats

    private int maxLife, life;
    private int lifePerLevel = 1;
    private int maxEnergy, energy;
    private int maxMana, mana = 0;
//to check if it needs to attack player
    private String faction;
//
    private String rarity;
//
    private Image avatar;
//

    private int armour;

    public Entity(int x, int y, String name, String race, Klass klass, String faction) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.race = race;
        this.klass = klass;
        this.faction = faction;
        this.rarity = "normal";
        calculate_init();

    }

    public Entity(int x, int y, String name, String race, Klass klass, String faction, Image avatar) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.race = race;
        this.klass = klass;
        this.faction = faction;
        this.avatar = avatar;
        this.rarity = "normal";
        calculate_init();

    }

    //default image constructor
    public Entity(int x, int y, String name, String race, Klass klass, String faction, String rarity, Image avatar) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.race = race;
        this.klass = klass;
        this.faction = faction;
        this.rarity = rarity;
        this.avatar = avatar;

        calculate_init();

    }

    private void calculate_init() {

        //race stats
        switch (race) {
            case "Human":
                str += 2;
                dex += 2;
                inte += 2;
                try {
                    //image
                    this.avatar = ImageIO.read(new File("resources\\Player\\human.png"));
                } catch (IOException ex) {
                    System.out.println("all you had to do was load the default entity avatar cj");
                }
                break;
            case "Elf":
                try {
                //image
                this.avatar = ImageIO.read(new File("resources\\Player\\Elf.png"));
            } catch (IOException ex) {
                System.out.println("all you had to do was load the default entity avatar cj");
            }
            dex += 2;
            inte += 4;
            break;
        }
        //class stats
        if (klass != null) {
            this.str += klass.getStr();
            this.dex += klass.getDex();
            this.vit += klass.getVit();
            this.inte += klass.getInte();
            this.stam += klass.getStam();
            this.maxLife += klass.getLife();
            this.lifePerLevel = 10;
            this.maxEnergy += klass.getEnergy();
            this.mana += klass.getMana();

        }
        this.maxMana = 100 + this.inte * 5;
        this.maxLife += this.vit * 2 + 300;
        this.maxEnergy += this.stam * 2;
        life = maxLife;
        mana = maxMana;
        this.armour = 0;
    }
    public void calculateStats(){
    this.maxMana =100+ this.inte * 5;
        this.maxLife =300+ this.vit * 2 ;
        this.maxEnergy =100+ this.stam * 2;
        life = maxLife;
        mana = maxMana;
        
        
        
    }

    //set position
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void addPos(int i, int j) {
        this.x += i;
        this.y += j;
    }
    //get position

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    //getting avatar for rendering purposes

    public Image getAvatar() {
        return avatar;
    }

    @Override
    public String toString() {
        return "Entity{" + "x=" + x + ", y=" + y + ", rarity =" + rarity + ", name=" + name + ", race=" + race + ", klass=" + klass.getName() + ", lvl=" + lvl + ", str=" + str + ", dex=" + dex + ", vit=" + vit + ", inte=" + inte + ", stam=" + stam + ", life=" + life + '}';
    }

//Setters
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setVit(int vit) {
        this.vit = vit;
    }

    public void setInte(int inte) {
        this.inte = inte;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }
    //getters

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public int getLvl() {
        return lvl;
    }

    public String getFaction() {
        return faction;
    }

    public String getRarity() {
        return rarity;
    }

    public int getLife() {
        return life;
    }

    //physical combat
    public int getPhysDamage() {
        return this.str * 1;//more factors to be added later
    }

    public int getMagicDamage() {
        return this.inte * 1;//more factors to be added later
    }

    public int getArmour() {
        return this.armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public void reduceLife(int amount) {
        this.life -= amount;
    }

    public void physAttack(Entity e) {
        if (this.getPhysDamage() - e.getArmour() > 0) {
            e.reduceLife(this.getPhysDamage() - e.getArmour());
            System.out.println("armour "+e.getArmour());
            System.out.println("dmg  "+e.getPhysDamage());
        }

    }

    public Item getDrop() {
        return null;
    }

    /**
     *
     * @to be used for shopMenu
     */
    public Inventory getInventory() {
        return null;
    }

    public Klass getKlass() {
        return klass;
    }

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

    public int getLifePerLevel() {
        return lifePerLevel;
    }

    public int getEnergy() {
        return energy;
    }

    public int getMana() {
        return mana;
    }

    public int getMaxEnergy() {
        return maxEnergy;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMaxLife() {
        return maxLife;
    }

    public void level_plus_one() {
        this.lvl++;
    }

    public void setStam(int stam) {
        this.stam = stam;
    }

    public void setMaxLife(int maxLife) {
        this.maxLife = maxLife;
    }

    public void setMaxEnergy(int maxEnergy) {
        this.maxEnergy = maxEnergy;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

}
