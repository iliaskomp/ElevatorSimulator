package model;

public class Floor {
	private boolean upCall;
	private boolean downCall;
	private boolean stopRequest;
	private int floor;
	
	public Floor(int floor) {
		this.setFloor(floor);
	}

	public boolean isUpCall() {
		return upCall;
	}

	public void setUpCall(boolean upCall) {
		this.upCall = upCall;
	}

	public boolean isDownCall() {
		return downCall;
	}

	public void setDownCall(boolean downCall) {
		this.downCall = downCall;
	}

	public boolean isStopRequest() {
		return stopRequest;
	}

	public void setStopRequest(boolean stopRequest) {
		this.stopRequest = stopRequest;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
}
