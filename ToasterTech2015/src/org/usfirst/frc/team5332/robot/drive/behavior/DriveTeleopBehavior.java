package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.control.Deadband;
import org.usfirst.frc.team5332.robot.control.InputScaling;
import org.usfirst.frc.team5332.robot.control.LinearScaling;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends DriveBehavior{
	protected Joystick 		joystick1;
	protected Joystick 		joystick2;
	protected double 		leftSpeed,	rightSpeed;
	protected LinearScaling leftLSM,	rightLSM;
	protected InputScaling 	letfIS,		rightIS;
	protected Deadband 		leftDB,		rightDB;
	public DriveTeleopBehavior(DriveLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
		
	}
	public void run(){
		tankDrive();
		this.logic.driveMotors(leftSpeed, rightSpeed);
	}
	protected void tankDrive(){
		leftSpeed=letfIS.get(joystick1.getY());
		rightSpeed=rightIS.get(joystick2.getY());
		leftSpeed=leftDB.get(leftSpeed);
		rightSpeed=rightDB.get(rightSpeed);
	}
}
