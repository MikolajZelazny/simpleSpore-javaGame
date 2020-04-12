package com.spore.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.util.Random;

//TODO Someday translate it into C# in unity project for mobs.

// Główna klasa która będzie wszystko przechowywać, np. tu "narysujemy" nasz ekran i przechowamy metodę main z grą.
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 3855241409607072348L; // Co to jest?

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; // Setting window size
    private Thread thread; // Wątek dla całej gry (single-threaded game)
    private boolean running = false;

    private Random r;
    private Handler handler;

    public Game() {
        handler = new Handler(); // should be above Window initializaion of Window because
        // Window starting up start() method, which call run method, which call render which then uses handler method.
        // NullPointerException sometimes when initializing something that doesn't exist.
        this.addKeyListener(new KeyInput());
        new Window(WIDTH, HEIGHT, "Siple Spore The Game", this);

        r = new Random();

        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player));

    }

    public synchronized void start () { // Implementacja metody zawartej w klasie "Window"
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop () {
        try {
            thread.join(); // ZNALZC CO DAJE TEN JOIN
            running=false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // abstrakcyjna metoda z interejsu "Runnable"

    public void run() { // GAME LOOP
            long lastTime = System.nanoTime();
            double amountOfTicks = 60.0;
            double ns = 1000000000 / amountOfTicks;
            double delta = 0;
            long timer = System.currentTimeMillis();
            int frames = 0;
            while(running)
            {
                long now = System.nanoTime();
                delta += (now - lastTime) / ns;
                lastTime = now;
                while(delta >=1)
                {
                    tick();
                    delta--;
                }
                if(running)
                    render();
                frames++;

                if(System.currentTimeMillis() - timer > 1000)
                {
                    timer += 1000;
                    System.out.println("FPS: "+ frames);
                    frames = 0;
                }
            }
            stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() { // POCZYTAC O BUFFER I GRAPHICS (rendering systems)
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return; // Co to za return?
        }

        Graphics g = bs.getDrawGraphics();



        g.setColor(Color.lightGray);
        g.fillRect(0,0,WIDTH,HEIGHT);

        handler.render(g);//kolejność ma znaczenie

        g.dispose();
        bs.show();


    }

    public static void main (String[] args) {
        new Game(); //New instance of Game class which gonna call instructor
    }

}
