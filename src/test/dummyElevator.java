package test;

import java.rmi.RemoteException;

import sqelevator.IElevator;

public class dummyElevator implements IElevator {

	// Number of floors in the building
	private static final int FLOORS = 17;
	// Number of elevators in the building
	private static final int ELEVATORS = 1;
	// Maximum speed of the elevator
	private static final int MAX_SPEED = 2;
	// Floor height in the building
	private static final int FLOOR_HEIGHT = 6;
	// Acceleration of the elevator
	private static final int ACCEL = 1;
	// Ticks per second of the simulation (max 1000)
	private static final int TICK = 1;
	// The smallest amount of distance that may simulated in a TICK
	private static final float EPSILON_DISTANCE = (float) ((ACCEL / 2.0f) * Math.pow(1000 / TICK, 2));
	private static final float EPSILON = 0.001f;
	private int acceleration, target;
	private float position, speed;
	private long time;

	public dummyElevator() {
		acceleration = target = 0;
		position = speed = 0;
		time = System.currentTimeMillis();
	}

	private void checkElevatorNumber(int elevatorNumber) throws RemoteException {
		if (elevatorNumber >= ELEVATORS)
			throw new RemoteException("Invalid elevator number.");
	}

	private void checkFloor(int floor) throws RemoteException {
		if (floor >= FLOORS)
			throw new RemoteException("Invalid floor number.");
	}

	@SuppressWarnings("unused")
	private void simulate() throws RemoteException {
		if (TICK > 1000 || TICK < 1)
			throw new RemoteException("Invalid tick rate.");
		long newTime = System.currentTimeMillis();
		float targetHeight = target * FLOOR_HEIGHT;
		double simulatedTime = 1000 / (double) TICK;
		if (targetHeight - position > EPSILON_DISTANCE) {
			for (double i = time; i < newTime; i += simulatedTime) {
				int direction = targetHeight > position ? 1 : -1;
				float distance = position - targetHeight;
				// Check for modifing the accelartion
				if (acceleration == 0 || Math.abs(acceleration) == acceleration * direction) {
					float distanceToBreak = (float) Math.pow(speed, 2) / (2 * ACCEL);
					if (distanceToBreak < distance) {
						acceleration = ACCEL * direction * -1;
					} else if (Math.abs(Math.abs(speed) - MAX_SPEED) > EPSILON) {
						acceleration = ACCEL * direction;
					}
				}
				position += speed * simulatedTime;
				position += (acceleration / 2.0f) * Math.pow(simulatedTime, 2);
				speed += acceleration * simulatedTime;

				if (Math.abs(Math.abs(speed) - MAX_SPEED) < EPSILON) {
					speed = MAX_SPEED * direction;
					acceleration = 0;
				}
			}
		} else {
			position = target * FLOOR_HEIGHT;
			speed = 0;
			acceleration = 0;
		}
		time = newTime;
	}

	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		return ELEVATOR_DIRECTION_UNCOMMITTED;
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		simulate();
		return acceleration;
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		checkFloor(floor);
		return false;
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		return ELEVATOR_DOORS_CLOSED;
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		simulate();
		return Math.round(position / (float) FLOOR_HEIGHT);
	}

	@Override
	public int getElevatorNum() throws RemoteException {
		return ELEVATORS;
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		simulate();
		return Math.round(position);
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		simulate();
		return Math.round(speed);
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		return 0;
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		return 0;
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		checkFloor(floor);
		return false;
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		checkFloor(floor);
		return false;
	}

	@Override
	public int getFloorHeight() throws RemoteException {
		return FLOOR_HEIGHT;
	}

	@Override
	public int getFloorNum() throws RemoteException {
		return FLOORS;
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		checkFloor(floor);
		return true;
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		return target;
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		throw new RemoteException("Not implemented.");
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		throw new RemoteException("Not implemented.");
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		checkElevatorNumber(elevatorNumber);
		checkFloor(target);
		this.target = target;
	}

	@Override
	public long getClockTick() throws RemoteException {
		return TICK;
	}

}
