#!/bin/bash
# this shell will run the java application every 5secs

JAVACLASS=RestApp.java
APP=RestApp

javac "${JAVACLASS}"
echo 'done with compilation..'

while true  
do  
  date; java "${APP}"
  sleep 5  
done;
