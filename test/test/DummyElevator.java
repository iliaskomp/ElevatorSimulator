package test;

import java.rmi.RemoteException;

import sqelevator.IElevator;

public class DummyElevator implements IElevator{
	private static final int POSITION = 10;
	private static final int SPEED = 10;
	private static final int WEIGHT = 10;
	private static final int DOOR_STATUS = 1;
	private static final int COMMITED_DIRECTION = 1;
	private static final int COMMITED_DIRECTION_SET = 2;

	private static final int FLOOR_HEIGHT = 6;
	private static final int TARGET_FLOOR = 11;
	private int direction, target;
	
	public DummyElevator() {
		direction = COMMITED_DIRECTION;
		target = 0;
	}
	
	@Override
	public int getCommittedDirection(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return direction;
	}

	@Override
	public int getElevatorAccel(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getElevatorButton(int elevatorNumber, int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getElevatorDoorStatus(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return DOOR_STATUS;
	}

	@Override
	public int getElevatorFloor(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getElevatorNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public int getElevatorPosition(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return POSITION;
	}

	@Override
	public int getElevatorSpeed(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return SPEED;
	}

	@Override
	public int getElevatorWeight(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return WEIGHT;
	}

	@Override
	public int getElevatorCapacity(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getFloorButtonDown(int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getFloorButtonUp(int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getFloorHeight() throws RemoteException {
		// TODO Auto-generated method stub
		return FLOOR_HEIGHT;
	}

	@Override
	public int getFloorNum() throws RemoteException {
		// TODO Auto-generated method stub
		return 14;
	}

	@Override
	public boolean getServicesFloors(int elevatorNumber, int floor) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTarget(int elevatorNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setCommittedDirection(int elevatorNumber, int direction) throws RemoteException {
		direction = COMMITED_DIRECTION_SET;
	}

	@Override
	public void setServicesFloors(int elevatorNumber, int floor, boolean service) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setTarget(int elevatorNumber, int target) throws RemoteException {
		this.target = target;		
	}

	@Override
	public long getClockTick() throws RemoteException {
		// TODO Auto-generated method stub
		return 0;
	}

}
