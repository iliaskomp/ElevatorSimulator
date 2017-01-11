package ui;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.Elevator;

public class SwingUserInterface implements UserInterface {		
		
	public void update(List<Elevator> elevators) {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		JComboBox<String> elevatorSelector = new JComboBox<String>();
		elevatorSelector.addItem("Elevator 1");
		frame.getContentPane().add(elevatorSelector,BorderLayout.PAGE_START);

		JPanel elevatorPanel = new JPanel();
		JPanel dataPanel = new JPanel();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, elevatorPanel, dataPanel);
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);

		frame.getContentPane().add(splitPane,BorderLayout.CENTER);

		frame.pack();
		frame.setVisible(true);
		
		
		updateElevatorPanel(elevatorPanel);
		updateDataPanel(dataPanel);
		
	}

	
	
	private void updateElevatorPanel(JPanel elevatorPanel) {
		BorderLayout list = new BorderLayout();
		
		
	}			


	private void updateDataPanel(JPanel dataPanel) {
		// TODO Auto-generated method stub
		
	}

}
