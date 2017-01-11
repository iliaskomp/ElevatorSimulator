package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import model.Elevator;

public class SwingUserInterface implements UserInterface {
	private JTextField positionTextField;
	private JTextField directionTextField;
	private JTextField speedTextField;
	private JTextField payloadTextField;
	private JTextField doorsTextField;
	private JTextField targetTextField;
	private JButton goTargetButton;
	private JFrame frame;

	private JComboBox<String> elevatorSelector;

	public void update(List<Elevator> elevators) {
		Elevator selectedElevator = null;
		String eString = getSelectedElevator();
		
		for (Elevator e : elevators) {
			if (e.getElevatorNumber() == Integer.parseInt(eString.substring(eString.length() - 1))) {
				selectedElevator = e;
			}			
		}

		updateUiData(selectedElevator);
	}
	
	private void updateUiData(Elevator e) {
		if (e != null ) {
			setPositionTextField(e.getPosition() + "");
//			ui.setDirectionTextField(e.getDirection() + "");
			setSpeedTextField(e.getSpeed() + "");
			setPayloadTextField(e.getWeight() + "");
			setDoorStatusTextField(e.getDoorStatus() + "");
		}

	}

	public void show() {
		frame = new JFrame("Elevator Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		elevatorSelector = new JComboBox<String>();
	//	elevatorSelector.addItem("Elevator 1");
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

	}

	private void updateDataPanel(JPanel dataPanel) {
		  //  String[] labels = {"Position: ", "Direction: ", "Speed: ", "Payload: ", "Doors: "};
	      //  int numPairs = labels.length;

	        //Create and populate the panel.
	        JPanel dataListPanel = new JPanel(new SpringLayout());

            JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
            dataListPanel.add(positionLabel);
            positionTextField = new JTextField(5);
            positionLabel.setLabelFor(positionTextField);
            positionTextField.setFocusable(false);
            dataListPanel.add(positionTextField);

            JLabel directionLabel = new JLabel("Direction: ", JLabel.TRAILING);
            dataListPanel.add(directionLabel);
            directionTextField = new JTextField(5);
            directionLabel.setLabelFor(directionTextField);
            directionTextField.setFocusable(false);
            dataListPanel.add(directionTextField);

            JLabel speedLabel = new JLabel("Speed: ", JLabel.TRAILING);
            dataListPanel.add(speedLabel);
            speedTextField = new JTextField(5);
            speedLabel.setLabelFor(speedTextField);
            speedTextField.setFocusable(false);
            dataListPanel.add(speedTextField);

            JLabel payloadLabel = new JLabel("Payload: ", JLabel.TRAILING);
            dataListPanel.add(payloadLabel);
            payloadTextField = new JTextField(5);
            payloadLabel.setLabelFor(payloadTextField);
            payloadTextField.setFocusable(false);
            dataListPanel.add(payloadTextField);
            
            JLabel doorStatusLabel = new JLabel("Door Status: ", JLabel.TRAILING);
            dataListPanel.add(doorStatusLabel);
            doorsTextField = new JTextField(5);
            doorStatusLabel.setLabelFor(doorsTextField);
            doorsTextField.setFocusable(false);
            dataListPanel.add(doorsTextField);


            JLabel targetLabel = new JLabel("Target Floor: ", JLabel.TRAILING);
            dataListPanel.add(targetLabel);
            targetTextField = new JTextField(5);
            targetLabel.setLabelFor(targetTextField);
            dataListPanel.add(targetTextField);
            targetTextField.setBackground(new Color(0, 255, 0));


            JLabel emptyLabel = new JLabel();
            dataListPanel.add(emptyLabel);
            goTargetButton = new JButton("GO");
            dataListPanel.add(goTargetButton);


            List<JLabel> labels = new ArrayList<>();
            labels.add(positionLabel);
            labels.add(directionLabel);
            labels.add(speedLabel);
            labels.add(payloadLabel);
            labels.add(doorStatusLabel);
            labels.add(targetLabel);

            for (JLabel l : labels) {
                l.setFont(new Font("Roboto", Font.PLAIN, 18));

            }

	        //Lay out the panel.
	        SpringUtilities.makeCompactGrid(dataListPanel,
	                                        7, 2, //rows, cols
	                                        10, 10,        //initX, initY
	                                        10, 10);       //xPad, yPad

	        //Set up the content pane.
	        dataListPanel.setOpaque(true);  //content panes must be opaque

	        dataPanel.add(dataListPanel);
	}

	// Getters/Setters
	public void setPositionTextField(String position) {
		positionTextField.setText(position);
	}

	public void setDirectionTextField(String direction) {
		directionTextField.setText(direction);
	}

	public void setSpeedTextField(String speed) {
		speedTextField.setText(speed);
	}

	public void setPayloadTextField(String payload) {
		payloadTextField.setText(payload);
	}

	public void setDoorStatusTextField(String doors) {
		doorsTextField.setText(doors);
	}

	public void setTargetTextField(String target) {
		targetTextField.setText(target);
	}


	public JComboBox<String> getElevatorSelector() {
		return elevatorSelector;
	}
	
	public String getSelectedElevator() {
		return elevatorSelector.getSelectedItem().toString();
	}

	@Override
	public void addElevator(String elevatorName) {
		elevatorSelector.addItem(elevatorName);
	}

	@Override
	public void showError(String message) {
		JOptionPane.showMessageDialog(frame,
			    message,
			    "Error",
			    JOptionPane.ERROR_MESSAGE);
	}


}
