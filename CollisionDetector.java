package com.flappybirdjava.utils;



import com.flappybirdjava.entities.Bird;
import com.flappybirdjava.entities.Pipe;

import java.util.List;

public class CollisionDetector {
    public boolean checkCollisions(Bird bird, List<Pipe> pipes) {
        for (Pipe pipe : pipes) {
            if (bird.getBounds().intersects(pipe.getTopBounds()) || 
                bird.getBounds().intersects(pipe.getBottomBounds())) {
                return true;
            }
        }
        return false;
    }
}