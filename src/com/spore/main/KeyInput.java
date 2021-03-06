package com.spore.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
    // TODO add keyEvent (ctr+<some move key(W,A,S,D) to turn cell into other direction which add speed to front direction
    private Handler handler;

    public KeyInput(Handler handler) { // Everything we put into handler constructor gonna input to this.
        this.handler=handler;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode(); // get code of pressed keys on keyboard.

        for (int i=0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if(tempObject.getId() == ID.Player) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_W) tempObject.setVelY(-5); // setVelY is better than setY
                if (key == KeyEvent.VK_S) tempObject.setVelY(5);
                if (key == KeyEvent.VK_D) tempObject.setVelX(5);
                if (key == KeyEvent.VK_A) tempObject.setVelX(-5);
            }
            if(tempObject.getId() == ID.Player2) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-5);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(5);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(5);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-5);
            }
        }

        System.out.println(key);

        if (key == KeyEvent.VK_ESCAPE) System.exit(1);
    }


    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_W) tempObject.setVelY(0);
                if (key == KeyEvent.VK_S) tempObject.setVelY(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
            }
            if (tempObject.getId() == ID.Player2) { //KEYBOARD SETTINGS
                if (key == KeyEvent.VK_UP) tempObject.setVelY(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
            }

        }
    }
}
