package model;

/**
 * The Class Elevator.
 * Model of the elevator.
 * @author Ilias Komp
 */
public class Elevator {
	
	/** The elevator number. */
	private int elevatorNumber;
	
	/** The position. */
	private int position; // position in feet
	
	/** The position nearest floor. */
	private int positionNearestFloor; // position in relation to nearest floor
	
	/** The speed. */
	private int speed;
	
	/** The weight. */
	private int weight;
	
	/** The door status. */
	private int doorStatus;
	
	/** The manual mode. */
	private boolean manualMode;
	
	/** The name. */
	private String name;
	
	/** The commited direction. */
	private int commitedDirection;
	
	/** The target floor. */
	private int targetFloor;

	/**
	 * Instantiates a new elevator.
	 *
	 * @param elevatorNumber the elevator number
	 */
	public Elevator(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}

	/**
	 * Gets the elevator number.
	 *
	 * @return the elevator number
	 */
	// Getters/Setters
	public int getElevatorNumber() {
		return elevatorNumber;
	}

	/**
	 * Sets the elevator number.
	 *
	 * @param elevatorNumber the new elevator number
	 */
	public void setElevatorNumber(int elevatorNumber) {
		this.elevatorNumber = elevatorNumber;
	}

	/**
	 * Gets the door status.
	 *
	 * @return the door status
	 */
	public int getDoorStatus() {
		return doorStatus;
	}

	/**
	 * Sets the door status.
	 *
	 * @param doorStatus the new door status
	 */
	public void setDoorStatus(int doorStatus) {
		this.doorStatus = doorStatus;
	}

	/**
	 * Gets the position.
	 *
	 * @return the position
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the new position
	 */
	public void setPosition(int position) {
		this.position = position;
	}

	/**
	 * Gets the speed.
	 *
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * Sets the speed.
	 *
	 * @param speed the new speed
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * Checks if is manual mode.
	 *
	 * @return true, if is manual mode
	 */
	public boolean isManualMode() {
		return manualMode;
	}

	/**
	 * Sets the manual mode.
	 *
	 * @param manualMode the new manual mode
	 */
	public void setManualMode(boolean manualMode) {
		this.manualMode = manualMode;
	}

	/**
	 * Gets the nearest floor.
	 *
	 * @return the nearest floor
	 */
	public int getNearestFloor() {
		return positionNearestFloor;
	}

	/**
	 * Sets the nearest floor.
	 *
	 * @param nearestFloor the new nearest floor
	 */
	public void setNearestFloor(int nearestFloor) {
		this.positionNearestFloor = nearestFloor;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the commited direction.
	 *
	 * @return the commited direction
	 */
	public int getCommitedDirection() {
		return commitedDirection;
	}

	/**
	 * Sets the commited direction.
	 *
	 * @param commitedDirection the new commited direction
	 */
	public void setCommitedDirection(int commitedDirection) {
		this.commitedDirection = commitedDirection;
	}

	/**
	 * Gets the target floor.
	 *
	 * @return the target floor
	 */
	public int getTargetFloor() {
		return targetFloor;
	}

	/**
	 * Sets the target floor.
	 *
	 * @param targetFloor the new target floor
	 */
	public void setTargetFloor(int targetFloor) {
		this.targetFloor = targetFloor;
	}

}
