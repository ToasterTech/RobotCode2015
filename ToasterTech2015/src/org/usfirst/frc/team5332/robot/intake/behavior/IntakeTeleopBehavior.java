package org.usfirst.frc.team5332.robot.intake.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.intake.IntakeLogic;

import edu.wpi.first.wpilibj.Joystick;

public class IntakeTeleopBehavior extends IntakeBehavior {
	protected Joystick 		joystick1;
	protected Joystick 		joystick2;
	public IntakeTeleopBehavior(){
		super();
	}
	public IntakeTeleopBehavior(IntakeLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
		
	}
	public void run(){
		if(joystick1.getRawButton(0)){
			logic.clamp();
		}else{
			logic.open();
		}
		if(joystick2.getRawButton(0)){
			logic.intakeBothWheels();
		}else if(joystick2.getRawButton(1)){
			logic.outakeBothWheels();
		}else{
			logic.stop();
		}
	}
}
