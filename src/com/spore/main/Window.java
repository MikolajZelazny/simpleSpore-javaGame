package com.spore.main;

import javax.swing.*;
import java.awt.*;

// Only purpose of this class is to create window.
public class Window extends Canvas {

    private static final long serialVersionUID = -2581719437154533575L; // In IntelliJ "alt + Enter" za spacją.

    // Constructor containing also Game class because game will be inside window of c
    public Window (int height, int width, String title, Game game) {
        JFrame frame = new JFrame(title); // Window title by using "JFrame"

        // EXPLANATION - LATER
        frame.setPreferredSize(new Dimension(height, width));
        frame.setMaximumSize(new Dimension(height, width));
        frame.setMinimumSize(new Dimension(height, width));
    }

}
