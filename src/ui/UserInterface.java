package ui;

import java.util.List;

import controller.ElevatorManagerInterface;
import model.Elevator;
import model.Floor;


public interface UserInterface {
	public void update(List<Elevator> elevators, List<Floor> floors);
	public void addElevator(Elevator elevator);
	public void showError(String message);
	public void show();
	public void setElevatorManager(ElevatorManagerInterface elevatorManager);
}
