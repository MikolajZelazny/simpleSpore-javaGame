package com.spore.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;
    public KeyInput(Handler handler) { // Everything we put into handler constructor gonna input to this.
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // get code of pressed keys on keyboard.

        System.out.println(key);
    }

    public void keyReleased(KeyEvent e) {

    }
}
