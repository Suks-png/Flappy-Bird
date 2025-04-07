package com.flappybirdjava.ui;

import com.flappybirdjava.entities.Bird;
import com.flappybirdjava.entities.Pipe;
import com.flappybirdjava.entities.Score;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

public class GamePanel extends JPanel {
    private static final int PANEL_WIDTH = 800;
    private static final int PANEL_HEIGHT = 600;
    private static final Color BACKGROUND_COLOR = new Color(135, 206, 235); // Sky blue
    private static final Color GROUND_COLOR = new Color(139, 69, 19); // Brown
    
    private Bird bird;
    private List<Pipe> pipes;
    private Score score;
    
    public GamePanel(Bird bird, List<Pipe> pipes, Score score) {
        this.bird = bird;
        this.pipes = pipes;
        this.score = score;
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw background
        g.setColor(BACKGROUND_COLOR);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
        
        // Draw ground
        g.setColor(GROUND_COLOR);
        g.fillRect(0, PANEL_HEIGHT - 50, PANEL_WIDTH, 50);
        
        // Draw grass
        g.setColor(Color.GREEN);
        g.fillRect(0, PANEL_HEIGHT - 50, PANEL_WIDTH, 10);
        
        // Draw clouds
        g.setColor(Color.WHITE);
        g.fillOval(100, 80, 80, 40);
        g.fillOval(500, 120, 100, 50);
        g.fillOval(300, 50, 70, 35);
        
        // Draw pipes
        for (Pipe pipe : pipes) {
            pipe.render(g);
        }
        
        // Draw bird
        bird.render(g);
        
        // Draw score
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 36));
        g.drawString("Score: " + score.getValue(), 20, 50);
    }
}
