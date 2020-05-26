package com.spore.main;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Player extends GameObject {

    Random r = new Random();

    public Player (int x, int y, ID id) {

        super(x, y, id);

        //velX = r.nextInt(5)+1; //+1 guarantee that every qube will move
        //velY = r.nextInt(5);

    }

    @Override
    public void tick() {
        x += velX;
        y += velY;




    }

    @Override
    public void render(Graphics g) {
        if(id == ID.Player)g.setColor(Color.green);
        else if(id == ID.Player2)g.setColor(Color.pink);
        g.fillRect(x, y, 32, 32);
    }
}
