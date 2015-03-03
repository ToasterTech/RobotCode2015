package org.usfirst.frc.team5332.robot.intake.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.intake.IntakeLogic;

import edu.wpi.first.wpilibj.Joystick;
/* 
 * Intake behavior for teleop mode.
 */
public class IntakeTeleopBehavior extends IntakeBehavior {
	private Joystick joystick = IO.joystick1;
	public IntakeTeleopBehavior(){
		super();
	}
	public IntakeTeleopBehavior(IntakeLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO
	}
	public void run(){
		if(joystick.getRawAxis(2)>.3){
			logic.clamp();
		}else{
			logic.open();
		}
		if(joystick.getRawButton(6)){
			logic.intakeBothWheels();
		}else if(joystick.getRawButton(5)){
			logic.outakeBothWheels();
		}else{
			logic.stop();
		}
	}
}
