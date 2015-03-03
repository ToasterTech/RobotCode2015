package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.control.DoubleJoystick;
import org.usfirst.frc.team5332.robot.control.InputController;
import org.usfirst.frc.team5332.robot.control.OperatorGamepad;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;

import edu.wpi.first.wpilibj.Joystick;
/*
 * Teleop behavior for the lift.
 */
public class LiftTeleopBehavior extends LiftBehavior{
	private boolean transition;
	private Joystick joystick;
	private LiftLogic.LiftHeight target;
	public LiftTeleopBehavior(){
		super();
		target=LiftLogic.LiftHeight.Min;
		transition=false;
		joystick = IO.joystick2;
	}
	public LiftTeleopBehavior(LiftLogic sw) {
		super(sw);
		target=LiftLogic.LiftHeight.Min;
		joystick = IO.joystick2;
		transition=false;
	}
	private boolean lastLevelToggle1=false;
	private boolean lastLevelToggle2=false;
	/* 
	 * Runs the lift using these commands:
	 * 
	 * Joystick Bumper	 Left 	Goes up
	 * Joystick Bumper 	Right 	Goes down
	 * Joystick Trigger Right 	Goes down fast
	 * Joystick Button 	A	 	Goes down one level
	 * Joystick Button 	B		Goes Up one level
	 */
	public void run(){
		boolean levelToggle1 = joystick.getRawButton(2); //CHANGE ONE OF THESE
		boolean levelToggle2 = joystick.getRawButton(3);
		if(joystick.getRawButton(5)){
			System.out.println("GO UP");
			this.logic.unlatch();
			this.logic.goUp();
			transition=false;
		}else if(joystick.getRawButton(6)){
			this.logic.unlatch();
			System.out.println("GO DOWN");
			this.logic.goDown();
			transition=false;
		}
		else if(joystick.getRawAxis(3) > 0.5){
			this.logic.unlatch();
			System.out.println("GO DOWN MAX SPEED");
			this.logic.goDownMaxSpeed();
			transition=false;
		}/*
		//Ths is buggy, and throws null pointers and may be stopping the lift. 
		else if(levelToggle1 && !lastLevelToggle1){
			target=target.getNext();
			transition=true;
			logic.goToHeight(target);
		}
		else if(levelToggle2 && !lastLevelToggle2){
			target=target.getLast();
			transition=true;
			logic.goToHeight(target);
		}else if(transition){
			transition=!logic.goToHeight(target);
		}else if(!transition){
			System.out.println("DO NOTHING");
			logic.stop();
		}*/
		else{
			logic.latch();
			logic.stop();
		}
		lastLevelToggle1=true;
		lastLevelToggle2 = true;
	}
}
