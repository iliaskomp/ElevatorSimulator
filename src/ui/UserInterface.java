package ui;

import java.util.List;

import model.Elevator;


public interface UserInterface {
	public void update(List<Elevator> elevators);
	public void show();
}
