package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import model.Elevator;

public class SwingUserInterface implements UserInterface {		
	private JTextField positionTextField;	
	private JTextField directionTextField;
	private JTextField speedTextField;
	private JTextField payloadTextField;
	private JTextField doorsTextField;
	private JTextField targetTextField;
	private JButton goTargetButton;	
	

	private JComboBox<String> elevatorSelector;
	
	public void update(List<Elevator> elevators) {
		// TODO Auto-generated method stub
		
	}

	public void show() {
		JFrame frame = new JFrame("HelloWorldSwing");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		elevatorSelector = new JComboBox<String>();
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
            
            JLabel doorsLabel = new JLabel("Doors: ", JLabel.TRAILING);
            dataListPanel.add(doorsLabel);
            doorsTextField = new JTextField(5);
            doorsLabel.setLabelFor(doorsTextField);
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
            labels.add(doorsLabel);
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

	public void addToElevatorSelector(Elevator e) {
		elevatorSelector.addItem("Elevator " + e.getElevatorNumber());
	}
	
	// Getters/Setters
	public void setPositionTextField(JTextField positionTextField) {
		this.positionTextField = positionTextField;
	}

	public void setDirectionTextField(JTextField directionTextField) {
		this.directionTextField = directionTextField;
	}

	public void setSpeedTextField(JTextField speedTextField) {
		this.speedTextField = speedTextField;
	}

	public void setPayloadTextField(JTextField payloadTextField) {
		this.payloadTextField = payloadTextField;
	}

	public void setDoorsTextField(JTextField doorsTextField) {
		this.doorsTextField = doorsTextField;
	}

	public void setTargetTextField(JTextField targetTextField) {
		this.targetTextField = targetTextField;
	}
	
	
	public JComboBox<String> getElevatorSelector() {
		return elevatorSelector;
	}


}
