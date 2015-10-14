package RoomChallenge;

import java.util.Scanner;

/**
 * RoomChallenge main class
 *
 * @author Martin Savidge
 *
 * Main class for Borwell RoomChallenge program.
 *
 * See http://www.borwell.com/software-challenge for requirments.
 *
 * Provides main entry point and user interface to specify the room to be processed
 *  and the sequencing of method calls to generate the required user output.
 */
public class RoomChallenge
{ 
  private static final String VERSION="1.0  MJS  12/10/2015";

  public static void main(String[] args)
  { 
    System.out.println("Borwell Room Challenge");
    System.out.println("");

    Scanner input = new Scanner(System.in);

    double length;  // length of room (in metres)
    double width;   // width of room (in metres)
    double height;  // height of room (in metres)

    try
    {
      if (args.length == 1) // One argument is not valid - treat as a help request (e.g. --help)
      {
         System.out.println("Program to calculate room details");
         System.out.println("Challenge: See Borwell Software Challenge (http://www.borwell.com/software-challenge)");
         System.out.println("Syntax:    RoomChallenge [ length width height ]");
         System.out.println("Output:    Room area, Estimated paint required, Volume");
         System.out.println("Version:   " + VERSION);
         System.exit(0);
      }

      if (args.length == 3) // Assume here that user has provided the room length, width, height as arguments
      {
        length = Double.parseDouble(args[0]);
        width  = Double.parseDouble(args[1]);
        height = Double.parseDouble(args[2]);
      }
      else  // Prompt user to input dimensions
      {

        System.out.println("Please enter values in metres\n");

        System.out.print("  room length: ");
        length = input.nextDouble();
        System.out.print("  room width:  ");
        width = input.nextDouble();
        System.out.print("  room height: ");
        height = input.nextDouble();

        System.out.println("");
      }
        
      Room room = new Room(length, width, height);

      // Output the results
      System.out.print("For a room ");
      room.printDimensionsOfRoom();

      room.printAreaOfFloor();
      room.printAmountOfPaint();
      room.printVolumeOfRoom();
    }
    catch(NumberFormatException nfe)  // Error in arguments (not valid numbers)
    {
       System.out.println("Invalid argument(s) - require length width height measurements (in metres) as decimal numbers");
       System.out.println(" e.g.  RoomChallenge 4.5 3.5 2   (room is 4.5m long, 3.5m wide, 2m high)");
    }
    catch(java.util.InputMismatchException ime)  // Error in responses to prompts (not valid numbers)
    {
       System.out.println("Invalid input - require measurement (in metres) as a decimal number");
    }
  }
}
