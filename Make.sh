#!/bin/bash

######################################################################
#
#  Make-like script for compiling Borwell RoomChallenge java project
#
#  Author: Martin Savidge
#
#  Syntax: ./Make.sh [clean]
#
######################################################################

project="RoomChallenge"

case "$1"
in
  -h )
    echo "make script for $project"
    echo " Syntax: ./Make.sh [clean]"
    echo           clean - remove all .class files
    ;;

  clean )
    # clean - remove all .class files
    find $project -name "*.class" -delete
    ;;

  "" )
    # default action - make - compile all .java files that are newer than their corresponding  .class file
    for file in $(find $project -name "*.java")
    do
      class_file="${file%.*}.class"
      if [ $file -nt $class_file ]
      then
        echo "javac $file ..."
        javac $file
      else
        echo "$(basename $file) - up to date"
      fi
    done
    ;;

  * )
    echo "Invalid argument - \"$1\""
    echo " Usage: ./Make.sh [clean]"
    exit 1
    ;;
esac
