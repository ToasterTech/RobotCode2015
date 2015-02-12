package org.usfirst.frc.team5332.robot.drive.system;

import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.TalonSRX;

public class DriveReal extends DriveSystem {
	private TalonSRX driveLeft1,driveLeft2;
	private TalonSRX driveRight1,driveRight2;
	public DriveReal(){
		driveLeft1=IO.driveLeft1; //Set the variable to an actual Talon motor controller
		driveLeft2=IO.driveLeft2;
		driveRight1=IO.driveRight1;
		driveRight2=IO.driveRight2;
	}
	public void setMotors(double left,double right){
		driveLeft1.set(left); //Set this motor to a left motor
		driveLeft2.set(left); //Set this motor to a left motor
		driveRight1.set(-right); //Set this motor to a right motor
		driveRight2.set(-right); //Set this motor to a right motor
	}
}
