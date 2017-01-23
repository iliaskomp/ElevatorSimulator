package controller;

import model.Elevator;

/**
 * The Interface ElevatorManagerInterface.
 */
public interface ElevatorManagerInterface {
	
	/**
	 * Sets the target floor.
	 *
	 * @param elevator the elevator
	 * @param targetFloor the target floor
	 */
	public void setTargetFloor(Elevator elevator, int targetFloor);
	
	/**
	 * Gets the floors count.
	 *
	 * @return the floors count
	 */
	public int getFloorsCount();
}
