package com.flappybirdjava.entities;

import java.util.Random;

public class PipeGenerator {
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int MIN_GAP_HEIGHT = 150;
    private static final int MAX_GAP_HEIGHT = 200;
    private static final int MIN_GAP_Y = 100;
    private static final int PIPE_INTERVAL = 150;
    
    private int framesSinceLastPipe;
    private Random random;
    
    public PipeGenerator() {
        framesSinceLastPipe = 0;
        random = new Random();
    }
    
    public boolean shouldGeneratePipe() {
        framesSinceLastPipe++;
        if (framesSinceLastPipe >= PIPE_INTERVAL) {
            framesSinceLastPipe = 0;
            return true;
        }
        return false;
    }
    
    public Pipe generatePipe() {
        int gapHeight = MIN_GAP_HEIGHT + random.nextInt(MAX_GAP_HEIGHT - MIN_GAP_HEIGHT);
        int maxGapY = SCREEN_HEIGHT - MIN_GAP_Y - gapHeight;
        int gapY = MIN_GAP_Y + random.nextInt(maxGapY - MIN_GAP_Y);
        
        return new Pipe(SCREEN_WIDTH, gapY, gapHeight);
    }
}

