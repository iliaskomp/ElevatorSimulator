package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ElevatorPanel extends JPanel{
	private static final int X_POSITION = 50;
	private int y;
	
	public ElevatorPanel () {
		y = 300;
	}
	
    public void paintComponent(Graphics g) {   	
    	g.fillRect(X_POSITION, y, 80, 50);
    }
    
    public void setY(int y) {
    	this.y = y;
    }

}
