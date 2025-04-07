package com.flappybirdjava.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import com.flappybirdjava.engine.*;

public class Bird extends Entity {
    private static final float GRAVITY = 0.25f;
    private static final float JUMP_FORCE = -5.0f;
    private static final int BIRD_SIZE = 30;
    private static final int SCREEN_HEIGHT = 600;
    
    public Bird(float x, float y) {
        super(x, y, BIRD_SIZE, BIRD_SIZE);
    }
    
    @Override
    public void update() {
        // Apply gravity
        velocityY += GRAVITY;
        
        // Update position
        y += velocityY;
    }
    
    
    
    public void render(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillOval((int)x, (int)y, width, height);
        
        // Add eye
        g.setColor(Color.BLACK);
        g.fillOval((int)(x + width * 0.7), (int)(y + height * 0.3), width / 6, height / 6);
        
        // Add beak
        g.setColor(Color.ORANGE);
        int[] xPoints = {(int)(x + width), (int)(x + width * 1.3), (int)(x + width)};
        int[] yPoints = {(int)(y + height * 0.4), (int)(y + height * 0.5), (int)(y + height * 0.6)};
        g.fillPolygon(xPoints, yPoints, 3);
    }
    
    public Rectangle getBounds() {
        return new Rectangle((int)x, (int)y, width, height);
    }
    
    public boolean isOutOfBounds() {
        return y < 0 || y + height > SCREEN_HEIGHT;
    }
    
    public void reset() {
        y = 300;
        velocityY = 0;
    }

	public  void jump() {
		
		 velocityY = JUMP_FORCE;
	}
}

