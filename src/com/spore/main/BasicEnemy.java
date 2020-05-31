package com.spore.main;

import java.awt.*;

public class BasicEnemy extends GameObject {


    public BasicEnemy(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 16, 16);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        if (velY == 0) velY = 5;
        if (velX == 0) velX = 5;
        if ( y < 0 || y >= Game.HEIGHT -32) velY *= -1;
        if ( x < 0 || x >= Game.WIDTH -32) velX *= -1;

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, 16, 16);

    }
}
