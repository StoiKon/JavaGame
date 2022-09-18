/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KlassesSkills;

import gameObjects.Entity;

/**
 *
 * @author Name
 */
public abstract class SkillEvent {
    
    public abstract void actionPerformed();
    public abstract void actionPerformed(Entity e);
}
