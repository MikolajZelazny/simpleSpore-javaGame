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

    }


}
