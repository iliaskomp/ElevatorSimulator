package ui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class ElevatorPanel extends JPanel{
	
    public void paintComponent(Graphics g) { // <-- HERE!    	
    	g.fillRect (10, 10, 100, 100);
    }

}
