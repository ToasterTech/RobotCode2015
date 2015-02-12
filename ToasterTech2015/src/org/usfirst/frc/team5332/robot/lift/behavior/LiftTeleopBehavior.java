package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;

import edu.wpi.first.wpilibj.Joystick;

public class LiftTeleopBehavior extends LiftBehavior{
	protected Joystick 		joystick1;
	protected Joystick 		joystick2;
	public LiftTeleopBehavior(){
		super();
	}
	public LiftTeleopBehavior(LiftLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
		
	}
	public void run(){
	}
}
