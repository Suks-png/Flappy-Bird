package com.flappybirdjava.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Pipe extends Entity {
    private static final int PIPE_WIDTH = 80;
    private static final int PIPE_SPEED = -3;
    private static final int SCREEN_HEIGHT = 600;
    
    private int gapHeight;
    private int gapPosition;
    private boolean isScored;
    
    public Pipe(float x, int gapPosition, int gapHeight) {
        super(x, 0, PIPE_WIDTH, SCREEN_HEIGHT);
        this.gapPosition = gapPosition;
        this.gapHeight = gapHeight;
        this.velocityX = PIPE_SPEED; // Assuming velocityX is defined in the Entity class
        this.isScored = false;
    }
    
    @Override
    public void update() {
        x += velocityX; // Move the pipe to the left
    }
    
    public void render(Graphics g) {
        g.setColor(Color.GREEN);
        
        // Draw top pipe
        g.fillRect((int)x, 0, width, gapPosition);
        
        // Draw bottom pipe
        g.fillRect((int)x, gapPosition + gapHeight, width, SCREEN_HEIGHT - (gapPosition + gapHeight));
        
        // Add pipe cap
        g.setColor(new Color(0, 100, 0));
        g.fillRect((int)x - 5, gapPosition - 20, width + 10, 20); // Top cap
        g.fillRect((int)x - 5, gapPosition + gapHeight, width + 10, 20); // Bottom cap
    }
    
    public Rectangle getTopBounds() {
        return new Rectangle((int)x, 0, width, gapPosition);
    }
    
    public Rectangle getBottomBounds() {
        return new Rectangle((int)x, gapPosition + gapHeight, width, SCREEN_HEIGHT - (gapPosition + gapHeight));
    }
    
    public boolean isScored() {
        return isScored;
    }
    
    public void setScored(boolean scored) {
        isScored = scored;
    }
}