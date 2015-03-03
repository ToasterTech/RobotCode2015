# RobotCode2015
Code For The 2015 Robot

## Setup
In order to build code and view the source without errors in eclipse, the correct FRC software must be installed and the WPI libaries must be linked to the project. 

Follow these instructions to install the FRC software for eclipse: http://wpilib.screenstepslive.com/s/4485/m/13809/l/145002-installing-eclipse-c-java 

When the project is cloned eclipse may show an unbound classpath error. This occurs when eclipse can't find the WPI libary JAR files, and may occur even when the proper software is installed. To fix this add the missing JAR files to the class path:

 1. In eclipse right click on project and select properties.
 2. In the properties window select buildpath and open the libraries tab. 
 3. Use add external JARs to add the WPIlib JARs. These will be the networktables.jar and wpilib.jar and by default are found in the wpilib folder in the home directory(Windows: C:\Users\\[username]\wpilib; Linux: ~\wpilib). The JARs should be in java\current\lib of the wpilib folder. 

## Structure
