package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ElevatorManager;
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
	private boolean manualMode;	

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
		frame.getContentPane().add(elevatorSelector,BorderLayout.PAGE_START);

		JPanel elevatorPanel = new ElevatorPanel();
		JPanel dataPanel = new JPanel();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, elevatorPanel, dataPanel);
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);

		frame.getContentPane().add(splitPane,BorderLayout.CENTER);

		updateElevatorPanel(elevatorPanel);
		updateDataPanel(dataPanel);
		
		changeFont(frame, new Font("Roboto", Font.PLAIN, 18));
		frame.setVisible(true);
		frame.pack();

	}



	private void updateElevatorPanel(JPanel elevatorPanel) {

	}

	private void updateDataPanel(JPanel dataPanel) {
	        //Create and populate the panel.
	        JPanel dataListPanel = new JPanel(new SpringLayout());

	        // Position
            JLabel positionLabel = new JLabel("Position: ", JLabel.TRAILING);
            dataListPanel.add(positionLabel);
            positionTextField = new JTextField(5);
            positionLabel.setLabelFor(positionTextField);
            positionTextField.setFocusable(false);
            dataListPanel.add(positionTextField);
            dataListPanel.add(new JLabel(""));
            
            // Direction
            JLabel directionLabel = new JLabel("Direction: ", JLabel.TRAILING);
            dataListPanel.add(directionLabel);
            directionTextField = new JTextField(5);
            directionLabel.setLabelFor(directionTextField);
            directionTextField.setFocusable(false);
            dataListPanel.add(directionTextField);
            dataListPanel.add(new JLabel(""));

            // Speed
            JLabel speedLabel = new JLabel("Speed: ", JLabel.TRAILING);
            dataListPanel.add(speedLabel);
            speedTextField = new JTextField(5);
            speedLabel.setLabelFor(speedTextField);
            speedTextField.setFocusable(false);
            dataListPanel.add(speedTextField);
            dataListPanel.add(new JLabel(""));

            // Payload
            JLabel payloadLabel = new JLabel("Payload: ", JLabel.TRAILING);
            dataListPanel.add(payloadLabel);
            payloadTextField = new JTextField(5);
            payloadLabel.setLabelFor(payloadTextField);
            payloadTextField.setFocusable(false);
            dataListPanel.add(payloadTextField);
            dataListPanel.add(new JLabel(""));

            // Door Status
            JLabel doorStatusLabel = new JLabel("Door Status: ", JLabel.TRAILING);
            dataListPanel.add(doorStatusLabel);
            doorsTextField = new JTextField(5);
            doorStatusLabel.setLabelFor(doorsTextField);
            doorsTextField.setFocusable(false);
            dataListPanel.add(doorsTextField);
            dataListPanel.add(new JLabel(""));

            // Target
            JLabel targetLabel = new JLabel("Target Floor: ", JLabel.TRAILING);
            dataListPanel.add(targetLabel);
            targetTextField = new JTextField(5);
            targetLabel.setLabelFor(targetTextField);
            dataListPanel.add(targetTextField);
            targetTextField.setBackground(new Color(0, 255, 0));

            goTargetButton = new JButton("GO");
            dataListPanel.add(goTargetButton);
            goTargetButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {
					int targetFloor = Integer.parseInt(targetTextField.getText());
					try {
						ElevatorManager.setTargetFloor(0, targetFloor);
					} catch (RemoteException e1) {
						e1.printStackTrace();
					}					
				}
			});

            // Mode
            JLabel modeLabel = new JLabel("Mode: ", JLabel.TRAILING);
            dataListPanel.add(modeLabel);

            JRadioButton automaticButton = new JRadioButton("Automatic");
            JRadioButton manualButton = new JRadioButton("Manual");
            ButtonGroup group = new ButtonGroup();
            group.add(automaticButton);
            group.add(manualButton);
            dataListPanel.add(automaticButton);
            dataListPanel.add(manualButton);                                            
            automaticButton.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent e) {				
					System.out.println("Automatic mode activated");
					manualMode = true;
	            	goTargetButton.setEnabled(false);

				}
			});
            manualButton.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {				
					System.out.println("Manual mode activated");
					manualMode = false;
	            	goTargetButton.setEnabled(true);

				}
			});

            
	        //Lay out the panel.
	        SpringUtilities.makeCompactGrid(dataListPanel,
	                                        7, 3, 		   //rows, cols
	                                        10, 10,        //initX, initY
	                                        10, 10);       //xPad, yPad

	        //Set up the content pane.
	        dataListPanel.setOpaque(true);  //content panes must be opaque

	        dataPanel.add(dataListPanel);

	}
	public static void changeFont ( Component component, Font font )
	{
	    component.setFont(font);
	    if ( component instanceof Container ) {
	        for ( Component child : ((Container)component).getComponents()) {
	            changeFont (child, font);
	        }
	    }
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
	
	public boolean isManualMode() {
		return manualMode;
	}

	public void setManualMode(boolean manualMode) {
		this.manualMode = manualMode;
	}

}
