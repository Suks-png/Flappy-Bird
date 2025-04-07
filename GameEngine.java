package com.flappybirdjava.engine;

import com.flappybirdjava.entities.Bird;
import com.flappybirdjava.entities.Pipe;
import com.flappybirdjava.entities.PipeGenerator;
import com.flappybirdjava.entities.Score;
import com.flappybirdjava.ui.GamePanel;
import com.flappybirdjava.ui.GameWindow;
import com.flappybirdjava.utils.CollisionDetector;
import com.flappybirdjava.utils.InputHandler;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GameEngine implements ActionListener {
    private GameWindow window;
    private GamePanel panel;
    private Timer gameTimer;
    private Bird bird;
    private List<Pipe> pipes;
    private PipeGenerator pipeGenerator;
    private Score score;
    private CollisionDetector collisionDetector;
    private InputHandler inputHandler;
    private boolean isGameRunning;
    private static final int GAME_SPEED = 10; // milliseconds per frame
    
    public GameEngine() {
        pipes = new ArrayList<>();
        pipeGenerator = new PipeGenerator();
        score = new Score();
        collisionDetector = new CollisionDetector();
        isGameRunning = false;
    }
    
    public void initialize() {
        bird = new Bird(100, 300);
        panel = new GamePanel(bird, pipes, score);
        window = new GameWindow(panel);
        inputHandler = new InputHandler(bird);
        panel.addKeyListener(inputHandler);
        panel.setFocusable(true);
        gameTimer = new Timer(GAME_SPEED, this);
    }
    
    public void start() {
        isGameRunning = true;
        gameTimer.start();
    }
    
    public void stop() {
        isGameRunning = false;
        gameTimer.stop();
    }
    
    public void restart() {
        stop();
        pipes.clear();
        bird.reset();
        score.reset();
        start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!isGameRunning) return;
        
        // Update game objects
        bird.update();
        
        // Generate pipes if needed
        if (pipeGenerator.shouldGeneratePipe()) {
            Pipe newPipe = pipeGenerator.generatePipe();
            pipes.add(newPipe);
        }
        
        // Update pipes and remove off-screen pipes
        List<Pipe> pipesToRemove = new ArrayList<>();
        for (Pipe pipe : pipes) {
            pipe.update();
            
            // Check if pipe is off-screen
            if (pipe.getX() < -pipe.getWidth()) {
                pipesToRemove.add(pipe);
            }
            
            // Check if bird scored a point (passed a pipe)
            if (!pipe.isScored() && pipe.getX() + pipe.getWidth() < bird.getX()) {
                pipe.setScored(true);
                score.increment();
            }
        }
        pipes.removeAll(pipesToRemove);
        
        // Check collisions
        if (collisionDetector.checkCollisions(bird, pipes) || bird.isOutOfBounds()) {
            gameOver();
        }
        
        // Repaint the panel
        panel.repaint();
    }
    
    private void gameOver() {
        stop();
        int choice = JOptionPane.showConfirmDialog(
            window, 
            "Game Over! Your score: " + score.getValue() + "\nPlay again?", 
            "Game Over", 
            JOptionPane.YES_NO_OPTION
        );
        
        if (choice == JOptionPane.YES_OPTION) {
            restart();
        } else {
            System.exit(0);
        }
    }
}
