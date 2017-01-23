package controller;

import java.rmi.RemoteException;

import model.Elevator;

/**
 * The Interface ElevatorManagerAlgorithm.
 */
public interface ElevatorManagerAlgorithm {

	/**
	 * Control elevator.
	 *
	 * @param e the e
	 * @throws RemoteException the remote exception
	 */
	void controlElevator(Elevator e) throws RemoteException;

}