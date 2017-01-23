package ui;

import controller.ElevatorManagerInterface;

/**
 * The Interface UIInterface.
 * @author Ilias, Viktor
 */
public interface UIInterface {
	
	/**
	 * Show an error if there are a number of remote exceptions
	 *
	 * @param message the error message
	 */
	public void showError(String message);
	
	/**
	 * Sets up the UI structure without any values.
	 */
	public void show();
	
	/**
	 * Update the UI from the data of ElevatorManager for the selected Elevator
	 */
	public void update();
	
	/**
	 * Sets the elevator manager.
	 *
	 * @param elevatorManager the new elevator manager
	 */
	public void setElevatorManager(ElevatorManagerInterface elevatorManager);
}
