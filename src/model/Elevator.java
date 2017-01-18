package model;

public class Elevator {
	private int elevatorNumber;
	private int position; // position in feet
	private int positionNearestFloor; // position in relation to nearest floor
	private int speed;
	private int weight;
	private int doorStatus;
	private boolean manualMode;
	private String name;
	private int commitedDirection;
	private int targetFloor;

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

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCommitedDirection() {
		return commitedDirection;
	}

	public void setCommitedDirection(int commitedDirection) {
		this.commitedDirection = commitedDirection;
	}

	public int getTargetFloor() {
		return targetFloor;
	}

	public void setTargetFloor(int targetFloor) {
		this.targetFloor = targetFloor;
	}

}
