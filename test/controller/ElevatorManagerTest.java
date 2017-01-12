package controller;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevator;
import ui.SwingUserInterface;

public class ElevatorManagerTest {
	ElevatorManager manager;
	IElevator controller;
//	private UserInterface ui;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		controller = new DummyElevator();
		manager = new ElevatorManager(controller);
		
	}
		
	@Test
	public void testElevatorsSize() throws RemoteException {		
		manager.updateElevators();		
		assertEquals(controller.getElevatorNum(), manager.getElevators().size());
	}
	
	@Test
	public void testFloorsSize() throws RemoteException {		
		manager.updateElevators();		
		assertEquals(controller.getFloorNum(), manager.getFloors().size());
	}
	
	@Test
	public void testSetTargetToInvalidFloor() {
		thrown.expect(NullPointerException.class);
		manager.setTargetFloor(manager.getElevators().get(0), manager.getFloors().size() + 1);
		
	}
	
	@Test
	public void testExceptionThrownCallingInvalidElevator() {
		
	}
	
	// throw 5 exceptions
		
}
