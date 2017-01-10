package model;

public class Floor {
	private boolean upCall;
	private boolean downCall;
	private boolean stopRequest;
	
	public Floor(boolean upCall, boolean downCall, boolean stopRequest) {
		super();
		this.upCall = upCall;
		this.downCall = downCall;
		this.stopRequest = stopRequest;
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
	
	
}
