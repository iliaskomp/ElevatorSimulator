package controller;

import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.assertEquals;

import java.rmi.RemoteException;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import sqelevator.IElevator;
import test.DummyElevator;
import ui.UIInterface;

/**
 * 
 * Test for the ElevatorManager class
 * @author Ilias Komp
 *
 */
public class ElevatorManagerTest {

	private ElevatorManager manager;
	private IElevator controller;
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);
	@Mock
	private UIInterface uiMock;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();

	@Before
	public void setUp() {
		controller = new DummyElevator();
		manager = new ElevatorManager(controller);
		manager.updateElevators();
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
		assertEquals(IElevator.ELEVATOR_DIRECTION_UNCOMMITTED, manager.getElevators().get(0).getCommitedDirection());
		manager.setTargetFloor(manager.getElevators().get(0), 5);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_UP, manager.getElevators().get(0).getCommitedDirection());
		manager.setTargetFloor(manager.getElevators().get(0), 0);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, manager.getElevators().get(0).getCommitedDirection());
	}

	// Errors

	@Test
	public void testSetTargetToInvalidFloor() {
		uiMock.showError("Could not send the command to the elevator. Please try again.");
		replay(uiMock);
		manager.setUI(uiMock);
		manager.setTargetFloor(manager.getElevators().get(0), -1);
		verify(uiMock);
	}

	@Test
	public void testMultipleUpdateError() throws RemoteException {
		uiMock.showError("Connection lost to the elevator. Please restart the application.");
		replay(uiMock);
		manager.setUI(uiMock);
		manager.getElevators().get(0).setElevatorNumber(1);
		int exceptionsCatched = 0;
		while (exceptionsCatched <= ElevatorManager.MAX_REMOTE_EXCEPTIONS + 1) {
			manager.updateElevators();
			exceptionsCatched++;
		}
		verify(uiMock);
	}

}
