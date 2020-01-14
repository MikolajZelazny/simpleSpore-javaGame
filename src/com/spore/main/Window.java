package com.spore.main;

import javax.swing.*;
import java.awt.*;

// Only purpose of this class is to create window.
public class Window extends Canvas {

    private static final long serialVersionUID = -2581719437154533575L; // In IntelliJ "alt + Enter" za spacją.

    // Constructor containing also Game class because game will be inside window of c
    public Window (int height, int width, String title, Game game) {
        JFrame frame = new JFrame(title); // Window by using "JFrame" z Java library

        // EXPLANATION - LATER, for now - set maximum and minimum size of window
        frame.setPreferredSize(new Dimension(height, width));
        frame.setMaximumSize(new Dimension(height, width));
        frame.setMinimumSize(new Dimension(height, width));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // bez tego operacje nie zatrzymają się gdy wyłączymy gre
        frame.setResizable(false); // Wyłączenie możliwości zmiany wielkości okna co stworzyło by problemy
        frame.setLocationRelativeTo(null); // Nie wymagane ale pozwala włączyć okno na środku zamiast w górnym lewym rogu
        frame.add(game); // Dodanie zawartości klasy "Game" do zawartości okna
        frame.setVisible(true); // Aby można było wszystko widzieć - do dopytania
        game.start(); // Użycie metody z obiektu main

    }

}
