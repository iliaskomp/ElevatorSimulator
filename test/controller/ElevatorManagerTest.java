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
import ui.UserInterface;

public class ElevatorManagerTest {
	ElevatorManager manager;
	IElevator controller;
	private UserInterface ui;

	@Rule
	public final ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void setUp() {
		controller = new DummyElevator();
		manager = new ElevatorManager(controller);
		
		ui = new SwingUserInterface();
		ui.show();
		manager.setUi(ui);
	}
	
	
	@Test
	public void testUiInitializedFalseAtStart() {
		assertFalse(manager.IsUiInitialized());
	}
	
	@Test
	public void testUiNotNull() {
		assertNotEquals(null, ui);
	}
	@Test
	public void testElevatorsSize() throws RemoteException {		
		manager.addElevators();		
		assertEquals(controller.getElevatorNum(), manager.getElevators().size());
	}
	
	@Test
	public void testAddElevatorWithoutInitElevatorsList() throws RemoteException {
		Elevator e = new Elevator(0);
		
		thrown.expect(NullPointerException.class);
		manager.addElevator(e);

	} 
	
	@Test
	public void testAddElevator() throws RemoteException {
		manager.addElevators();		
		assertEquals(controller.getElevatorNum(), manager.getElevators().size());

		Elevator e = new Elevator(0);
		manager.addElevator(e);
		assertEquals(controller.getElevatorNum() + 1, manager.getElevators().size());

	} 
	
	@Test
	public void testCreateFloorsListSize() {

	}
	

		
}
