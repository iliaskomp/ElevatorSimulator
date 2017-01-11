package model;

import java.util.List;

public class Elevator {
	private int elevatorNumber;
	private int position; // position in feet
	private int positionNearestFloor; // position in relation to nearest floor
	private int speed;
	private int weight;
	private int doorStatus;
	private boolean manualMode;

	private List<Floor> floors;
	private enum Direction {UP, DOWN, NONE};
	
	public Elevator(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;				
	}

	
	
	// Getters/Setters			
	public int getElevatorNumber() {
		return elevatorNumber;
	}

	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}

	public int getDoorStatus() {
		return doorStatus;
	}
	
	public void setDoorStatus(int doorStatus) {
		this.doorStatus = doorStatus;
	}
	
	public int getPosition() {
		return position;
	}
	
	public void setPosition(int position) {
		this.position = position;
	}
	
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public boolean isManualMode() {
		return manualMode;
	}

	public void setManualMode(boolean manualMode) {
		this.manualMode = manualMode;
	}
	
	public int getNearestFloor() {
		return positionNearestFloor;
	}

	public void setNearestFloor(int nearestFloor) {
		this.positionNearestFloor = nearestFloor;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}
	
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
