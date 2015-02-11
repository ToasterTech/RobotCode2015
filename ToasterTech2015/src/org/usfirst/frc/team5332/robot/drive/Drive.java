package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.RobotComponent;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveBehavior;
import org.usfirst.frc.team5332.robot.drive.system.DriveReal;
import org.usfirst.frc.team5332.robot.drive.system.DriveSystem;

public class Drive extends RobotComponent<DriveSystem,DriveLogic,DriveBehavior>{	
	public Drive(DriveSystem sys){
		system=sys; //Take drive arguments
		logic=new DriveLogic(system);
		behavior=new DriveBehavior(logic);
	}
}
