/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkills;

import animations.Animation;
import gameObjects.Entity;
import gameObjects.Player;

/**
 *
 * @author Name
 */
public class Skill {

    private int lvl_req;
    private int skill_lvl;
    private String type;//active or passive
    private SkillEvent event;//no kidding
    private int cooldown;
    private int current_cooldown;

    public Skill(int lvl_req, String type) {
        this.lvl_req = lvl_req;
        this.type = type;

    }

    public int getLvl_req() {
        return lvl_req;
    }

    public void setLvl_req(int lvl_req) {
        this.lvl_req = lvl_req;
    }

    public int getSkill_lvl() {
        return skill_lvl;
    }

    public void setSkill_lvl(int skill_lvl) {
        this.skill_lvl = skill_lvl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SkillEvent getEvent() {
        return event;
    }

    public void setEvent(SkillEvent event) {
        this.event = event;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getCurrent_cooldown() {
        return current_cooldown;
    }

    public void setCurrent_cooldown(int current_cooldown) {
        this.current_cooldown = current_cooldown;
    }

    public void reduceCooldown() {
        if (this.current_cooldown > 0) {
            this.current_cooldown--;
        }
    }

    public void action() {
        this.event.actionPerformed();
    }

    public void action(Entity e) {
        this.event.actionPerformed();
        this.event.actionPerformed(e);
    }
    public void reduceDuration(){
        System.out.println("this spell "+toString()+" has no duration");
    }
    public void passiveEffect(Player player){
    
    }
    public String toString2(){
    return "\nlvl "+this.getSkill_lvl() +"\n lvl required "+this.getLvl_req();
    }
    public void incrementSkillLevel(){
    this.skill_lvl++;
    }
    

}
