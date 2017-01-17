package controller;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.ConnectException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import model.Elevator;
import sqelevator.IElevator;
import test.DummyElevatorSimulator;
import ui.SwingUserInterface;

public class ElevatorManagerTest {
	
	private static final int MAX_REMOTE_EXCEPTIONS = 5;
	private ElevatorManager manager;
	private IElevator controller;
//	private UserInterface ui;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		controller = new DummyElevatorSimulator();
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
	public void testDefaultDirectionUncommited() {
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_UNCOMMITTED, manager.getElevators().get(0).getCommitedDirection());
	}		
	
	@Test
	public void testElevatorDirectionUp() throws RemoteException {
		manager.updateElevators();
		manager.setTargetFloor(manager.getElevators().get(0), 5);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_UP, manager.getElevators().get(0).getCommitedDirection());
	}
	
	@Test
	public void testElevatorDirectionDown() throws RemoteException {
		manager.updateElevators();
		manager.setTargetFloor(manager.getElevators().get(0), 5);
		manager.updateElevators();
		manager.setTargetFloor(manager.getElevators().get(0), 0);
		manager.updateElevators();
		assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, manager.getElevators().get(0).getCommitedDirection());
	}
//	Exceptions
	@Test
	public void testSetInvalidControllerUrl() throws MalformedURLException, RemoteException, NotBoundException {
		thrown.expect(RemoteException.class);
		controller = (IElevator) Naming.lookup("rmi://localhost/WrongUrl");
	}
	
//	public void testSetTargetFloorThrowsException() {
//	}
	
//	@Test
//	public void testElevatorsNullWhenMaxRemoteExceptionsThrown() throws RemoteException {		
//		int exceptionsCatched = 0;
//
//		while (exceptionsCatched <= MAX_REMOTE_EXCEPTIONS) {
//			try {
//				throw new RemoteException();
//			} catch (RemoteException e){
//				exceptionsCatched++;
//			}
//		}
//		
//		assertEquals(null, manager.getElevators());
//		manager.updateElevators();
//		// not working!
//		// assertEquals(null, manager.getElevators());
//	}
	
	
	
	
	
	
}
