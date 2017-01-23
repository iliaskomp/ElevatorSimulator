package controller;

import ui.UIInterface;

public interface ElevatorManagerMainInterface {
	void updateElevators();
	void setUI(UIInterface ui);
	void setAlgorithm(ElevatorManagerAlgorithmInterface algorithm);
}
