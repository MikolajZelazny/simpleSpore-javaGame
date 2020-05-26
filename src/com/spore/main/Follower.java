package com.spore.main;

import java.awt.*;

public class Follower extends Player {

    public Follower(int x, int y, ID id) {
        super(x, y, id);

        velX = 5;
        velY  = 5;

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        //if (velY == 0) velY = 5;
        //if (velX == 0) velX = 5;
        if ( y < 0 || y >= Game.HEIGHT -32) velY *= -1;
        if ( x < 0 || x >= Game.WIDTH -32) velX *= -1;
        x = Game.clamp(x, 0, Game.WIDTH-37);
        y = Game.clamp(y, 0, Game.HEIGHT-60);



    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 16, 16);

    }
}
