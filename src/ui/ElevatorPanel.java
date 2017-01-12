package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JPanel;

import controller.ElevatorManager;
import model.Elevator;
import model.Floor;

public class ElevatorPanel extends JPanel{
	private static final int RECT_X = 50;
	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 30;
	private static final int FEET_PER_FLOOR = 6;
	private static int PANEL_HEIGHT;

	private int floorsNumber;
	private int y;
	private boolean isInitialized;

	public ElevatorPanel () {
		isInitialized = false;
		y = 0;
	}

    public void paintComponent(Graphics g) {
    	  super.paintComponent(g);
    	g.fillRect(RECT_X, PANEL_HEIGHT - y, RECT_WIDTH + 1, RECT_HEIGHT);

    	g.drawLine(RECT_X, 0, RECT_X, PANEL_HEIGHT);
    	g.drawLine(RECT_X + RECT_WIDTH, 0, RECT_X + RECT_WIDTH, PANEL_HEIGHT);

    }

    public void update(Elevator elevator, List<Floor> floors)
    {
    	if(!isInitialized)
    	{
    		this.floorsNumber = floors.size();
    		PANEL_HEIGHT = floorsNumber * RECT_HEIGHT;
    		isInitialized = true;
    	}
    	setElevatorHeight(elevator.getPosition());
    }

    // Set Elevator Height (in feet) which is the y point of the rectangle
    private void setElevatorHeight(int feet) {
    	this.y = feet * (PANEL_HEIGHT /(floorsNumber * FEET_PER_FLOOR) );
    	System.out.println("feet: " + feet + " - y: " + y);
    	repaint();
    }



}
