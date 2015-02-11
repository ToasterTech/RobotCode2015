package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.SystemLogic;

public class DriveLogic extends SystemLogic<DriveReal>{
	public DriveLogic(){
		super(null);
	}
	public DriveLogic(DriveReal hws) {
		super(hws);
		// TODO Auto-generated constructor stub
	} 
	public void driveMotors(double left,double right){
		this.hardware.setMotors(left, right); //Set motor arguments for function
	}
}
