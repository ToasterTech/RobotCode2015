package org.usfirst.frc.team5332.robot.intake.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.intake.IntakeLogic;

import edu.wpi.first.wpilibj.Joystick;

public class IntakeTeleopBehavior extends IntakeBehavior {
	InputController controller;
	public IntakeTeleopBehavior(){
		super();
	}
	public IntakeTeleopBehavior(IntakeLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
		controller=DoubleJoystick.get();
		
	}
	public void run(){
		if(controller.intakeClamp()){
			logic.clamp();
		}else{
			logic.open();
		}
		if(controller.intakeDriveForward()){
			logic.intakeBothWheels();
		}else if(controller.intakeDriveBackward()){
			logic.outakeBothWheels();
		}else{
			logic.stop();
		}
	}
}
