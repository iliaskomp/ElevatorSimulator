package controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import model.Elevator;
import model.Floor;
import sqelevator.IElevator;
import ui.UIInterface;

public class ElevatorManager implements ElevatorManagerInterface {
	private static final int MAX_REMOTE_EXCEPTIONS = 5;
	private List<Elevator> elevators;
	private IElevator controller;
	private List<Floor> floors;
	//introduced it to handle remote exceptions only in the update method, and not in the setUI
	private boolean listsInitialized;

	private UIInterface ui;
	private int exceptionsCatched, floorHeight;

	public ElevatorManager(IElevator controller) {
		this.controller = controller;
		ui = null;
		listsInitialized = false;
		elevators = null;
	}

	private void addElevators() throws RemoteException {
		elevators = new ArrayList<Elevator>();
		for (int i = 0; i < controller.getElevatorNum(); i++) {
			Elevator e = new Elevator(i);
			e.setName("Elevator " + i);
			elevators.add(e);
		}
	}

	public void updateElevators() {
		if (exceptionsCatched > MAX_REMOTE_EXCEPTIONS)
			return;
		try {
			if(!listsInitialized)
			{
				createFloorsList();
				addElevators();
				listsInitialized = true;
			}

			for (Elevator e : elevators) {
				updateElevator(e);
			}

			exceptionsCatched = 0;
		} catch (RemoteException e) {
			exceptionsCatched++;
			if (exceptionsCatched > MAX_REMOTE_EXCEPTIONS)
				ui.showError("Connection lost to the elevator. Please restart the application.");
		}
	}

	private void updateElevator(Elevator e) throws RemoteException {
		int n = e.getElevatorNumber();

		e.setPosition(controller.getElevatorPosition(n));
		e.setSpeed(controller.getElevatorSpeed(n));
		e.setWeight(controller.getElevatorCapacity(n));
		e.setDoorStatus(controller.getElevatorDoorStatus(n));
		e.setCommitedDirection(controller.getCommittedDirection(n));
		e.setNearestFloor(controller.getElevatorFloor(n));
	}

	public void setTargetFloor(Elevator elevator, int targetFloor) {
		try {
			controller.setTarget(elevator.getElevatorNumber(), targetFloor);
			int direction = elevator.getNearestFloor() < targetFloor ? IElevator.ELEVATOR_DIRECTION_UP
					: IElevator.ELEVATOR_DIRECTION_DOWN;
			controller.setCommittedDirection(elevator.getElevatorNumber(), direction);
		} catch (RemoteException e) {
			exceptionsCatched++;
			if (exceptionsCatched > MAX_REMOTE_EXCEPTIONS)
				ui.showError("Connection lost to the elevator. Please restart the application.");
		}
	}

	private void createFloorsList() throws RemoteException {
		floors = new ArrayList<>();
		for (int i = 0; i < controller.getFloorNum(); i++) {
			floors.add(new Floor(i));
		}
		floorHeight = controller.getFloorHeight();
	}

	// Getters/Setters

	public List<Elevator> getElevators() {
		return elevators;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public int getFloorHeight() {
		return floorHeight;
	}
}
