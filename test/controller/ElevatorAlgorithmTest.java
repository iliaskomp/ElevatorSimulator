package controller;

import static org.easymock.EasyMock.*;

import java.rmi.RemoteException;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;

public class ElevatorAlgorithmTest {

	private ElevatorManagerAlgorithmInterface algorithm;
	private IElevator controller;
	private Elevator elevator;
	@Rule
	public EasyMockRule rule = new EasyMockRule(this);

	@Mock
	private ElevatorManagerInterface manager;

	@Before
	public void setUp() {
		controller = new DummyElevator();
		algorithm = new ElevatorManager(controller);
		elevator = new Elevator(0);
		elevator.setNearestFloor(0);
		elevator.setTargetFloor(0);
		elevator.setDoorStatus(IElevator.ELEVATOR_DOORS_OPEN);
	}

	@Test
	public void testGoesUpFromBottom() throws RemoteException
	{
		expect(manager.getFloorsCount()).andReturn(10);
		manager.setTargetFloor(elevator, 1);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}

	@Test
	public void testGoesDownFromTop() throws RemoteException
	{
		elevator.setNearestFloor(9);
		elevator.setTargetFloor(9);
		expect(manager.getFloorsCount()).andReturn(10);
		manager.setTargetFloor(elevator, 8);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}

	@Test
	public void testDoesNothingWhenDoorsClosed() throws RemoteException
	{
		elevator.setDoorStatus(IElevator.ELEVATOR_DOORS_CLOSED);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}

	@Test
	public void testDoesNothingWhenMoving() throws RemoteException
	{
		elevator.setSpeed(1);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}

	@Test
	public void testInvalidCommittedDirection() throws RemoteException
	{
		elevator.setNearestFloor(5);
		elevator.setTargetFloor(5);
		elevator.setCommitedDirection(100);
		expect(manager.getFloorsCount()).andReturn(10);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}

	@Test
	public void testDoesNothingWhenNotAtTargetYet() throws RemoteException
	{
		elevator.setNearestFloor(1);
		replay(manager);
		algorithm.controlElevator(elevator, manager);
	}


	@After
	public void tearDown()
	{
		verify(manager);
	}

}
