package controller;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.rmi.RemoteException;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;
import ui.UIInterface;

/**
 *
 * Test for the ElevatorManager class
 * @author Ilias, Viktor
 *
 */
public class ElevatorManagerTest {

	private ElevatorManager manager;
	private IElevator controller;
	private Elevator elevator;

	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	@Mock
	private UIInterface uiMock;
	@Mock
	private ElevatorManagerAlgorithmInterface algorithm;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		controller = new DummyElevator();
		manager = new ElevatorManager(controller);
		manager.updateElevators();
		elevator = manager.getElevators().get(0);
	}

	@Test
	public void testSetElevatorName() throws RemoteException {
		assertEquals("Elevator 0", elevator.getName());
	}

	@Test
	public void testElevatorsSize() throws RemoteException {
		assertEquals(controller.getElevatorNum(), manager.getElevators().size());
	}

	@Test
	public void testFloorsSize() throws RemoteException {
		assertEquals(controller.getFloorNum(), manager.getFloors().size());
	}

	@Test
	public void testElevatorCommitedDirection() {
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_UNCOMMITTED, elevator.getCommitedDirection());
		manager.setTargetFloor(elevator, 2);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_UP, elevator.getCommitedDirection());
		manager.setTargetFloor(elevator, 1);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, elevator.getCommitedDirection());
	}

	@Test
	public void testSetPosition() throws RemoteException {
		assertEquals(controller.getElevatorPosition(0), elevator.getPosition());
	}

	@Test
	public void testSetSpeed() throws RemoteException {
		assertEquals(controller.getElevatorSpeed(0), elevator.getSpeed());
	}

	@Test
	public void testSetWeight() throws RemoteException {
		assertEquals(controller.getElevatorWeight(0), elevator.getWeight());
	}

	@Test
	public void testSetDoorStatus() throws RemoteException {
		assertEquals(controller.getElevatorDoorStatus(0), elevator.getDoorStatus());
	}

	@Test
	public void testSetNearestFloor() throws RemoteException {
		assertEquals(controller.getElevatorFloor(0), elevator.getNearestFloor());
	}

	@Test
	public void testTargetFloor() throws RemoteException {
		assertEquals(controller.getTarget(0), elevator.getTargetFloor());
	}

	@Test
	public void testAutomaticMode() {
		manager.setAutomaticMode(true);
		assertTrue(manager.isAutomaticMode());
	}

	@Test
	public void testGetFloorHeight() throws RemoteException {
		assertEquals(controller.getFloorHeight(), manager.getFloorHeight());
	}

	@Test
	public void testAutomaticModeCalled() throws RemoteException {
		Elevator e = manager.getElevators().get(0);
		algorithm.controlElevator(e, manager);
		replay(algorithm);
		manager.setAlgorithm(algorithm);
		manager.setAutomaticMode(true);
		manager.updateElevators();
		verify(algorithm);
	}

	@Test
	public void testFloorsCount() throws RemoteException {
		assertEquals(controller.getFloorButtonUp(0), manager.getFloors().get(0).isUpCall());
		assertEquals(controller.getFloorButtonDown(9), manager.getFloors().get(9).isDownCall());
	}

	@Test
	public void testFloorsUpdated() {
		assertEquals(10, manager.getFloorsCount());
	}

	// Errors

	@Test
	public void testSetTargetToInvalidFloor() {
		uiMock.showError("Could not send the command to the elevator. Please try again.");
		replay(uiMock);
		manager.setUI(uiMock);
		manager.setTargetFloor(elevator, -1);
		verify(uiMock);
	}

	@Test
	public void testMultipleUpdateError() throws RemoteException {
		uiMock.showError("Connection lost to the elevator. Please restart the application.");
		replay(uiMock);
		manager.setUI(uiMock);
		elevator.setElevatorNumber(1);
		int exceptionsCatched = 0;
		while (exceptionsCatched <= ElevatorManager.MAX_REMOTE_EXCEPTIONS + 1) {
			manager.updateElevators();
			exceptionsCatched++;
		}
		verify(uiMock);
	}

}
