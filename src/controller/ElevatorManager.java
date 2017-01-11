package controller;

import java.util.ArrayList;
import java.util.List;

import model.Elevator;

public class ElevatorManager {
	private List<Elevator> elevators;
	
	public ElevatorManager() {
		elevators = new ArrayList<Elevator>();
	}
	
	public void addElevator(Elevator elevator) {
		elevators.add(elevator);
	}
	
	public void updateElevators() {
		
	}
	
	public void setTargetFloor(int elevator, int floorTarget) {
		
	}
	
	public List<Elevator> getElevators() {
		return elevators;
	}
}
