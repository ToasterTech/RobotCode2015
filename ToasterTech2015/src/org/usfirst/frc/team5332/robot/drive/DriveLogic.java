package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.drive.system.DriveSystem;

public class DriveLogic extends SystemLogic<DriveSystem>{
	public DriveLogic(){
		super(null);
	}
	public DriveLogic(DriveSystem hws) {
		super(hws);
		// TODO Auto-generated constructor stub
	} 
	public void driveMotors(double left,double right){
		this.system.setMotors(left, right); //Set motor arguments for function
	}
}
