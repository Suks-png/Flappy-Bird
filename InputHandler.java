package com.flappybirdjava.utils;

import com.flappybirdjava.entities.Bird;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class InputHandler extends KeyAdapter {
    private Bird bird;
    
    public InputHandler(Bird bird) {
        this.bird = bird;
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.jump();
        }
    }
}