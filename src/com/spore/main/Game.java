package com.spore.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.ImageObserver;
import java.util.Random;

//TODO Someday translate it into C# in unity project for mobs.

// Główna klasa która będzie wszystko przechowywać, np. tu "narysujemy" nasz ekran i przechowamy metodę main z grą.
public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 3855241409607072348L; // Co to jest?

    public static final int WIDTH = 1080, HEIGHT = WIDTH / 12 * 9; // Setting window size
    private Thread thread; // Wątek dla całej gry (single-threaded game)
    private boolean running = false;

    private Random r;
    private Handler handler;
    private HUD hud;

    public Game() {
        handler = new Handler(); /* should be above Window initialization of Window because
         Window starting up start() method, which call run method, which call render which then uses handler method.
         NullPointerException sometimes when initializing something that doesn't exist. */

        this.addKeyListener(new KeyInput(handler)); //Inform the game we are using keys and tell it to listen them.
        new Window(WIDTH, HEIGHT, "Siple Spore The Game", this);
        hud = new HUD();

        r = new Random();

        handler.addObject(new Player(WIDTH/2-32,HEIGHT/2-32, ID.Player));
        handler.addObject(new Player(WIDTH/2+32,HEIGHT/2-32, ID.Player2));
        handler.addObject(new BasicEnemy(WIDTH/2+30,HEIGHT/2-30, ID.Player2)); //key events of Player2 are same as Enemy objects so they follows him.
        handler.addObject(new BasicEnemy(WIDTH/2+30,HEIGHT/2-30, ID.BasicEnemy));
        handler.addObject(new Follower(WIDTH/2-32,HEIGHT/2-32, ID.Player));
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
        hud.tick();
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

        hud.render(g);
        handler.render(g);//kolejność ma znaczenie

        g.dispose();
        bs.show();
    }

    public static int clamp (int var, int min, int max) { // for use in many situations
        if (var >= max) return max;
        else if (var <= min) return min;
        else return var;
    }

    public static void main (String[] args) {
        new Game(); //New instance of Game class which gonna call instructor
    }

}
