package controller;

import java.rmi.RemoteException;

import model.Elevator;

public interface ElevatorManagerAlgorithm {

	void controlElevator(Elevator e) throws RemoteException;

}