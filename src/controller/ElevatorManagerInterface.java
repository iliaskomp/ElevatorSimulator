package controller;

import java.util.List;

import model.Elevator;
import model.Floor;
import ui.UIInterface;

public interface ElevatorManagerInterface {
	public void setTargetFloor(Elevator elevator, int targetFloor);
	public void updateElevators();
	public List<Elevator> getElevators();
	public List<Floor> getFloors();
	public int getFloorHeight();
	public void setAutomaticMode(boolean automaticMode);
	public boolean getAutomaticMode();
	public void setUI(UIInterface ui);
}
