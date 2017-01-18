package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import controller.ElevatorManagerInterface;
import model.Elevator;
import model.Floor;
import sqelevator.IElevator;

public class SwingUserInterface implements UIInterface {
	protected JTextField positionTextField;
	protected JTextField directionTextField;
	protected JTextField speedTextField;
	protected JTextField payloadTextField;
	protected JTextField doorsTextField;
	protected JTextField targetTextField;
	protected JButton goTargetButton;
	private JFrame frame;
	private JComboBox<String> elevatorSelector;
	private boolean manualMode;
	private Elevator selectedElevator;
	private ElevatorManagerInterface elevatorManager;
	private ElevatorPanel elevatorPanel;
	private JScrollPane elevatorScrollPane;
	private static final int TEXTFIELD_LENGTH = 8;

	public SwingUserInterface() {
		elevatorSelector = new JComboBox<String>();
	}

	public void update() {
		for (Elevator e : elevatorManager.getElevators()) {
			if (e.getName().equals(getSelectedElevatorName())) {
				selectedElevator = e;
			}
		}
		updateUiData(selectedElevator);
		int y = elevatorPanel.update(selectedElevator, elevatorManager.getFloors());
		Rectangle bounds = elevatorScrollPane.getViewport().getViewRect();
		y = (y - (bounds.height/2));
		elevatorScrollPane.getViewport().setViewPosition(new Point(0, y));
	}

	private void updateUiData(Elevator e) {
		if (e != null) {
			setPositionTextField(e.getPosition() + "");
			setDirectionTextField(e.getCommitedDirection());
			setSpeedTextField(e.getSpeed() + "");
			setPayloadTextField(e.getWeight() + "");
			setDoorStatusTextField(e.getDoorStatus() + "");
		}

	}

	public void show() {
		frame = new JFrame("Elevator Management");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.getContentPane().add(elevatorSelector, BorderLayout.PAGE_START);

		elevatorPanel = new ElevatorPanel(elevatorManager.getFloorHeight());
		elevatorScrollPane = new JScrollPane(elevatorPanel);
		elevatorScrollPane.setViewportView(elevatorPanel);
		JPanel dataPanel = new JPanel();

		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, elevatorScrollPane, dataPanel);
		splitPane.setResizeWeight(0.5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setContinuousLayout(true);

		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		updateDataPanel(dataPanel);

		changeFont(frame, new Font("Roboto", Font.PLAIN, 18));
		frame.setPreferredSize(new Dimension(1000, 750));
		frame.pack();
		frame.setVisible(true);

	}

	private void updateDataPanel(JPanel dataPanel) {
		// Create and populate the panel.
		JPanel dataListPanel = new JPanel(new SpringLayout());

		// Position
		JLabel positionLabel = new JLabel("Position (Feet): ", JLabel.TRAILING);
		dataListPanel.add(positionLabel);
		positionTextField = new JTextField(TEXTFIELD_LENGTH);
		positionLabel.setLabelFor(positionTextField);
		positionTextField.setFocusable(false);
		dataListPanel.add(positionTextField);
		dataListPanel.add(new JLabel(""));

		// Direction
		JLabel directionLabel = new JLabel("Direction: ", JLabel.TRAILING);
		dataListPanel.add(directionLabel);
		directionTextField = new JTextField(TEXTFIELD_LENGTH);
		directionLabel.setLabelFor(directionTextField);
		directionTextField.setFocusable(false);
		dataListPanel.add(directionTextField);
		dataListPanel.add(new JLabel(""));

		// Speed
		JLabel speedLabel = new JLabel("Speed: ", JLabel.TRAILING);
		dataListPanel.add(speedLabel);
		speedTextField = new JTextField(TEXTFIELD_LENGTH);
		speedLabel.setLabelFor(speedTextField);
		speedTextField.setFocusable(false);
		dataListPanel.add(speedTextField);
		dataListPanel.add(new JLabel(""));

		// Payload
		JLabel payloadLabel = new JLabel("Payload: ", JLabel.TRAILING);
		dataListPanel.add(payloadLabel);
		payloadTextField = new JTextField(TEXTFIELD_LENGTH);
		payloadLabel.setLabelFor(payloadTextField);
		payloadTextField.setFocusable(false);
		dataListPanel.add(payloadTextField);
		dataListPanel.add(new JLabel(""));

		// Door Status
		JLabel doorStatusLabel = new JLabel("Door Status: ", JLabel.TRAILING);
		dataListPanel.add(doorStatusLabel);
		doorsTextField = new JTextField(TEXTFIELD_LENGTH);
		doorStatusLabel.setLabelFor(doorsTextField);
		doorsTextField.setFocusable(false);
		dataListPanel.add(doorsTextField);
		dataListPanel.add(new JLabel(""));

		// Target
		JLabel targetLabel = new JLabel("Target Floor: ", JLabel.TRAILING);
		dataListPanel.add(targetLabel);
		targetTextField = new JTextField(TEXTFIELD_LENGTH);
		targetLabel.setLabelFor(targetTextField);
		dataListPanel.add(targetTextField);
		targetTextField.setBackground(new Color(0, 255, 0));

		goTargetButton = new JButton("GO");
		dataListPanel.add(goTargetButton);
		goTargetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int targetFloor = Integer.parseInt(targetTextField.getText());
				elevatorManager.setTargetFloor(selectedElevator, targetFloor);

			}
		});

		// Mode
		JLabel modeLabel = new JLabel("Mode: ", JLabel.TRAILING);
		dataListPanel.add(modeLabel);

		JRadioButton automaticButton = new JRadioButton("Automatic");
		JRadioButton manualButton = new JRadioButton("Manual");
		manualButton.setSelected(true);
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

		// Lay out the panel.
		SpringUtilities.makeCompactGrid(dataListPanel, 7, 3, // rows, cols
				10, 10, // initX, initY
				10, 10); // xPad, yPad

		// Set up the content pane.
		dataListPanel.setOpaque(true); // content panes must be opaque

		dataPanel.add(dataListPanel);

	}

	public static void changeFont(Component component, Font font) {
		component.setFont(font);
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont(child, font);
			}
		}
	}

	@Override
	public void showError(String message) {
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	// Getters/Setters
	private void setPositionTextField(String position) {
		positionTextField.setText(position);
	}

	private void setDirectionTextField(int commitedDirection) {
		String direction = "Invalid";
		switch (commitedDirection) {
		case IElevator.ELEVATOR_DIRECTION_DOWN:
			direction = "Down";
			break;
		case IElevator.ELEVATOR_DIRECTION_UP:
			direction = "Up";
			break;
		case IElevator.ELEVATOR_DIRECTION_UNCOMMITTED:
			direction = "Uncommitted";
			break;
		}
		directionTextField.setText(direction);
	}

	private void setSpeedTextField(String speed) {
		speedTextField.setText(speed);
	}

	private void setPayloadTextField(String payload) {
		payloadTextField.setText(payload);
	}

	private void setDoorStatusTextField(String doors) {
		doorsTextField.setText(doors);
	}

	private String getSelectedElevatorName() {
		return elevatorSelector.getSelectedItem().toString();
	}

	public void setElevatorManager(ElevatorManagerInterface elevatorManager) {
		this.elevatorManager = elevatorManager;
		for (Elevator elevator : elevatorManager.getElevators()) {
			elevatorSelector.addItem(elevator.getName());
		}
	}

}
