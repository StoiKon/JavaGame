/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkills;

import animations.Animation;

/**
 *
 * @author Name
 */
public class Skillset {

    private Skill skills[];

    public Skillset() {
        skills = new Skill[4];

    }

    public Skill[] getSkills() {
        return skills;
    }

    public Skill getSkills(int index) {
        if (index < 4) {
            return skills[index];
        } else {
            return null;
        }
    }

    public void addSkill(Skill skill) {
        for (int i = 0; i < 4; i++) {
            if (skills[i] == null) {
                skills[i] = skill;
                return;
            }
        }
        System.out.println("Skills full");
    }
    public Animation getAnimation(int index,int x,int y){
   switch(index){
       
       default:
           return null;
   }
   }

}
