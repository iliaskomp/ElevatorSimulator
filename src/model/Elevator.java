package model;

import java.util.List;

public class Elevator {
	private int position;
	private int speed;
	private int weight;
	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	private enum Direction {UP, DOWN, NONE};
	private boolean doorStatus;
	private int nearestFloor;
	private List<Floor> floors;

	public Elevator(int position, int speed, int weight, boolean doorStatus, int nearestFloor, List<Floor> floors) {
		super();
		this.position = position;
		this.speed = speed;
		this.weight = weight;
		this.doorStatus = doorStatus;
		this.nearestFloor = nearestFloor;
		this.floors = floors;
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
	


}
