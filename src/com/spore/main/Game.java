package com.spore.main;

import java.awt.*;
import java.awt.image.ImageObserver;

// Główna klasa która będzie wszystko przechowywać, np. tu "narysujemy" nasz ekran i przechowamy metodę main z grą.
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 3855241409607072348L; // Co to jest?

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; // Setting window size
    private Thread thread; // Wątek dla całej gry (single-threaded game)
    private boolean running = false;

    public Game(){
        new Window(HEIGHT, WIDTH, "Siple Spore The Game", this);
    }

    public synchronized void start () { // Implementacja metody zawartej w klasie "Window"
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop () {
        try {
            thread.join();
            running=false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // abstrakcyjna metoda z interejsu "Runnable"
    public void run() {

    }

    public static void main (String[] args) {
        new Game(); //New instance of Game class which gonna call instructor
    }

}
