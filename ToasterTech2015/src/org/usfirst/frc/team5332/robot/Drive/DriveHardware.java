package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.HardwareSystem;
import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.TalonSRX;

public class DriveHardware extends HardwareSystem {
	private TalonSRX driveLeft1,driveLeft2;
	private TalonSRX driveRight1,driveRight2;
	public DriveHardware(){
		driveLeft1=IO.driveLeft1;
	}
	public void setMotors(double left,double right){
		driveLeft1.set(left);
		driveLeft2.set(left);
		driveRight1.set(right);
		driveRight2.set(right);
	}
}