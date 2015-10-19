# Solution to Borwell Software Challenge - Martin Savidge

## The Challenge
 
Write a program that takes as input the dimensions of a room and outputs the following:
 1. Area of the floor
 2. Amount of paint required to paint the walls
 3. Volume of the room

For further details see: http://www.borwell.com/software-challenge

## My Response

I have created a simple Java project comprising two .java files:
 - `RoomChallenge.java` - the main entry point and user input management
 - `Room.java` - a class to store details of a particular room and to calculate/format the user output

### Basic Build
These files reside in the directory `RoomChallenge` and can be compiled using:
 - `javac RoomChallenge/RoomChallenge.java RoomChallenge/Room.java`

### Basic run
The resultant program may be executed using:
 - `java RoomChallenge/RoomChallenge [ -h | --help ] | [ length width height ]`
 - `length width height` are the dimensions of the room (in metres) and, when not supplied as arguments, will be prompted for.

### Assumptions / Estimates
When writing the program I have made the following assumptions / estimates:
 - The room is cuboid.
 - The room has a door and window which do not require painting.
 - The dimensions of the door and window.
 - The paint coverage.
 - The result is for any one coat of paint.

### Automated Building and Testing - by bash scripts
Hereafter my response has been aimed at the creation of a command line utility for use on a Unix/Linux/cygwin based system.

My aim was to highlight my experience in producing Linux bash script based utilities.

I appreciate that there are, of course, much better ways to develop, make and test Java programs!

I have supplied:
 - a .tar file `RoomChallenge.tar`, to be downloaded and unpacked, containing my source and script files,
 - a `Make.sh` script to perform a make-like automation of the above `javac` command,
 - a `Test.sh` script to perform a sequence of test cases on the resultant program.

#### Installation

 - On the Unix platform `cd` to your desired directory
 - Copy in the `RoomChallenge.tar` file
 - Extract the contents using `tar xzvf RoomChallenge.tar`
 - Build the program using `./Make.sh`
 - Test the program using `./Test.sh`

#### Test script
This script builds and runs the program, checking the output for the correct responses. It tests:
 1. The area calculation,
 2. The paint requirement calculation,
 3. The volume calculation,
 4. Input of dimensions via user prompt,
 5. Response to `-h`,
 6. Handling of invalid (non-numeric) dimension input.

By default, the test sets up a room of dimensions `3.5 x 2.5 x 2.0 m`.

Alternative dimensions can be specified by using command line arguments (the expected output results are always calculated by the script)
 - Syntax: `./Test.sh [ -l length ] [ -w width ] [ -h height ]`

## Limitations

Had I had more time I would have created a GUI window to accept input and display the output.
This would not however have lent itself to being tested via a simple bash script!

Currently the program only operates in metres and litres. This could usefully be extended to handle dimensions in feet and inches, and to specify paint requirements in numbers of standard can sizes.

The input validation and test coverage is not yet exhaustive and does not consider extreme values - e.g.:
 - Negative dimensions,
 - Should the wall be too small to fit my standard sized door,
 - Invalid characters in every input argument and prompt response.

No provision has been made for installing the program as a system utility - e.g. providing a `make install`, placing it at a standard $PATH location, and/or creating a wrapper script to make invocation less cumbersome.

This program has been developed on a Windows / cygwin system - ideally I would have confirmed that it is compatible with a genuine Linux system before issuing it.

### Unit tests
Normally I would have included junit tests - these would be particularly suited to the methods within Room.java.

e.g.

    /**
      * Test of Room.getAreaOfFloor() method.
      */
     @Test
     public void testGetAreaOfFloor()
     {
       double length = 4.0;
       double width = 5.0;
       double height = 2.0;
       testRoom = new Room(length, width, height);
       assertEquals("getAreaOfFloor error", length * width, testRoom.getAreaOfFloor());
     }
