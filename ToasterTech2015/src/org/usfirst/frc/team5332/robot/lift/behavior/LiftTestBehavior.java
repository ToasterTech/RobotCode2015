package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.control.OperatorGamepad;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;

public class LiftTestBehavior extends LiftBehavior{
	InputController test;
	public LiftTestBehavior(){
		super();
		test=OperatorGamepad.instance;

	}
	public LiftTestBehavior(LiftLogic sw){
		super(sw);
		test=DoubleJoystick.instance;
		
	}
	public void run(){
		//System.out.println(logic.status());
		System.out.println("0 "+IO.joystick1.getRawButton(0));
		System.out.println("1 "+IO.joystick1.getRawButton(1));
		System.out.println("2 "+IO.joystick1.getRawButton(2));

		System.out.println("3 "+IO.joystick1.getRawButton(3));
		System.out.println("4 "+IO.joystick1.getRawButton(4));
		System.out.println("5 "+IO.joystick1.getRawButton(5));
		System.out.println("6 "+IO.joystick1.getRawButton(6));
		System.out.println("7 "+IO.joystick1.getRawButton(7));

		if(IO.joystick1.getRawButton(6)){
			System.out.println("GoUp");
			logic.unlatch();
			logic.goUp();
		}else if(IO.joystick1.getRawButton(5)){
			System.out.println("GoDown");
			logic.unlatch();
			logic.goDown();
		}else{
			System.out.println("Stop");
			logic.latch();
			logic.stop();
		}
	}
}
