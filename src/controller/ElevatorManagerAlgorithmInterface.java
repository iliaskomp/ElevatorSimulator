package controller;

import java.rmi.RemoteException;

import model.Elevator;

public interface ElevatorManagerAlgorithmInterface {

	void controlElevator(Elevator e, ElevatorManagerInterface manager) throws RemoteException;

}