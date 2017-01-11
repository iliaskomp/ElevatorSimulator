package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import model.Elevator;
import model.Floor;
import sqelevator.IElevator;
import ui.SwingUserInterface;
import ui.UserInterface;

public class ElevatorManager {
	private List<Elevator> elevators;
	private IElevator controller;
	private List<Floor> floors;

	private SwingUserInterface ui;

	public ElevatorManager(IElevator controller) throws RemoteException {
		this.controller = controller;	
		createFloorsList();
		
	}
	
	public void addElevators() throws RemoteException {
		elevators = new ArrayList<Elevator>();
		for (int i = 0; i < controller.getElevatorNum(); i++) {
			elevators.add(new Elevator(i));
			ui.addToElevatorSelector("Elevator " + i);
		}			
		
	}	
	
	public void addElevator(Elevator elevator) throws RemoteException {
		elevators.add(elevator);		
		elevator.setFloors(floors);
	}
	
	public void updateElevators() throws RemoteException {
		for (Elevator e : elevators) {
			updateElevator(e);
		}		
	}
	
	private void updateElevator(Elevator e) throws RemoteException{
		int n = e.getElevatorNumber();
		
		e.setPosition(controller.getElevatorPosition(n));	
		e.setSpeed(controller.getElevatorSpeed(n));
		e.setWeight(controller.getElevatorCapacity(n));
		e.setDoorStatus(controller.getElevatorDoorStatus(n));
		e.setNearestFloor(controller.getElevatorFloor(n));
	}
	
	public void setTargetFloor(int elevator, int floorTarget) {
		
	}
	
	private void createFloorsList() throws RemoteException {
		floors = new ArrayList<>();
		for (int i = 0; i < controller.getFloorNum(); i++) {
			floors.add(new Floor(i));
		}
	}
	
	// Getters/Setters
	public int getNumberOfFloors() throws RemoteException {
		return controller.getFloorNum();
	}
		
	public List<Elevator> getElevators() {
		return elevators;
	}
	
	public SwingUserInterface getUi() {
		return ui;
	}

	public void setUi(SwingUserInterface ui) throws RemoteException {
		this.ui = ui;
		addElevators();
	}

}
