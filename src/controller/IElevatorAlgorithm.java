package controller;

import java.rmi.RemoteException;

import model.Elevator;

public interface IElevatorAlgorithm {

	void controlElevator(Elevator e) throws RemoteException;

}