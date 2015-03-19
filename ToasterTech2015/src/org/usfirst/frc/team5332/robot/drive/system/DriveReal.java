package org.usfirst.frc.team5332.robot.drive.system;

import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.TalonSRX;
/*
 * Implementations of the drive on hardware.
 * For some reason we calibrated the motors to drive forward with a negative value. This should be changed.
 */
public class DriveReal extends DriveSystem {
	private TalonSRX driveLeft1,driveLeft2;
	private TalonSRX driveRight1,driveRight2;
	private Encoder encoderLeft;
	private Encoder encoderRight;
	private double turnConstant = 1; /*NOTE: If the robot is turning the wrong direction in the 90* turn function, set this to -1*/
	private double turnLength = 1; /*Calibrate this value until you get a 90* or apx. 90* turn*/
	private double distancePerPulse = 4.125;
	////////////////////////////////////////
	/*Casey/Ben weren't sure on this, so this should be tweaked*/
	////////////////////////////////////////
	public DriveReal(){
		driveLeft1=IO.driveLeft1; //Set the variable to an actual Talon motor controller
		driveLeft2=IO.driveLeft2;
		driveRight1=IO.driveRight1;
		driveRight2=IO.driveRight2;
		encoderLeft=IO.encoderLeft;
		encoderRight=IO.encoderRight;
		encoderLeft.setDistancePerPulse(distancePerPulse);
		encoderRight.setDistancePerPulse(distancePerPulse);
	}
	public void setMotors(double left,double right){
		driveLeft1.set(left); //Set this motor to a left motor
		driveLeft2.set(left); //Set this motor to a left motor
		driveRight1.set(-right); //Set this motor to a right motor
		driveRight2.set(-right); //Set this motor to a right motor
	}
	public void zeroEncoders(){
		encoderLeft.reset(); //Reset encoder values
		encoderRight.reset();
	}
	public void driveLeftEncoder(double distance, double speed, boolean forward) {
		while(encoderLeft.getDistance()<distance){
			if(forward){
				driveLeft1.set(speed);
				driveLeft2.set(speed);
			}
			else{
				driveLeft1.set(-speed);
				driveLeft2.set(-speed);
			}
		}
	}
	public void driveRightEncoder(double distance, double speed, boolean forward) {
		while(encoderLeft.getDistance()<distance){
			if(forward){
				driveRight1.set(speed);
				driveRight2.set(speed);
			}
			else{
				driveRight1.set(-speed);
				driveRight2.set(-speed);
			}
		}
	}
	public void nintyDegreeTurn(boolean direction, double speed) {
		while(encoderLeft.getDistance()<turnLength)
			if(direction){
				driveLeft1.set(speed*turnConstant);
				driveLeft2.set(speed*turnConstant);
				driveRight1.set(-speed*turnConstant);
				driveRight2.set(-speed*turnConstant);
			}
			else{

				driveLeft1.set(-speed*turnConstant);
				driveLeft2.set(-speed*turnConstant);
				driveRight1.set(speed*turnConstant);
				driveRight2.set(speed*turnConstant);
			}
	}
}
