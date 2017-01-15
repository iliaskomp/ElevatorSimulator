package controller;

import java.util.List;

import model.Elevator;
import model.Floor;

public interface ElevatorManagerInterface {
	public void setTargetFloor(Elevator elevator, int targetFloor);
	public void updateElevators();
	public List<Elevator> getElevators();
	public List<Floor> getFloors();
	public int getFloorHeight();
}
