package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.control.Deadband;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.control.InputScaling;
import org.usfirst.frc.team5332.robot.control.LinearScaling;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends DriveBehavior{
	protected InputController controller;
	protected double 		leftSpeed,	rightSpeed;
	protected LinearScaling leftLSM,	rightLSM;
	protected InputScaling 	letfIS,		rightIS;
	protected Deadband 		leftDB,		rightDB;
	public DriveTeleopBehavior(){
		super();
	}
	public DriveTeleopBehavior(DriveLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO	
		controller=DoubleJoystick.get();

	}
	public void run(){
		leftSpeed=controller.driveLeft();
		rightSpeed=controller.driveRight();
		logic.driveMotors(leftSpeed, rightSpeed);
	}
}
