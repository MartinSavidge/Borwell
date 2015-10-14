package RoomChallenge;

/**
 * Room details class
 *
 * @author Martin Savidge
 *
 * Supporting class for Borwell RoomChallenge program.
 *
 * Provides details of the described room
 *  and the calculations/formatting required for generating the user output.
 *
 * Assumptions:
 *  Room is cuboid
 *  Room has a single door of area 1.7 square metres
 *  Room has a window taking up 40% of one "width" sized wall
 *  Paint coverage is 10 square metres per litre of paint
 */
public class Room
{
  private final double length;  // From window to rear wall (metres)
  private final double width;   // Of wall containing the window (metres)
  private final double height;  // From floor to ceiling (metres)

  /**
   * Constructor - Requires the dimensions of the room (in metres) as arguments.
   *
   * @param length length of the room (from window to rear wall)
   * @param width  width of the room  (of wall containing the window)
   * @param height height of the room (from floor to ceiling)
   */
  public Room(double length, double width, double height)
  {
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
  public double getAreaOfFloor()
  {
    return length * width;
  }


  /**
   * Calculate the volume of the room.
   *
   * For a cuboid room - this is floor area * height
   *
   * @return volume of the room in cubic metres
   */
  public double getVolumeOfRoom()
  {
    return getAreaOfFloor() * height;
  }


  /**
  * Calculate the area of wall that will require a coat of paint
  *
  * This is the height * perimeter,
  *  perimeter being two "width" and two "length" walls
  *
  * Assuming that there is no need to paint the door and window,
  *  area to be painted is reduced by
  *   one door (1.7 square metres)
  *   window(s) (40% of the area of one "width" wall)
  * @return total area to be painted
  */
  public double getPaintedArea()
  {
    return ( 2 * (width * height)       // side walls
           + 2 * (length * height)      // front & back walls
           - 1.7                        // door
           - 0.4 * (width * height) );  // window(s)
  }


  /**
   * Calculate the amount of paint needed to paint the room (one coat).
   *
   * Coverage is estimated at 10 square metres per litre of paint
   *  (taken from B&Q website - http://www.diy.com/help-advice/wall-painting-calculator)
   *
   * @return amount of paint in litres
   */
  public double getAmountOfPaint()
  {
    return getPaintedArea() / 10.0;
  }


  /**
  * Print dimensions of room
  *
  * Output dimensions (length x width x height) of the room in metres
  */
  public void printDimensionsOfRoom()
  {
    System.out.printf("%.3f x %.3f x %.3f m\n", length, width, height);
  }


  /**
  * Print area of floor
  *
  * Output area of floor in square metres
  */
  public void printAreaOfFloor()
  {
    System.out.printf("The floor area is %.3f square metres\n", getAreaOfFloor());
  }


  /**
  * Print amount of paint required
  *
  * Output number of litres of paint required for room
  */
  public void printAmountOfPaint()
  {
    System.out.printf("You will require approximatly %.1f litres of paint per coat.\n", getAmountOfPaint());
  }


  /**
  * Print volume of room
  *
  * Output volume of room in cubic metres
  */
  public void printVolumeOfRoom()
  {
    System.out.printf("The room volume is %.3f cubic metres.\n", getVolumeOfRoom());
  }
}
