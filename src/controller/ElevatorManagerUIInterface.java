package controller;

import java.util.List;

import model.Elevator;
import model.Floor;

public interface ElevatorManagerUIInterface extends ElevatorManagerInterface {

	void setAutomaticMode(boolean automaticMode);

	boolean isAutomaticMode();

	List<Elevator> getElevators();

	List<Floor> getFloors();

	int getFloorHeight();

}