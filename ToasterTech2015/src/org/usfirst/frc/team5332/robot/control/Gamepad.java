package org.usfirst.frc.team5332.robot.control;

import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad extends InputController {
	public final static Gamepad instance=new Gamepad();
	protected InputScalingFactor driveSafeFactor;
	protected Joystick joystick;
	private Gamepad(){
		joystick=IO.joystick1;
		driveSafeFactor=new InputScalingFactor(.5);
	}
	
	
	
	@Override
	public boolean intakeDriveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeMoveLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeDriveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeMoveRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean intakeClamp() {
		boolean rt = joystick.getRawButton(8);
		return rt;
	}

	@Override
	public boolean intakeRelease() {
		boolean rt = joystick.getRawButton(8);
		return !rt;
	}

	@Override
	public boolean intakeDriveForward() {
		// TODO Auto-generated method stub
		return joystick.getRawButton(6);
	}

	@Override
	public boolean intakeDriveBackward() {
		// TODO Auto-generated method stub
		return joystick.getRawButton(6);
	}

	@Override
	public double driveLeft() {
		// TODO Auto-generated method stub
		boolean backwards = joystick.getRawButton(1);
		double axis = joystick.getRawAxis(1);
		
		double motorValue=0;
		if(backwards)
			motorValue=-1;
		else
			motorValue=-axis;
		
		return this.driveSafeFactor.get(motorValue);
	}

	@Override
	public double driveRight() {
		// TODO Auto-generated method stub
		boolean backwards = joystick.getRawButton(1);
		double axis = joystick.getRawAxis(3);
		
		double motorValue=0;
		if(backwards)
			motorValue=-1;
		else
			motorValue=axis;
		return this.driveSafeFactor.get(motorValue);
	}

}
