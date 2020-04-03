package com.spore.main;

import java.awt.*;

public abstract class GameObject { //All objects like "coins","enemy","player" inherrits same functions.
    protected int x, y; // chyba współrzędne
    protected ID id;
    protected int velX, velY;  // speed of moving into x and y direction

    public GameObject (int x, int y, ID id) { // class constructor (set object parameters)
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
