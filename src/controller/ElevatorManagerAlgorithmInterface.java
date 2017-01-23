package controller;

import java.rmi.RemoteException;

import model.Elevator;

/**
 * The Interface ElevatorManagerAlgorithmInterface.
 */
public interface ElevatorManagerAlgorithmInterface {

	/**
	 * Control elevator.
	 * This method specifies the algorithm with which the 
	 * elevators are being controlled
	 *
	 * @param e the elevator
	 * @param manager the elevator manager
	 * @throws RemoteException the remote exception
	 */
	void controlElevator(Elevator e, ElevatorManagerInterface manager) throws RemoteException;

}