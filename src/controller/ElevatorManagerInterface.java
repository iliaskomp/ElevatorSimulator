package controller;

import ui.UIInterface;

public interface ElevatorManagerInterface extends ElevatorManagerUIInterface {
	void updateElevators();
	void setUI(UIInterface ui);
	
}
