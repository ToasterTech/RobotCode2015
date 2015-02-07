package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.SoftwareSystem;

public class DriveSoftware extends SoftwareSystem<DriveHardware>{
	public DriveSoftware(DriveHardware hws) {
		super(hws);
		// TODO Auto-generated constructor stub
	}

	public void driveMotors(double left,double right){
		this.hardware.setMotors(left, right);
	}
}
