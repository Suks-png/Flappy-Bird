package com.flappybirdjava.entities;

public class Score {
    private int value;
    
    public Score() {
        this.value = 0;
    }
    
    public void increment() {
        value++;
    }
    
    public int getValue() {
        return value;
    }
    
    public void reset() {
        value = 0;
    }
}
