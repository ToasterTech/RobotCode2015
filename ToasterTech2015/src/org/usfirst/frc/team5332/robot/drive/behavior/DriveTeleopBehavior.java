package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.control.Deadband;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.Gamepad;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.control.InputScaling;
import org.usfirst.frc.team5332.robot.control.InputScalingFactor;
import org.usfirst.frc.team5332.robot.control.LinearScaling;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;

import edu.wpi.first.wpilibj.Joystick;
/*
 * Teleop behavior for drive. Maps the joystick axes to tank drive with a x^2 scaling factor. 
 * This code is slightly hacked together and was rewritten at the competition. Needs improvement 
 */
public class DriveTeleopBehavior extends DriveBehavior{
	protected InputController controller;
	protected double	leftFinalValue,rightFinalValue;
	protected double 			leftSpeed,	rightSpeed;
	protected InputScalingFactor scaling;
	protected Joystick 		joystick;
	public DriveTeleopBehavior(){
		super();
		joystick=IO.joystick1;
		scaling=new InputScalingFactor(1);
	}
	public DriveTeleopBehavior(DriveLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		controller=DoubleJoystick.instance;

	}
	public void run(){
		leftSpeed=joystick.getRawAxis(1);
		rightSpeed=joystick.getRawAxis(5);
		double leftSign=(leftSpeed>0.00)?1.0:-1.0;
		double rightSign=(rightSpeed>0.0)?1.0:-1.0;
		//Speed acceleration rate control code
		//Limits the rate of acceleration per tick
		leftFinalValue=leftSign*leftSpeed*leftSpeed;
		rightFinalValue=rightSign*rightSpeed*rightSpeed;
		logic.driveMotors(leftFinalValue, rightFinalValue);
	}
}
