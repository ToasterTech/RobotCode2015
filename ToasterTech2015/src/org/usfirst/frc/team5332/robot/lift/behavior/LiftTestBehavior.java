package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;

public class LiftTestBehavior extends LiftBehavior{
	InputController test;
	public LiftTestBehavior(){
		super();
		test=DoubleJoystick.instance;

	}
	public LiftTestBehavior(LiftLogic sw){
		super(sw);
		test=DoubleJoystick.instance;
		
	}
	public void run(){
		System.out.println(logic.getLiftHeight());
		if(test.intakeDriveBackward()){
			System.out.println("LATCH");
			logic.unlatch();
			logic.goUp();
			//logic.latch();
		}else if(test.intakeDriveForward()){
			logic.goDown();
		}
		else{
			System.out.println("UNLATCH");
			logic.stop();
		}
	}
}
