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
- `Room.java` - a class to store details of a particular room and calculate/format the user output

These reside in the directory `RoomChallenge` and can be compiled using
- `javac RoomChallenge/RoomChallenge.java RoomChallenge/Room.java`

Thereafter my response has been aimed at a Unix/Linux/cygwin system.

I have supplied:
- a .tar file to be downloaded and unpacked containing all of my files
- a Make.sh script to perform a make-like automation of the above javac command
- a Test.sh script to perform test cases on the resultant program

My aim was to highlight my experience in producing Linux bash script utilities.

I appreciate that there are much better ways to develop, make and test Java programs!

## Installation

+ On the Unix platform cd to your desired directory
+ Copy in the RoomChallenge.tar file
+ Extract the .tar using `tar xzvf RoomChallenge.tar`
+ Build the program using `./Make.sh`
+ Test the program using `./Test.sh`

## Limitations

Had I had more time I would have provided a GUI window to accept input and display output.
This would not however have lent itself to being tested via a simple bash script!

Currently the input validation and test coverage is not exhaustive and does not consider extreme values
 e.g.:
 - invalid characters in every input argument and prompt response,
 - when the wall is too small to fit my standard sized door.
