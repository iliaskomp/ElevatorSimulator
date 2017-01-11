package ui;

import java.util.List;

import model.Elevator;


public interface UserInterface {
	public void update(List<Elevator> elevators);
	public void addElevator(String elevatorName);
	public void showError(String message);
	public void show();
}
