package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;

import edu.wpi.first.wpilibj.Joystick;

public class LiftTeleopBehavior extends LiftBehavior{
	protected InputController controller;
	public LiftTeleopBehavior(){
		super();
		controller=DoubleJoystick.instance;
	}
	public LiftTeleopBehavior(LiftLogic sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		//IO		
		controller=DoubleJoystick.instance;

	}
	public void run(){
		if(controller.liftNextLevel()){
			System.out.println("GO UP");
			this.logic.unlatch();
			this.logic.goUp();
		}
		else if(controller.liftLastLevel()){
			this.logic.unlatch();
			System.out.println("GO DOWN");
			this.logic.goDown();
		}else{
			System.out.println("DO NOTHING");
			logic.stop();
		}
	}
}
