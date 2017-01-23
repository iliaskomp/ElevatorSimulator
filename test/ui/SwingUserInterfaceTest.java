package ui;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import controller.ElevatorManager;
import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;

/**
 * 
 * Test for the SwingUserInterface class
* @author Ilias, Viktor
 *
 */
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
		ui.setup();
		manager.updateElevators();
		ui.update();
		elevator = manager.getElevators().get(0);
	}

	@Test
	public void testPositionTextField() {
		int positionText = Integer.parseInt(ui.positionTextField.getText());
		assertEquals(elevator.getPosition(), positionText);
	}

	@Test
	public void testSpeedTextField() {
		int speedText = Integer.parseInt(ui.speedTextField.getText());
		assertEquals(elevator.getSpeed(), speedText);
	}

	@Test
	public void testWeightTextField() {
		int positionText = Integer.parseInt(ui.payloadTextField.getText());
		assertEquals(elevator.getWeight(), positionText);
	}

	@Test
	public void testDoorStatusTextField() {
		assertEquals(IElevator.ELEVATOR_DOORS_CLOSED, elevator.getDoorStatus());
		assertEquals("Closed", ui.doorStatusTextField.getText());
	}

	@Test
	public void testCommitedDirectionTextField() {
		assertEquals(IElevator.ELEVATOR_DIRECTION_UNCOMMITTED, elevator.getCommitedDirection());
		assertEquals("Uncommitted", ui.directionTextField.getText());
	}


	@Test
	public void testGoButtonClick() {
		ui.targetTextField.setText("10");
		ui.goTargetButton.doClick();
		manager.updateElevators();
		assertEquals(10, elevator.getTargetFloor());
	}
}
