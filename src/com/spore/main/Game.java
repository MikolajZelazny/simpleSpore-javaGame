package com.spore.main;

import java.awt.*;
import java.awt.image.ImageObserver;

// Główna klasa która będzie wszystko przechowywać, np. tu "narysujemy" nasz ekran i przechowamy metodę main z grą.
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 3855241409607072348L; // Co to jest?

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; // Setting window size

    public Game(){
        new Window(HEIGHT, WIDTH, "Siple Spore The Game", this);
    }

    public synchronized void start () {

    }

    @Override // abstrakcyjna metoda z interejsu "Runnable"
    public void run() {

    }

    public static void main (String[] args) {
        new Game(); //New instance of Game class which gonna call instructor
    }

}
