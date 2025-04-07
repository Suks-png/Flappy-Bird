package com.flappybirdjava.ui;

import javax.swing.JFrame;

public class GameWindow extends JFrame {
    public GameWindow(GamePanel panel) {
        setTitle("Flappy Bird");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        add(panel);
        pack();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
}

