package model;

import java.util.List;

public class Elevator {
	private int position;
	private int speed;
	private int weight;
	private enum Direction {UP, DOWN};
	private boolean doorStatus;
	private int nearestFloor;
	private List<Floor> floors;
	
}
