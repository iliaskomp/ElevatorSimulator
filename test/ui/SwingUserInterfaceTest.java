package ui;

import static org.junit.Assert.*;

import java.awt.Button;
import java.rmi.RemoteException;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import controller.ElevatorManager;
import controller.ElevatorManagerInterface;
import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;
import test.DummyElevatorSimulator;

public class SwingUserInterfaceTest {
	private IElevator controller;
	private SwingUserInterface ui;
	private ElevatorManager manager;
	private Elevator elevator;
	
	@Before
	public void setUp() {		
		controller = new DummyElevator();
		manager = new ElevatorManager(controller);
		manager.updateElevators();
		ui = new SwingUserInterface();
		ui.setElevatorManager(manager);
		ui.show();
		manager.updateElevators();
		ui.update();
		elevator = manager.getElevators().get(0);
	}
	
	@Test
	public void testPositionTextField() throws RemoteException {
		int positionText = Integer.parseInt(ui.positionTextField.getText());		
		assertEquals(elevator.getPosition(), positionText);		
	}
	
	@Test
	public void testSpeedTextField() throws RemoteException {
		int speedText = Integer.parseInt(ui.speedTextField.getText());		
		assertEquals(elevator.getSpeed(), speedText);		
	}

	@Test
	public void testWeightTextField() throws RemoteException {
		int positionText = Integer.parseInt(ui.payloadTextField.getText());		
		assertEquals(elevator.getWeight(), positionText);		
	}
	
	@Test
	public void testDoorStatusTextField() throws RemoteException {
		int doorStatusText = Integer.parseInt(ui.doorsTextField.getText());		
		assertEquals(elevator.getDoorStatus(), doorStatusText);		
	}
	
	@Test
	public void testCommitedDirectionTextField() throws RemoteException {
		String commitedDirectionText = ui.directionTextField.getText();
		int commitedDirection = elevator.getCommitedDirection();
		String commitedDirectionString = null;
		if (commitedDirection == 1) {
			commitedDirectionString = "Down";
		}
		assertEquals(commitedDirectionString, commitedDirectionText);		
	}

	
//	@Test
//	public void testGoButtonClick() throws InterruptedException, RemoteException {
//		JButton go = ui.goTargetButton;
//		ui.targetTextField.setText("11");
//		go.doClick();
//	}
}
