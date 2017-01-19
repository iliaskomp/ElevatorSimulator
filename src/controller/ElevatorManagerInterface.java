package controller;

import java.util.List;

import model.Elevator;
import model.Floor;
import ui.UIInterface;

public interface ElevatorManagerInterface {
	void setTargetFloor(Elevator elevator, int targetFloor);
	void updateElevators();
	List<Elevator> getElevators();
	List<Floor> getFloors();
	int getFloorHeight();
	void setAutomaticMode(boolean automaticMode);
	boolean isAutomaticMode();
	void setUI(UIInterface ui);
}
