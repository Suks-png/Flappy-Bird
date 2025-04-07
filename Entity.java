package com.flappybirdjava.entities;

// Abstract class for all game entities
public abstract class Entity {
    protected float x;
    protected float y;
    protected int width;
    protected int height;
    protected float velocityX;
    protected float velocityY;
    
    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = 0;
        this.velocityY = 0;
    }
    
    public abstract void update();
    
    // Getters and setters
    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public int getWidth() {
        return width;
    }
    
    public int getHeight() {
        return height;
    }
    
    public float getVelocityX() {
        return velocityX;
    }
    
    public float getVelocityY() {
        return velocityY;
    }
    
    public void setX(float x) {
        this.x = x;
    }
    
    public void setY(float y) {
        this.y = y;
    }
    
    public void setVelocityX(float velocityX) {
        this.velocityX = velocityX;
    }
    
    public void setVelocityY(float velocityY) {
        this.velocityY = velocityY;
    }
}
