package com.spore.main;

import java.awt.Rectangle;

import java.awt.*;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player (int x, int y, ID id) {

        super(x, y, id);

        //velX = r.nextInt(5)+1; //+1 guarantee that every qube will move
        //velY = r.nextInt(5);

    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32+4, 32+4);
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH-37);
        y = Game.clamp(y, 0, Game.HEIGHT-60);


    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        g.setColor(Color.GREEN);
        g2d.draw(getBounds());

        //if(id == ID.Player)g.setColor(Color.green);
        //else if(id == ID.Player2)g.setColor(Color.pink);


        //g.setColor(Color.green);
        //g.fillRect(x, y, 32, 32);
    }
}
