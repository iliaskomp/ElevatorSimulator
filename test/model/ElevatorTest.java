package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import sqelevator.IElevator;

public class ElevatorTest {
	private Elevator elevator;

	@Before
	public void setUp() {
		elevator = new Elevator(0);
	}

	@Test
	public void testElevatorNumber() {
		assertEquals(0, elevator.getElevatorNumber());
	}

	@Test
	public void testSetElevatorNumber() {
		elevator.setElevatorNumber(1);
		assertEquals(1, elevator.getElevatorNumber());
	}

	@Test
	public void testDoorStatus() {
		elevator.setDoorStatus(0);
		assertEquals(0, elevator.getDoorStatus());
	}

	@Test
	public void testPosition() {
		elevator.setPosition(10);
		assertEquals(10, elevator.getPosition());
	}

	@Test
	public void testSpeed() {
		elevator.setSpeed(10);
		assertEquals(10, elevator.getSpeed());
	}

	@Test
	public void testMode() {
		elevator.setManualMode(true);
		assertTrue(elevator.isManualMode());
	}

	@Test
	public void testNearestFloor() {
		elevator.setNearestFloor(10);
		assertEquals(10, elevator.getNearestFloor());
	}

	@Test
	public void testWeight() {
		elevator.setWeight(10);
		assertEquals(10, elevator.getWeight());
	}

	@Test
	public void testName() {
		elevator.setName("Elevator 0");
		assertEquals("Elevator 0", elevator.getName());
	}

	@Test
	public void testCommitedDirection() {
		elevator.setCommitedDirection(IElevator.ELEVATOR_DIRECTION_DOWN);
		assertEquals(IElevator.ELEVATOR_DIRECTION_DOWN, elevator.getCommitedDirection());
	}

}
