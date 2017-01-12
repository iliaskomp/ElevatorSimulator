package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FloorTest {
	private Floor floor;
	
	@Before
	public void setUp() {
		floor = new Floor(3);
	}
	
	@Test
	public void testFloorNumber() {
		assertEquals(3, floor.getFloor());
	}
	
	@Test
	public void testSetFloorNumber() {
		floor.setFloor(5);
		assertEquals(5, floor.getFloor());
	}
	
	@Test
	public void testUpCall() {
		floor.setUpCall(true);
		assertTrue(floor.isUpCall());
	}

	@Test
	public void testDownCall() {
		floor.setDownCall(true);
		assertTrue(floor.isDownCall());
	}
	
	@Test
	public void testStopRequest() {
		floor.setStopRequest(true);
		assertTrue(floor.isStopRequest());
	}
}
