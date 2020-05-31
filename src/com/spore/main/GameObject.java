package com.spore.main;

import java.awt.*;

public abstract class GameObject { //All objects like "coins","enemy","player" inherrits same functions.
    protected int x, y; // chyba współrzędne
    protected ID id;
    protected int velX, velY;  // speed of moving into x and y direction

    public GameObject(int x, int y, ID id) { // class constructor (set object parameters)
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
    public abstract Rectangle getBounds();

    public int getX() { //Wszystkie są w klasie Player ale ukryte
        return x;
    }

    public int getY() {
        return y;
    }

    public ID getId() {
        return id;
    }

    public int getVelX() {
        return velX;
    }

    public int getVelY() {
        return velY;
    }
    // SETTERS

    public void setX(int x) {// Like constructor
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public void setVelX(int velX) {
        this.velX = velX;
    }

    public void setVelY(int velY) {
        this.velY = velY;
    }
}

