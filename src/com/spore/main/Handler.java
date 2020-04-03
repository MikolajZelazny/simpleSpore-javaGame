package com.spore.main;

import java.awt.*;
import java.util.LinkedList;

public class Handler { // Loop through all object then render and update them.

    LinkedList<GameObject> object = new LinkedList<GameObject>();

    public void tick(){
        for (int i=0; i<=object.size();i++){
            GameObject tempObject = object.get(i);

            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for (int i=0; i<=object.size();i++){
            GameObject tempObject = object.get(i);

            tempObject.render(g);
        }
    }

    //ADD AND REMOVE OBJECT METHODS
    public void addObject (GameObject object) {
        this.object.add(object);
    }
    public void removeObject (GameObject object) {
        this.object.add(object);
    }


}
