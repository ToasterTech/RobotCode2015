package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.RobotSubsystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

public class Drive extends RobotSubsystem{
	private DriveHardware hardware;
	private DriveSoftware software;
	private DriveTeleopBehavior behavior;
	
	public Drive(DriveHardware arg_hardware,DriveSoftware arg_software,	DriveTeleopBehavior arg_behavior){
		hardware=arg_hardware;
		software=arg_software;
		behavior=arg_behavior;
	}

	@Override
	public void run() {
		behavior.run();
	}
	@Override
	public void setBehavior(SystemBehavior b) {
		// TODO Auto-generated method stub
		behavior=(DriveTeleopBehavior)b;
	}
	
}
