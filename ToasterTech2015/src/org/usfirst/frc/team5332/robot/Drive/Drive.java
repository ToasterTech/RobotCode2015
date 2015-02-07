package org.usfirst.frc.team5332.robot.Drive;

public class Drive {
	private DriveHardware hardware;
	private DriveSoftware software;
	private DriveTeleopBehavior behavior;
	
	public Drive(DriveHardware arg_hardware,DriveSoftware arg_software,	DriveTeleopBehavior arg_behavior){
		hardware=arg_hardware;
		software=arg_software;
		behavior=arg_behavior;
	}
	
}
