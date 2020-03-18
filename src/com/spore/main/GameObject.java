package com.spore.main;

public abstract class GameObject { //All objects like "coins","enemy","player" inherrits same functions.
    protected int x, y; // chyba współrzędne
    protected ID id;
    protected int velX, velY;  // speed of moving into x and y direction
}
