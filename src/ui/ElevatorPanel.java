package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.rmi.RemoteException;

import javax.swing.JPanel;

import controller.ElevatorManager;

public class ElevatorPanel extends JPanel{
	private static final int RECT_X = 50;
	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 30;
	private static final int FEET_PER_FLOOR = 6;
	private static int PANEL_HEIGHT;
	
	private int floors;	
	private int y;
	
	public ElevatorPanel () {
		try {			
			floors = ElevatorManager.getNumberOfFloors();
			PANEL_HEIGHT = floors * RECT_HEIGHT; 
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		y = 0;
		
		
	}
	
    public void paintComponent(Graphics g) {  
    	  super.paintComponent(g);
    	g.fillRect(RECT_X, PANEL_HEIGHT - y, RECT_WIDTH + 1, RECT_HEIGHT);    	
    
    	g.drawLine(RECT_X, 0, RECT_X, PANEL_HEIGHT);
    	g.drawLine(RECT_X + RECT_WIDTH, 0, RECT_X + RECT_WIDTH, PANEL_HEIGHT);

    }
    
    // Set Elevator Height (in feet) which is the y point of the rectangle
    public void setElevatorHeight(int feet) {
    	this.y = feet * (PANEL_HEIGHT /(floors * FEET_PER_FLOOR) );
    	System.out.println("feet: " + feet + " - y: " + y);
    	repaint();
    }
    
    
    
}
