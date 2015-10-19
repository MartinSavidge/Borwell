package RoomChallenge;

/**
 * Room details class
 *
 * @author Martin Savidge
 *
 *         Supporting class for Borwell RoomChallenge program.
 *
 *         Provides details of the described room and the
 *         calculations/formatting required for generating the user output.
 *
 *         Assumptions: Room is cuboid Room has a single door of area 1.7m² Room
 *         has a window taking up 40% of one "width" sized wall Paint coverage
 *         is 10.0m³ per litre of paint
 */
public class Room {
	private final double length; // From window to rear wall (metres)
	private final double width; // Of wall containing the window (metres)
	private final double height; // From floor to ceiling (metres)

	/***
	 * Default constructor
	 */
	public Room() {
		this.length = 0;
		this.width = 0;
		this.height = 0;
	}

	/**
	 * Constructor - Requires the dimensions of the room (in metres) as
	 * arguments.
	 *
	 * @param length
	 *            length of the room (from window to rear wall)
	 * @param width
	 *            width of the room (of wall containing the window)
	 * @param height
	 *            height of the room (from floor to ceiling)
	 */
	public Room(double length, double width, double height) {
		this.length = length;
		this.width = width;
		this.height = height;
	}

	/**
	 * Calculate the area of the floor.
	 *
	 * For a rectangular floor - this is length * width
	 *
	 * @return area of the floor in square metres
	 */
	public double getAreaOfFloor() {
		return length * width;
	}

	/**
	 * Calculate the volume of the room.
	 *
	 * For a cuboid room - this is floor area * height
	 *
	 * @return volume of the room in cubic metres
	 */
	public double getVolumeOfRoom() {
		return getAreaOfFloor() * height;
	}

	/**
	 * Calculate the area of wall that will require a coat of paint
	 *
	 * This is the height * perimeter, perimeter being two "width" and two
	 * "length" walls
	 *
	 * Assuming that there is no need to paint the door and window, area to be
	 * painted is reduced by one door (1.7m²) and window(s) (40% of the area of
	 * one "width" wall)
	 * 
	 * @return total area to be painted
	 */
	public double getPaintedArea() {
		return (2 * (width * height) // front & back walls walls
				+ 2 * (length * height) // side walls
				- 1.7 // door
				- 0.4 * (width * height)); // window(s)
	}

	/**
	 * Calculate the amount of paint needed to paint the room (one coat).
	 *
	 * Coverage is estimated at 10 square metres per litre of paint (taken from
	 * B&Q website - http://www.diy.com/help-advice/wall-painting-calculator)
	 *
	 * @return amount of paint in litres
	 */
	public double getAmountOfPaint() {
		return getPaintedArea() / 10.0;
	}

	/**
	 * Get floor area of room formatted as a string
	 *
	 * return area of floor of room (in square metres) as a string
	 */
	public String getFormattedAreaOfFloor() {
		return String.format("%.3f", getAreaOfFloor());
	}

	/**
	 * Get amount of paint required formatted as a string
	 *
	 * return number of litres of paint required for room (in litres) as a
	 * string
	 */
	public String getFormattedAmountOfPaint() {
		return String.format("%.1f", getAmountOfPaint());
	}

	/**
	 * Get volume of room formatted as a string
	 *
	 * return volume of room (in cubic metres) as a string
	 */
	public String getFormattedVolumeOfRoom() {
		return String.format("%.3f", getVolumeOfRoom());
	}

}
