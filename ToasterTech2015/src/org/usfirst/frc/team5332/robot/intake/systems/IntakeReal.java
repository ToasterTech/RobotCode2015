package org.usfirst.frc.team5332.robot.intake.systems;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.RobotSystem;
import org.usfirst.frc.team5332.robot.intake.systems.IntakeSystem.Side;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
/*
 * Intake system for running on the robot. 
 */
public class IntakeReal extends IntakeSystem{
	private TalonSRX leftMotor,rightMotor;
	private Solenoid leftPiston,rightPiston;
	private final double forwardConst=-1;
	public IntakeReal(){
		super();
		leftMotor=IO.intakeLeft;
		rightMotor=IO.intakeRight;
		leftPiston=IO.intakeLeftPiston;
		rightPiston=IO.intakeRightPiston;
		
	}
	public void extend(Side side){
		switch(side){
		case left:
			leftPiston.set(true);
		break;
		case right:
			rightPiston.set(true);
		break;
		}
	}
	public void retract(Side side){
		switch(side){
		case left:
			leftPiston.set(false);
		break;
		case right:
			rightPiston.set(false);
		break;
		}
	}
	public void runIntake(Side side,double speed){
		switch(side){
		case left:
			leftMotor.set(speed);
		break;
		case right:
			rightMotor.set(-speed);
		break;
		}
	}
	public void intakeForward(Side side,double speed){
		switch(side){
		case left:
			leftMotor.set(speed*forwardConst);
		break;
		case right:
			rightMotor.set(-speed*forwardConst);
		break;
		}
	}
	public void intakeBackward(Side side,double speed){
		switch(side){
		case left:
			leftMotor.set(speed*-forwardConst);
		break;
		case right:
			rightMotor.set(-speed*-forwardConst);
		break;
		}		
	}

}
