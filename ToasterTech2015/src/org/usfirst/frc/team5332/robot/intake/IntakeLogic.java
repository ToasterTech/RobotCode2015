package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.intake.systems.IntakeSystem;

public class IntakeLogic extends SystemLogic<IntakeSystem>{
	public IntakeLogic(IntakeSystem sys){
		this.system=sys;
	}
	public void open(){
		system.retract(IntakeSystem.Side.right);
		system.retract(IntakeSystem.Side.left);
	}
	public void clamp(){
		system.extend(IntakeSystem.Side.right);
		system.extend(IntakeSystem.Side.left);
	}
	public void intakeBothWheels(){
		system.intakeForward(IntakeSystem.Side.right, .6);
		system.intakeForward(IntakeSystem.Side.left, .6);
	}
	public void outakeBothWheels(){
		system.intakeBackward(IntakeSystem.Side.right, .6);
		system.intakeBackward(IntakeSystem.Side.left, .6);
	}
	public void stop(){
		system.runIntake(IntakeSystem.Side.right,0);
		system.runIntake(IntakeSystem.Side.left,0);
	}

}
