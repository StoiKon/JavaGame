/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IngameGUI;

import KlassesSkills.Skill;
import displays.Action;
import displays.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import source.Handler;

/**
 *
 * @author Name
 */
public class PlayerStats_n_SkillsMenu {

    private Image background;
    private Handler handler;
    private PlayerStats_n_SkillsMenuMouseL mouseL;
    private Button strBut, dexBut, vitBut, stamBut, inteBut;
    private Button skill_1, skill_2, skill_3, skill_4;

    public PlayerStats_n_SkillsMenu(Handler handler) {
        try {
            this.background = ImageIO.read(new File("resources\\inGameMenus\\stats_n_skills\\background.PNG"));
        } catch (IOException ex) {
            System.out.println("stats and skills menu background failed loading");
        }
        this.handler = handler;
        mouseL = new PlayerStats_n_SkillsMenuMouseL(handler, this);
        initButtons();
        initButtons2();
    }

    private void initButtons() {
        strBut = new Button(280, 280, 30, 30, "+");
        dexBut = new Button(280, 320, 30, 30, "+");
        vitBut = new Button(280, 360, 30, 30, "+");
        stamBut = new Button(280, 400, 30, 30, "+");
        inteBut = new Button(280, 440, 30, 30, "+");

        strBut.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getStatPoints() > 0) {
                    System.out.println("run");
                    handler.getPlayer().setStr(handler.getPlayer().getStr() + 1);
                    handler.getPlayer().calculateStats();
                    handler.getPlayer().passiveSkills();
                    handler.getPlayer().minusStatPoints();
                }
            }
        });
        dexBut.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getStatPoints() > 0) {
                    handler.getPlayer().setDex(handler.getPlayer().getDex() + 1);
                    handler.getPlayer().calculateStats();
                    handler.getPlayer().passiveSkills();
                    handler.getPlayer().minusStatPoints();
                }
            }
        });
        vitBut.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getStatPoints() > 0) {
                    handler.getPlayer().setVit(handler.getPlayer().getVit() + 1);
                    handler.getPlayer().calculateStats();
                    handler.getPlayer().passiveSkills();
                    handler.getPlayer().minusStatPoints();
                }
            }
        });
        stamBut.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getStatPoints() > 0) {
                    handler.getPlayer().setStam(handler.getPlayer().getStam() + 1);
                    handler.getPlayer().calculateStats();
                    handler.getPlayer().passiveSkills();
                    handler.getPlayer().minusStatPoints();
                }
            }
        });
        inteBut.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getStatPoints() > 0) {
                    handler.getPlayer().setInte(handler.getPlayer().getInte() + 1);
                    handler.getPlayer().calculateStats();
                    handler.getPlayer().passiveSkills();
                    handler.getPlayer().minusStatPoints();
                }
            }
        });
    }

    private void initButtons2() {
        skill_1 = new Button(960, 230, 30, 30, "+");
        skill_2 = new Button(960, 370, 30, 30, "+");
        skill_3 = new Button(960, 510, 30, 30, "+");
        skill_4 = new Button(960, 650, 30, 30, "+");

        skill_1.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getSkillPoints() > 0) {
                    System.out.println("run");
                    handler.getPlayer().inc_Skill(0);

                    handler.getPlayer().minusSkillPoints();
                }
            }
        });
        skill_2.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getSkillPoints() > 0) {
                    handler.getPlayer().inc_Skill(1);
                    handler.getPlayer().minusSkillPoints();
                }
            }
        });
        skill_3.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getSkillPoints() > 0) {
                    handler.getPlayer().inc_Skill(2);
                    handler.getPlayer().minusSkillPoints();
                }
            }
        });
        skill_4.setAction(new Action() {
            public void go() {
                if (handler.getPlayer().getSkillPoints() > 0) {
                    handler.getPlayer().inc_Skill(3);
                    handler.getPlayer().minusSkillPoints();
                }
            }
        });
    }

    public void paint(Graphics g) {
        g.drawImage(background, 100, 100, null);
        int y = 0;
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        for (String s : handler.getPlayer().statString().split("\n")) {
            g.drawString(s, 140, y + 220);
            y += 40;
        }
        for (String s : handler.getPlayer().statString2().split("\n")) {
            g.drawString(s, 140, y + 320);
            y += 30;
        }
        g.setFont(new Font("Arial", Font.PLAIN, 10));
        strBut.paint(g);
        dexBut.paint(g);
        vitBut.paint(g);
        stamBut.paint(g);
        inteBut.paint(g);

        skill_1.paint(g);
        skill_2.paint(g);
        skill_3.paint(g);
        skill_4.paint(g);
        y = 0;
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        for (Skill sk : this.handler.getPlayer().getSkillset().getSkills()) {
            for (String s : sk.toString().split("\n")) {
                g.drawString(s, 660, y + 230);
                y += 40;
            }
            y += 30;
        }

    }

    public PlayerStats_n_SkillsMenuMouseL getMouseL() {
        return mouseL;
    }

    public Handler getHandler() {
        return handler;
    }

    public Button getStrBut() {
        return strBut;
    }

    public Button getDexBut() {
        return dexBut;
    }

    public Button getVitBut() {
        return vitBut;
    }

    public Button getStamBut() {
        return stamBut;
    }

    public Button getInteBut() {
        return inteBut;
    }

    public Button getSkill_1() {
        return skill_1;
    }

    public Button getSkill_2() {
        return skill_2;
    }

    public Button getSkill_3() {
        return skill_3;
    }

    public Button getSkill_4() {
        return skill_4;
    }

}
