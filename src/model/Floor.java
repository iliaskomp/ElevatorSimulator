package model;

// TODO: Auto-generated Javadoc
/**
 * The Class Floor.
 * Model of Floor.
 * @author Ilias Komp
 */
public class Floor {
	
	/** The up call. */
	private boolean upCall;
	
	/** The down call. */
	private boolean downCall;
	
	/** The stop request. */
	private boolean stopRequest;
	
	/** The floor. */
	private int floor;
	
	/**
	 * Instantiates a new floor.
	 *
	 * @param floor (number of floor)
	 */
	public Floor(int floor) {
		this.setFloor(floor);
	}

	/**
	 * Checks if is up call.
	 *
	 * @return true, if is up call
	 */
	public boolean isUpCall() {
		return upCall;
	}

	/**
	 * Sets the up call.
	 *
	 * @param upCall the new up call
	 */
	public void setUpCall(boolean upCall) {
		this.upCall = upCall;
	}

	/**
	 * Checks if is down call.
	 *
	 * @return true, if is down call
	 */
	public boolean isDownCall() {
		return downCall;
	}

	/**
	 * Sets the down call.
	 *
	 * @param downCall the new down call
	 */
	public void setDownCall(boolean downCall) {
		this.downCall = downCall;
	}

	/**
	 * Checks if is stop request.
	 *
	 * @return true, if is stop request
	 */
	public boolean isStopRequest() {
		return stopRequest;
	}

	/**
	 * Sets the stop request.
	 *
	 * @param stopRequest the new stop request
	 */
	public void setStopRequest(boolean stopRequest) {
		this.stopRequest = stopRequest;
	}

	/**
	 * Gets the floor.
	 *
	 * @return the floor
	 */
	public int getFloor() {
		return floor;
	}

	/**
	 * Sets the floor.
	 *
	 * @param floor the new floor
	 */
	public void setFloor(int floor) {
		this.floor = floor;
	}
	
	
}
