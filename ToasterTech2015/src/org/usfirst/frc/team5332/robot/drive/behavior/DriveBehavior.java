package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;

public class DriveBehavior extends SystemBehavior<DriveLogic>{
	protected double leftSpeed,rightSpeed;
	public DriveBehavior(){
		super();
	}
	public DriveBehavior(DriveLogic sw) {
		super(sw);
	}
	public void run(){
	}
}
