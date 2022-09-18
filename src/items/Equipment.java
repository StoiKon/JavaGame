/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package items;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import source.Game;

/**
 *
 * @author Name
 */
public class Equipment {

    private Item mainHand, offHand, bodyarmour, boots, helmet;
    private Image empty;

    public Equipment() {
        mainHand = null;
        offHand = null;
        bodyarmour = null;
        boots = null;
        helmet = null;

        try {
            empty = ImageIO.read(new File("resources\\Items\\EmptyInvSlot\\empty.png"));
        } catch (IOException ex) {
            System.out.println("get fucked! im not telling you were it is");
        }
    }

    public void paint(Graphics g, Game game) {

        if (bodyarmour != null) {
            g.drawImage(bodyarmour.getIcon_onPlayer(), 800, 500, game);
        }
        if (boots != null) {
            g.drawImage(boots.getIcon_onPlayer(), 800, 500, game);
        }
        if (helmet != null) {
            g.drawImage(helmet.getIcon_onPlayer(), 800, 500, game);
        }
        if (mainHand != null) {
            g.drawImage(mainHand.getIcon_onPlayer(), 800, 500, game);
        }
        if (offHand != null && offHand.getIcon_onPlayer2() != null) {
            g.drawImage(offHand.getIcon_onPlayer2(), 800, 500, game);
        }
    }

    public void paintContents(Graphics g) {

        if (bodyarmour != null) {
            g.drawImage(bodyarmour.getIcon_onMap(), 300, 100, null);
        } else {
            g.drawImage(empty, 300, 100, null);
        }
        if (boots != null) {
            g.drawImage(boots.getIcon_onMap(), 400, 100, null);
        } else {
            g.drawImage(empty, 400, 100, null);
        }
        if (helmet != null) {
            g.drawImage(helmet.getIcon_onMap(), 500, 100, null);
        } else {
            g.drawImage(empty, 500, 100, null);
        }
        if (mainHand != null) {
            g.drawImage(mainHand.getIcon_onMap(), 100, 100, null);
        } else {
            g.drawImage(empty, 100, 100, null);
        }
        if (offHand != null && offHand.getIcon_onPlayer() != null) {
            g.drawImage(offHand.getIcon_onMap(), 200, 100, null);
        } else {
            g.drawImage(empty, 200, 100, null);
        }
    }

    public Item getMainHand() {
        return mainHand;
    }

    public void setMainHand(Item mainHand) {
        this.mainHand = mainHand;
    }

    public Item getOffHand() {
        return offHand;
    }

    public void setOffHand(Item offHand) {
        this.offHand = offHand;

    }

    public Item getBodyarmour() {
        return bodyarmour;
    }

    public void setBodyarmour(Item bodyarmour) {
        this.bodyarmour = bodyarmour;
    }

    public Item getBoots() {
        return boots;
    }

    public void setBoots(Item boots) {
        this.boots = boots;
    }

    public void setHelmet(Item helmet) {
        this.helmet = helmet;
    }

    public Item getHelmet() {
        return helmet;
    }

}
