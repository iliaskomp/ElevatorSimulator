package model;

import java.util.ArrayList;
import java.util.List;

import sqelevator.IElevator;

public class Elevator {
	private int position;
	private int speed;
	private int weight;

	private enum Direction {UP, DOWN, NONE};
	private boolean doorStatus;
	private int nearestFloor;
	private List<Floor> floors;
	
	
	public Elevator(int numberOfFloors) {
		floors = new ArrayList<>();
		for (int i = 0; i < numberOfFloors; i++) {
			floors.add(new Floor(i));
		}
	}
		
	public void update(IElevator controller) {
		
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

	public boolean isDoorStatus() {
		return doorStatus;
	}

	public void setDoorStatus(boolean doorStatus) {
		this.doorStatus = doorStatus;
	}

	public int getNearestFloor() {
		return nearestFloor;
	}

	public void setNearestFloor(int nearestFloor) {
		this.nearestFloor = nearestFloor;
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
