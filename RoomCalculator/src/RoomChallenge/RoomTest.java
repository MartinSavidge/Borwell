package RoomChallenge;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for class Room.
 * 
 * Developed for Junit 4 framework.
 *
 * @author Martin Savidge
 * 
 */
public class RoomTest {

	private static final double EPSILON = 1e-10; // Expecting doubles to be
													// calculated almost exactly

	double length = 4.0;
	double width = 4.2;
	double height = 2.0;

	public Room testRoom;

	/**
	 * This method is invoked before each test is run to set up the test room.
	 */
	@Before
	// Informs JUnit that this method should be run before each test
	public void setUp() {
		testRoom = new Room(length, width, height);
	}

	/**
	 * This method is invoked after each test is run to perform tear down
	 * actions
	 */
	@After
	public void tearDown() {
		// No tear down needed for this test
	}

	/**
	 * Test of Room.getAreaOfFloor() method.
	 */
	@Test
	public void testGetAreaOfFloor() {
		double expected = length * width; // 16.8
		assertEquals("getAreaOfFloor error", expected, testRoom.getAreaOfFloor(), EPSILON);
	}

	/**
	 * Test of Room.getPaintedArea() method.
	 */
	@Test
	public void testGetPaintedArea() {
		// expected: area of both "length" walls + 60% of "width" wall with
		// window + other "width" wall - the door
		double expected = (2.0 * length * height) + (0.6 * width * height) + (1.0 * width * height) - 1.7; // 27.74
		assertEquals("getPaintedArea error", expected, testRoom.getPaintedArea(), EPSILON);
	}

	/**
	 * Test of Room.getAmountOfPaint() method.
	 */
	@Test
	public void testGetAmountOfPaint() {
		double paintedArea = testRoom.getPaintedArea();
		double expected = paintedArea / 10.0; // 2.774
		assertEquals("getAmountOfPaint error", expected, testRoom.getAmountOfPaint(), EPSILON);
	}

	/**
	 * Test of Room.getVolumeOfRoom() method.
	 */
	@Test
	public void testGetVolumeOfRoom() {
		double expected = length * width * height; // 33.6
		assertEquals("getVolumeOfRoom error", expected, testRoom.getVolumeOfRoom(), EPSILON);
	}

	/**
	 * Test of Room.getFormattedAreaOfFloor() method.
	 */
	@Test
	public void testGetFormattedAreaOfFloor() {
		String expected = "16.800";
		assertEquals("getFormattedAreaOfFloor error", expected, testRoom.getFormattedAreaOfFloor());
	}

	/**
	 * Test of Room.getFormattedAmountOfPaint() method.
	 */
	@Test
	public void testGetFormattedAmountOfPaint() {
		String expected = "2.8"; // 2.774 rounded to 1 decimal place
		assertEquals("getFormattedAmountOfPaint error", expected, testRoom.getFormattedAmountOfPaint());
	}

	/**
	 * Test of Room.getFormattedVolumeOfRoom() method.
	 */
	@Test
	public void testGetFormattedVolumeOfRoom() {
		String expected = "33.600";
		assertEquals("getFormattedVolumeOfRoom error", expected, testRoom.getFormattedVolumeOfRoom());
	}
}
