package ui;

import controller.ElevatorManagerInterface;


public interface UIInterface {
	public void showError(String message);
	public void show();
	public void update();
	public void setElevatorManager(ElevatorManagerInterface elevatorManager);
}
