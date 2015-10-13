#!/bin/bash

############################################################################
#
#  Test script for the Borwell RoomChallenge java project
#
#  Author: Martin Savidge
#
#  Syntax: ./Test.sh [ -l length ] [ -w width ] [ -h height ]
#
#              -l/w/h allow overriding of the default room size
#                                          of 3.5 x 2.5 x 2.0 m
#
############################################################################

# The project name
project="RoomChallenge"

# The command to run the program
exe_cmnd="java $project/$project"

# Failure count
failures=0

# Test room dimensions - initialised to default values
length=3.5
width=2.5
height=2.0


############################################################################
#
# Function to perform a single test
#
# Arguments: "command" "arguments" "input" "expected text" "expected value"
#             "arguments" / "input" to be empty strings when not being used
#             "expected value" to be unset or empty if no value is expected
#
# Return: Pass / Fail (as exit status of 0 / 1)
#
############################################################################
function Test
{
  exe_cmnd="$1"  # The command to invoke the Java utility 
  args="$2"      # Any command line arguments
  input="$3"     # All responses to user prompts
  text="$4"      # Required key text in output
  expected="$5"  # Expected value from calculation (treated as a string)

  fail=0         # Fail flag

  # Perform command - providing specified arguments / input
  output="$(echo "$input" | $exe_cmnd $args)"

  # Check output for required key text
  if ! echo "$output" | grep "$text"
  then
    echo "Failed - did not report $text" >&2
    ((fail++))
  elif [ -n "$expected" ]
  then
    # Check output for correctly calculated value
    actual=$(echo "$output" | grep "$text" | cut -f5 -d " ")
    if [ "$actual" != "$expected" ]
    then
       echo "Failed - $text : Expected $expected - Actually $actual" >&2
      ((fail++))
    fi
  fi

  # Report a pass
  [ "$fail" -eq 0 ] && echo "Passed"

  # Return result
  return $fail
}  # end Test


##################################################
#
# Enable user specification of room dimensions from command line arguments
#
##################################################
while [[ $# > 0 ]]
do
key="$1"

case $key
in
  -l|--length)
    length="$2"
    shift # past argument
    ;;
  -w|--width)
    width="$2"
    shift # past argument
    ;;
  -h|--height)
    height="$2"
    shift # past argument
    ;;
  *)
    # unknown option
    echo "Usage ./Test.sh [ -l length ] [ -w width ] [ -h height ]"
    echo "      length width height - dimensions of room in metres"
    exit 1
    ;;
esac
shift # past argument or value
done


##################################################
#
# First make the project
#
##################################################
echo ""
echo "Performing Make.sh ..."
./Make.sh


##################################################
#
# check the area calculation
#
##################################################
echo ""
echo "Checking floor area calculation for $length x $width room ..."

expected=$(printf "%0.3f\n" $(echo "scale=4; $length * $width" | bc))

if ! Test "$exe_cmnd" "$length $width $height" "" "floor area"  "$expected"
then
  ((failures++))
fi


##################################################
#
# check the paint requirement calculation
#
##################################################
echo ""
echo "Checking paint requirement calculation for $length x $width x $height room ..."

# Area to paint is the four walls less 40% of one "width" wall (the window) and 0.7m^2 (the door)
# Amount of paint required is based on covering 10.0m^2 per litre of paint
expected=$(printf "%0.1f\n" $(echo "scale=2; ( 1.6*$width*$height + 2*$length*$height - 0.7) / 10" | bc))

if ! Test "$exe_cmnd" "$length $width $height" "" "require .* paint"  "$expected"
then
  ((failures++))
fi


##################################################
#
# check the room volume calculation
#
##################################################
echo ""
echo "Checking room volume calculation for $length x $width x $height room ..."

expected=$(printf "%0.3f\n" $(echo "scale=4; $length * $width * $height" | bc))

if ! Test "$exe_cmnd" "$length $width $height" "" "room volume"  "$expected"
then
  ((failures++))
fi


##################################################
#
# check input from user prompt
#
##################################################
echo ""
echo "Checking room volume for prompted user input ..."

input="$length
$width
$height
"

expected=$(printf "%0.3f\n" $(echo "scale=4; $length * $width * $height" | bc))

if ! Test "$exe_cmnd" "$length $width $height" "$input" "room volume"  "$expected"
then
  ((failures++))
fi


##################################################
#
# check the -h help output
#
##################################################
echo ""
echo "Checking the -h help output ..."

# Run $exe_cmnd -h and expect to get output including "Syntax:"

if ! Test "$exe_cmnd" "-h" "" "Syntax:"  ""
then
  ((failures++))
fi


##################################################
#
# Check handling of invalid input
#
##################################################
echo ""
echo "Checking handling of invalid width argument ..."

if ! Test "$exe_cmnd" "$length invalid $height" "" "Invalid argument"  ""
then
  ((failures++))
fi


##################################################
#
# Display test sequence summary
#
##################################################
echo ""
if [ $failures -eq 0 ]
then
  echo "All tests passed"
  exit 0
else
  echo "Failures: $failures" >&2
  exit 1
fi

