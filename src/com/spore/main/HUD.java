package com.spore.main;

import java.awt.*;

public class HUD {

    public static int HEALTH = 100;

    public void tick() {

        HEALTH = Game.clamp(HEALTH, 0, 100);

    }

    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(15, 15, 200, 25);
        g.setColor(Color.getHSBColor(173,200,235)); // nice color
        g.fillRect(15, 15, HEALTH * 2, 25);
        g.setColor(Color.darkGray);
        g.drawRect(15, 15, 200, 25);

        g.setColor(Color.getHSBColor(83,220,235));
        g.fillRect(125, 40, 25, 25);
        g.setColor(Color.darkGray);
        g.drawRect(125, 40, 25, 25);

        g.setColor(Color.getHSBColor(83,220,235));
        g.fillRect(150, 40, 25, 25);
        g.setColor(Color.darkGray);
        g.drawRect(150, 40, 25, 25);

        g.setColor(Color.getHSBColor(83,220,235));
        g.fillRect(175, 40, 25, 25);
        g.setColor(Color.darkGray);
        g.drawRect(175, 40, 25, 25);

    }


}
