package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SoftwareSystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

import edu.wpi.first.wpilibj.Joystick;

public abstract class DriveTeleopBehavior extends SystemBehavior<DriveSoftware>{
	protected Joystick joystick1;
	protected Joystick joystick2;
	protected double leftSpeed,rightSpeed;
	protected LowSpeedMode leftLSM,rightLSM;
	protected InputScaling letfIS,rightIS;
	public DriveTeleopBehavior(DriveSoftware sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
	}	
	protected void tankDrive(){
		leftSpeed=letfIS.get(joystick1.getY());
		rightSpeed=rightIS.get(joystick2.getY());
	}
	protected void lowSpeedMode(){
		leftSpeed=leftLSM.get(leftSpeed);
		rightSpeed=rightLSM.get(rightSpeed);
	}
}
