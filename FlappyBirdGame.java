package com.flappybirdjava.main;



import com.flappybirdjava.engine.GameEngine;

public class FlappyBirdGame {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.initialize();
        gameEngine.start();
    }
}
