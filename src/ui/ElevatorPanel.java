package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.Elevator;
import model.Floor;

@SuppressWarnings("serial")
public class ElevatorPanel extends JPanel {
	private static final int OFFSET = 50;
	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 30;
	private static int panelHeight;

	private int floorsNumber, elevatorYPos, floorHeight;
	private boolean isInitialized;
	private List<Floor> floors;

	public ElevatorPanel(int floorHeight) {
		isInitialized = false;
		elevatorYPos = 0;
		this.floorHeight = floorHeight;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(new Color(0, 255, 0));
		g.fillRect(OFFSET, elevatorYPos, RECT_WIDTH, RECT_HEIGHT);
		g.setColor(new Color(0, 0, 0));
		g.drawRect(OFFSET, OFFSET, RECT_WIDTH, panelHeight);
		int callMarkX = RECT_WIDTH + Math.round(OFFSET * 1.2f);
		int callMarkR = RECT_HEIGHT / 2;
		int textX = RECT_WIDTH / 4 + OFFSET;
		for (int i = 0; i < floorsNumber; i++) {
			g.setColor(new Color(0, 0, 0));
			g.drawString("Floor " + i, textX,
					Math.round((floorsNumber - i - 0.25f) * RECT_HEIGHT + OFFSET));
			Floor floor = floors.get(i);
			int callMarkY = Math.round((floorsNumber - i - 0.25f) * RECT_HEIGHT) + OFFSET-callMarkR;
			g.setColor(new Color(0, 128, 0));
			if (floor.isUpCall()) {
				g.fillOval(callMarkX, callMarkY, callMarkR, callMarkR);
			} else {
				g.drawOval(callMarkX, callMarkY, callMarkR, callMarkR);
			}
			g.setColor(new Color(255, 87, 51));
			if (floor.isDownCall()) {
				g.fillOval(callMarkX + OFFSET / 2, callMarkY, callMarkR, callMarkR);
			} else {
				g.drawOval(callMarkX + OFFSET / 2, callMarkY, callMarkR, callMarkR);
			}
		}

		int legendY = panelHeight + 2 * OFFSET;
		g.setColor(new Color(0, 128, 0));
		g.fillOval(callMarkX, legendY-callMarkR, callMarkR, callMarkR);
		g.setColor(new Color(255, 87, 51));
		g.fillOval(callMarkX, legendY-callMarkR + RECT_HEIGHT, callMarkR, callMarkR);
		g.setColor(new Color(0, 0, 0));
		g.drawString("Up Call", textX, legendY);
		g.drawString("Down Call", textX, legendY + RECT_HEIGHT);
	}

	public int update(Elevator elevator, List<Floor> floors) {
		if (!isInitialized) {
			this.floorsNumber = floors.size();
			panelHeight = RECT_HEIGHT * floorsNumber;
			this.setPreferredSize(new Dimension(RECT_WIDTH + 2 * OFFSET, panelHeight + 3 * OFFSET + 2 * RECT_HEIGHT));
			isInitialized = true;
		}
		setElevatorHeight(elevator.getPosition());
		this.floors = floors;
		return this.elevatorYPos;
	}

	// Set Elevator Height (in feet) which is the y point of the rectangle
	private void setElevatorHeight(int feet) {
		int position = Math.round(((float) feet / floorHeight) * RECT_HEIGHT);
		this.elevatorYPos = panelHeight - position + OFFSET - RECT_HEIGHT;
		repaint();
	}

}
