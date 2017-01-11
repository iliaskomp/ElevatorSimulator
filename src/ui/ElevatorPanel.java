package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class ElevatorPanel extends JPanel{
	private static final int X = 50;
	private static final int WIDTH = 150;
	private static final int HEIGHT = 50;
	private int y;
	
	public ElevatorPanel () {
		y = 300;
	}
	
    public void paintComponent(Graphics g) {   	
    	g.fillRect(X, y, WIDTH, HEIGHT);
    	
    	g.drawLine(X, 0, X, 500);
    	g.drawLine(X + WIDTH, 0, X + WIDTH, 500);

    }
    
    public void setY(int y) {
    	this.y = y;
    }
}
