/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameObjects;

import Klasses.Klass;
import KlassesSkills.MageSkillSet;
import KlassesSkills.RogueSkillSet;
import KlassesSkills.SkilSet;
import KlassesSkills.WarriorSkillSet;
import animationsSkillsMage.ArcaneBeamAnimation;
import items.Armour;
import items.Boots;
import items.Equipment;
import items.Helmet;
import items.Inventory;
import items.Item;
import items.Knife;
import items.Sword2H;
import java.awt.Graphics;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import source.Game;
import source.Handler;

/**
 *
 * @author Name
 */
public class Player extends Entity {

    private Equipment equipment;
    private Inventory inventory;
    private int gold;
    int item_str = 0;
    int item_dex = 0;
    int item_vit = 0;
    int item_inte = 0;
    int item_stam = 0;
    int item_maxLife = 0;
    int item_energy = 0;
    int item_mana = 0;

    private int xp;
    private int xpLimit;

    private int statPoints;
    private int skillPoints;

    private SkilSet skillset;

    private int critical_chance;
    private Random rand;

    private int bonusPhysDmg;

    public Player(int x, int y, String name, String race, Klass klass, String faction) {
        super(x, y, name, race, klass, faction);
        rand = new Random();
        //setPlayer for Klass in order to calculate Stats for skills
        gold = 300;//for testing purposes
        //items and stuff
        inventory = new Inventory(10, 5);
        equipment = new Equipment();

        try {
            pickUp(new Knife(1, "normal", 0, 0));
            //equip(new Knife(1,"normal",0,0));
            //equip(new Armour(1,"normal",0,0));
            //equip(new Boots(1,"normal",0,0));
            //equip(new Helmet(1,"normal",0,0));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        //level up mechanics
        initlevelMechanics();
        initklassSkills();

        //critical only for rogues
        this.critical_chance = 0;
        this.bonusPhysDmg = 0;

    }

    public SkilSet getSkillset() {
        return skillset;
    }

    private void initklassSkills() {
        switch (this.getKlass().getName()) {
            case "Warrior":
                this.skillset = new WarriorSkillSet(this);
                break;
            case "Rogue":
                this.skillset = new RogueSkillSet(this);
                break;
            case "Mage":
                this.skillset = new MageSkillSet(this);
                break;

        }
    }

    public void performSkill(Handler handler, int x, int y, Entity e, int skill) {
        if (skillset.getSkills(skill) != null) {
            if (this.getMana() > 0) {
                skillset.getSkills(skill).action(e);
                try {
                    if (skillset.getAnimation(x, y, skill) != null) {
                        handler.addAnimation(skillset.getAnimation(x, y, skill));
                    }
                } catch (Exception exc) {
                    System.out.println("player class performSkill function");
                }
            }
        }
    }

    public void performSkill(Handler handler, int x, int y, int skill) {
        if (skillset.getSkills(skill) != null) {
            if (!skillset.getSkills().equals(skillset.getSkills(1)) && this.getMana() > 0
                    || skillset.getSkills(skill).equals(skillset.getSkills(1)) && skillset.getSkills(1).toString().contains("Mana")) {
                skillset.getSkills(skill).action();
                System.out.println(skillset.getSkills(skill).toString());

                try {
                    if (skillset.getAnimation(x, y, skill) != null) {
                        handler.addAnimation(skillset.getAnimation(x, y, skill));
                    }
                } catch (Exception exc) {
                    System.out.println("player class performSkill function");
                }
            }
        }

    }

    public void passiveSkills() {
        this.getSkillset().getSkills(0).passiveEffect(this);
        this.getSkillset().getSkills(1).passiveEffect(this);
        this.getSkillset().getSkills(2).passiveEffect(this);
        this.getSkillset().getSkills(3).passiveEffect(this);
    }

    private void initlevelMechanics() {
        xp = 0;
        xpLimit = this.getLvl() * 10;
        //this.statPoints=1000;
        //this.skillPoints=1000;
    }

    private void levelUp() {
        if (xp >= xpLimit) {
            this.level_plus_one();
            xpLimit = this.getLvl() * 10;
            xp = 0;
            this.statPoints += 3;
            this.skillPoints += 1;
        }

    }

    public void addXp(int amount) {
        this.xp += amount;
        this.levelUp();
    }

    public void paint_equipment_onPlayerAvatar(Graphics g, Game game) {
        equipment.paint(g, game);
    }

    public void unequip(Item item) {
        if (item == equipment.getMainHand()) {
            pickUp(item);
            equipment.setMainHand(null);
        }
        if (item == equipment.getOffHand()) {
            pickUp(item);
            equipment.setOffHand(null);
        }
        if (item == equipment.getBodyarmour()) {
            pickUp(item);
            equipment.setBodyarmour(null);
        }
        if (item == equipment.getBoots()) {
            pickUp(item);
            equipment.setBoots(null);
        }
        if (item == equipment.getHelmet()) {
            pickUp(item);
            equipment.setHelmet(null);
        }
        this.calcEquipmentStats();
    }

    public void sell(Item item) {
        gold += item.getValue() / 5;
        inventory.removeItem(item);
    }

    public void buy(Item item) {
        if (!inventory.isFull() && gold >= item.getValue()) {
            gold -= item.getValue();
            inventory.addItem(item);
        }
    }

    public int getGold() {
        return gold;
    }

    public void equip(Item item) {
        switch (item.getType()) {
            case "1H":
                if (equipment.getMainHand() == null) {

                    equipment.setMainHand(item);
                    this.inventory.removeItem(item);
                } else if (equipment.getMainHand() != null && equipment.getOffHand() == null && equipment.getMainHand().getType().equals("1H")) {
                    equipment.setOffHand(item);
                    this.inventory.removeItem(item);
                } else if (equipment.getMainHand() != null && equipment.getOffHand() != null) {
                    inventory.addItem(equipment.getMainHand());
                    equipment.setMainHand(item);
                    this.inventory.removeItem(item);
                }
                break;
            case "2H":
                if (equipment.getOffHand() != null) {
                    this.inventory.addItem(equipment.getOffHand());
                    equipment.setOffHand(null);

                }
                if (equipment.getMainHand() != null) {
                    this.inventory.addItem(equipment.getMainHand());
                    equipment.setMainHand(null);
                }

                equipment.setMainHand(item);
                equipment.setOffHand(null);

                this.inventory.removeItem(item);
                break;
            case "helm":
                equipment.setHelmet(item);
                this.inventory.removeItem(item);
                break;
            case "armour":
                equipment.setBodyarmour(item);
                this.inventory.removeItem(item);
                break;
            case "boots":
                equipment.setBoots(item);
                this.inventory.removeItem(item);
                break;

        }
        this.calcEquipmentStats();
    }

    @Override
    public int getPhysDamage() {
        if (equipment.getMainHand() != null && equipment.getOffHand() == null) {
            return this.getStr() * 1 + this.getDex() / 2 + equipment.getMainHand().getPhysDmg();

        }
        if (equipment.getMainHand() != null && equipment.getOffHand() != null) {
            return this.getStr() + this.item_str * 1 + this.getDex() / 2
                    + equipment.getMainHand().getPhysDmg()
                    + equipment.getOffHand().getPhysDmg();
        }
        return this.getStr() * 1 + this.getDex() / 2;//more factors to be added later
    }

    @Override
    public void physAttack(Entity e) {
        if (rand.nextInt(99) < this.critical_chance) {
            e.reduceLife(this.getPhysDamage() - e.getArmour() + this.bonusPhysDmg);
        }
        e.reduceLife(this.getPhysDamage() - e.getArmour() + this.bonusPhysDmg);
        if (e.getLife() <= 0) {
            addXp(e.getLvl() + 1 - (this.getLvl()));
        }

    }

    public void setBonusPhysDmg(int bonusPhysDmg) {
        this.bonusPhysDmg = bonusPhysDmg;
    }

    public void addCritical_chance(int critical_chance) {
        this.critical_chance += critical_chance;
    }

    public void pickUp(Item item) {
        inventory.addItem(item);
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public Inventory getInventory() {
        return inventory;
    }

    private void calcEquipmentStats() {
        resetItemStats();
        setItemStats(equipment.getHelmet());
        setItemStats(equipment.getBodyarmour());
        setItemStats(equipment.getBoots());
        setItemStats(equipment.getMainHand());
        setItemStats(equipment.getOffHand());
    }

    private void setItemStats(Item item) {
        if (item != null) {
            this.item_str += item.getStr();
            this.item_dex += item.getDex();
            this.item_vit += item.getVit();
            this.item_inte += item.getInte();
            this.item_stam += item.getStam();
            this.item_maxLife += item.getLife();
            this.item_energy += item.getEnergy();
            this.item_mana += item.getMana();
        }
    }

    private void resetItemStats() {
        this.item_str = 0;
        this.item_dex = 0;
        this.item_vit = 0;
        this.item_inte = 0;
        this.item_stam = 0;
        this.item_maxLife = 0;
        this.item_energy = 0;
        this.item_mana = 0;
    }

    public String statString() {
        return "Level " + this.getLvl()
                + "\nxp/xplimit  " + xp + "/" + this.xpLimit
                + "\nStrength " + (this.getStr() + this.item_str)
                + "\nDexterity  " + (this.getDex() + this.item_dex)
                + "\nVitality  " + (this.getVit() + this.item_vit)
                + "\nStamina  " + (this.getStam() + this.item_stam)
                + "\nIntelligence  " + (this.getInte() + this.item_inte)
                + "\nlife/maxlife " + this.getLife()
                + "/" + (this.getMaxLife() + this.item_maxLife)
                + "\nEnergy  " + this.getEnergy()
                + "\nMana  " + this.getMana()
                + "\nphysical damage " + this.getPhysDamage()
                + "\narmour " + this.getArmour();

    }

    public String statString2() {
        return "stat points: " + this.statPoints
                + "\nskill points: " + this.skillPoints;
    }

    public int getStatPoints() {
        return statPoints;
    }

    public void minusStatPoints() {
        this.statPoints--;
    }

    public void minusSkillPoints() {
        this.skillPoints--;
    }

    public int getSkillPoints() {
        return skillPoints;
    }

    public void inc_Skill(int index) {
        this.getSkillset().getSkills(index).incrementSkillLevel();
        this.getSkillset().getSkills(index).passiveEffect(this);
    }

    public void minusSkillPoints(int skillPoints) {
        this.skillPoints = skillPoints--;
    }

    public int getMagicDamage() {
        int eq_magic = 0;
        if (equipment.getMainHand() != null) {
            x += equipment.getMainHand().getMagicDmg();
        }
        if (equipment.getOffHand() != null) {
            x += equipment.getOffHand().getMagicDmg();
        }
        return this.getInte() + this.item_inte + eq_magic;//more factors to be added later
    }

    public void reduceMana(int amount) {
        this.setMana(this.getMana() - amount);
    }

    @Override
    public int getArmour() {
        int armour = 0;
        if (this.equipment.getBodyarmour() != null) {
            armour += this.equipment.getBodyarmour().getArmour();
        }
        if (this.equipment.getBoots() != null) {
            armour += this.equipment.getBoots().getArmour();
        }
        if (this.equipment.getHelmet() != null) {
            armour += this.equipment.getHelmet().getArmour();
        }
        return super.getArmour() + armour;
    }

}
