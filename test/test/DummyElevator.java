package test;

import java.rmi.RemoteException;

import sqelevator.IElevator;

public class DummyElevator implements IElevator {

	private int direction, target;

	public DummyElevator() {
		direction = IElevator.ELEVATOR_DIRECTION_UNCOMMITTED;
		target = 0;
	}

	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		return direction;
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		return 0;
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException {
		return false;
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		return IElevator.ELEVATOR_DOORS_CLOSED;
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		return 0;
	}

	@Override
	public int getElevatorNum() throws RemoteException {
		return 1;
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		if(elevatorNumber>0) throw new RemoteException();
		return 0;
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		return 0;
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		return 0;
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		return 0;
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		return false;
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		return false;
	}

	@Override
	public int getFloorHeight() throws RemoteException {
		return 0;
	}

	@Override
	public int getFloorNum() throws RemoteException {
		return 10;
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		return true;
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		return target;
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		this.direction = direction;
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		if (target < 0)
			throw new RemoteException();
		this.target = target;
	}

	@Override
	public long getClockTick() throws RemoteException {
		return 1;
	}

}
