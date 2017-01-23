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

import controller.ElevatorManagerUIInterface;
import model.Elevator;
import sqelevator.IElevator;


/**
 * The Class SwingUserInterface
 * Takes care of UI, sets up the UI and updates it with the values taken
 * from ElevatorManager.

 * 
 * @author Ilias, Viktor
 */
public class SwingUI implements UIInterface {
	
	/** The position text field. */
	protected JTextField positionTextField;
	
	/** The direction text field. */
	protected JTextField directionTextField;

	/** The speed text field. */
	protected JTextField speedTextField;

	/** The payload text field. */
	protected JTextField payloadTextField;

	/** The door status text field. */
	protected JTextField doorStatusTextField;

	/** The target text field. */
	protected JTextField targetTextField;

	/** The go target button. */
	protected JButton goTargetButton;

	/** The frame. */
	private JFrame frame;

	/** The elevator selector (dropdown) */
	private JComboBox<String> elevatorSelector;

	/** The selected elevator according to the dropdown. */
	private Elevator selectedElevator;

	/** The elevator manager. */
	private ElevatorManagerUIInterface elevatorManager;

	/** The elevator panel. */
	private ElevatorPanel elevatorPanel;

	/** The elevator scroll pane. */
	private JScrollPane elevatorScrollPane;

	/** The Constant TEXTFIELD_LENGTH. */
	private static final int TEXTFIELD_LENGTH = 8;

	/** The scroll pane last Y. */
	private int scrollPaneLastY;

	/**
	 * Instantiates a new swing user interface.
	 */
	public SwingUI() {
		elevatorSelector = new JComboBox<String>();
		scrollPaneLastY = 0;
	}

	/* (non-Javadoc)
	 * @see ui.UIInterface#update()
	 */
	public void update() {
		for (Elevator e : elevatorManager.getElevators()) {
			if (e.getName().equals(getSelectedElevatorName())) {
				selectedElevator = e;
			}
		}
		updateUiData(selectedElevator);
		int y = elevatorPanel.update(selectedElevator, elevatorManager.getFloors());
		Rectangle bounds = elevatorScrollPane.getViewport().getViewRect();
		y = (y - (bounds.height / 2));
		if (y != scrollPaneLastY) {
			elevatorScrollPane.getViewport().setViewPosition(new Point(0, y));
			scrollPaneLastY = y;
		}
	}

	/**
	 * Update ui data for the selected elevator (from dropdown)
	 *
	 * @param e the selected elevator
	 */
	private void updateUiData(Elevator e) {
		if (e != null) {
			setPositionTextField(e.getPosition() + "");
			setDirectionTextField(e.getCommitedDirection());
			setSpeedTextField(e.getSpeed() + "");
			setPayloadTextField(e.getWeight() + "");
			setDoorStatusTextField(e.getDoorStatus());
		}

	}

	/**
	 * Setup the panels on the UI
	 */
	protected void setup() {
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

		setupDataPanel(dataPanel);

		changeFont(frame, new Font("Roboto", Font.PLAIN, 18));
		frame.setPreferredSize(new Dimension(1000, 750));
		frame.pack();
	}

	/* (non-Javadoc)
	 * @see ui.UIInterface#show()
	 */
	public void show() {
		setup();
		frame.setVisible(true);
	}

	/**
	 * Setup the data panel without the values 
	 *
	 * @param dataPanel the data panel (right panel)
	 */
	private void setupDataPanel(JPanel dataPanel) {
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
		doorStatusTextField = new JTextField(TEXTFIELD_LENGTH);
		doorStatusLabel.setLabelFor(doorStatusTextField);
		doorStatusTextField.setFocusable(false);
		dataListPanel.add(doorStatusTextField);
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
		if (elevatorManager.isAutomaticMode()) {
			automaticButton.setSelected(true);
		} else {
			manualButton.setSelected(true);
		}
		ButtonGroup group = new ButtonGroup();
		group.add(automaticButton);
		group.add(manualButton);
		dataListPanel.add(automaticButton);
		dataListPanel.add(manualButton);
		automaticButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				elevatorManager.setAutomaticMode(true);
				goTargetButton.setEnabled(false);
				targetTextField.setEnabled(false);

			}
		});
		manualButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				elevatorManager.setAutomaticMode(false);
				goTargetButton.setEnabled(true);
				targetTextField.setEnabled(true);

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

	/**
	 * Change font on all components of the ui.
	 *
	 * @param component the component
	 * @param font the font
	 */
	public static void changeFont(Component component, Font font) {
		component.setFont(font);
		if (component instanceof Container) {
			for (Component child : ((Container) component).getComponents()) {
				changeFont(child, font);
			}
		}
	}

	/* (non-Javadoc)
	 * @see ui.UIInterface#showError(java.lang.String)
	 */
	@Override
	public void showError(String message) {
		JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/**
	 * Sets the position text field.
	 *
	 * @param position the new position
	 */
	// Getters/Setters
	private void setPositionTextField(String position) {
		positionTextField.setText(position);
	}

	/**
	 * Sets the direction text field.
	 *
	 * @param commitedDirection the new direction
	 */
	private void setDirectionTextField(int commitedDirection) {
		String direction;
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
		default:
			direction = "Invalid";
			break;
		}
		directionTextField.setText(direction);
	}

	/**
	 * Sets the speed text field.
	 *
	 * @param speed the new speed
	 */
	private void setSpeedTextField(String speed) {
		speedTextField.setText(speed);
	}

	/**
	 * Sets the payload text field.
	 *
	 * @param payload the new payload
	 */
	private void setPayloadTextField(String payload) {
		payloadTextField.setText(payload);
	}

	/**
	 * Sets the door status text field.
	 *
	 * @param doorStatus the new door status
	 */
	private void setDoorStatusTextField(int doorStatus) {
		String status;
		switch (doorStatus) {
		case IElevator.ELEVATOR_DOORS_CLOSED:
			status = "Closed";
			break;
		case IElevator.ELEVATOR_DOORS_CLOSING:
			status = "Closing";
			break;
		case IElevator.ELEVATOR_DOORS_OPEN:
			status = "Open";
			break;
		case IElevator.ELEVATOR_DOORS_OPENING:
			status = "Opening";
			break;
		default:
			status = "Invalid";
			break;
		}
		doorStatusTextField.setText(status);
	}

	/**
	 * Gets the selected elevator name.
	 *
	 * @return the selected elevator name
	 */
	private String getSelectedElevatorName() {
		return elevatorSelector.getSelectedItem().toString();
	}

	/* (non-Javadoc)
	 * @see ui.UIInterface#setElevatorManager(controller.ElevatorManagerInterface)
	 */
	public void setElevatorManager(ElevatorManagerUIInterface elevatorManager) {
		this.elevatorManager = elevatorManager;
		for (Elevator elevator : elevatorManager.getElevators()) {
			elevatorSelector.addItem(elevator.getName());
		}
	}

}
