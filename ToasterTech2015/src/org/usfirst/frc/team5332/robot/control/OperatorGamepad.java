package org.usfirst.frc.team5332.robot.control;

import org.usfirst.frc.team5332.robot.IO;

import edu.wpi.first.wpilibj.Joystick;

public class OperatorGamepad extends InputController {
	public final static OperatorGamepad instance=new OperatorGamepad();
	protected InputScalingFactor driveSafeFactor;
	protected Joystick joystick;
	private OperatorGamepad(){
		joystick=IO.joystick1;
		driveSafeFactor=new InputScalingFactor(.5);
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
		return false;
	}

	@Override
	public boolean intakeDriveBackward() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean liftNextLastButton=false;
	@Override
	public boolean liftNextLevel() {
		// TODO Auto-generated method stub
		boolean in=joystick.getRawButton(2);
		boolean ret=in&&!liftNextLastButton;
		liftNextLastButton=in;
		return ret;
	}
	private boolean liftLastLastButton=false;
	@Override
	public boolean liftLastLevel() {
		boolean in=joystick.getRawButton(2);
		boolean ret=in&&!liftLastLastButton;
		liftLastLastButton=in;
		return ret;
	}

	public boolean liftDriveUp() {
		// TODO Auto-generated method stub
		double axis = -joystick.getRawAxis(1);
		return joystick.getRawButton(5);
	}
	
	public boolean liftDriveDown() {
		double axis = -joystick.getRawAxis(1);
		return joystick.getRawButton(6);
	}
	
	public boolean estopState() {
		boolean select = joystick.getRawButton(9);
		boolean start = joystick.getRawButton(10);
		return select && start;
	}



	@Override
	public double driveRight() {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public boolean goToMax() {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean goToMin() {
		// TODO Auto-generated method stub
		return false;
	}

}
