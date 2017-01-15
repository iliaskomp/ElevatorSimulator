package ui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import model.Elevator;
import model.Floor;

public class ElevatorPanel extends JPanel {
	private static final int OFFSET = 50;
	private static final int RECT_WIDTH = 150;
	private static final int RECT_HEIGHT = 30;
	private static int panelHeight;

	private int floorsNumber, y, floorHeight;
	private boolean isInitialized;

	public ElevatorPanel(int floorHeight) {
		isInitialized = false;
		y = 0;
		this.floorHeight = floorHeight;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(OFFSET, y, RECT_WIDTH, RECT_HEIGHT);
		g.drawLine(OFFSET, OFFSET, OFFSET, panelHeight + OFFSET);
		g.drawLine(OFFSET + RECT_WIDTH, OFFSET, OFFSET + RECT_WIDTH, panelHeight + OFFSET);
		for (int i = 0; i < floorsNumber; i++) {
			g.drawString("Floor " + i, RECT_WIDTH / 2, Math.round((floorsNumber - i - 0.25f) * RECT_HEIGHT + OFFSET));
		}
	}

	public int update(Elevator elevator, List<Floor> floors) {
		if (!isInitialized) {
			this.floorsNumber = floors.size();
			panelHeight = RECT_HEIGHT * floorsNumber;
			this.setPreferredSize(new Dimension(RECT_WIDTH + 2 * OFFSET, panelHeight + 2 * OFFSET));
			isInitialized = true;
		}
		setElevatorHeight(elevator.getPosition());
		return this.y;
	}

	// Set Elevator Height (in feet) which is the y point of the rectangle
	private void setElevatorHeight(int feet) {
		int position = Math.round(((float) feet / floorHeight) * RECT_HEIGHT);
		this.y = panelHeight - position + OFFSET - RECT_HEIGHT;
		repaint();
	}

}
