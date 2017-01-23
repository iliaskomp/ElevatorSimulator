package ui;

import controller.ElevatorManagerUIInterface;

/**
 * The Interface UIInterface.
 */
public interface UIInterface {

	/**
	 * Show error.
	 *
	 * @param message the message
	 */
	public void showError(String message);

	/**
	 * Show.
	 */
	public void show();

	/**
	 * Update.
	 */
	public void update();

	/**
	 * Sets the elevator manager.
	 *
	 * @param elevatorManager the new elevator manager
	 */
	public void setElevatorManager(ElevatorManagerUIInterface elevatorManager);
}
