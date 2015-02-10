package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.RobotSubsystem;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveBehavior;

public class Drive extends RobotSubsystem<DriveBehavior>{
	private DriveReal hardware; //Assign variables to the different classes
	private DriveLogic logic;
	private DriveBehavior behavior;
	
	public Drive(DriveReal arg_hardware){
		hardware=arg_hardware; //Take drive arguments
		logic=new DriveLogic(hardware);
		behavior=new DriveBehavior(logic);
	}

	@Override
	public void run() {
		behavior.run();
	}
	public void setBehavior(DriveBehavior b) {
		// TODO Auto-generated method stub
		behavior=b;
	}	
}
