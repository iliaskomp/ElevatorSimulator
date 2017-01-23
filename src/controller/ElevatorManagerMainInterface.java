package controller;

import ui.UIInterface;

// TODO: Auto-generated Javadoc
/**
 * The Interface ElevatorManagerMainInterface.
 */
public interface ElevatorManagerMainInterface {
	
	/**
	 * Update elevators.
	 */
	void updateElevators();
	
	/**
	 * Sets the ui.
	 *
	 * @param ui the new user interface
	 */
	void setUI(UIInterface ui);
	
	/**
	 * Sets the algorithm.
	 *
	 * @param algorithm the new algorithm
	 */
	void setAlgorithm(ElevatorManagerAlgorithmInterface algorithm);
}
