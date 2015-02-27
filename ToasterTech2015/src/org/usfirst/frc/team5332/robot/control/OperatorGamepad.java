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
		return false;
	}

	@Override
	public boolean intakeDriveBackward() {
		// TODO Auto-generated method stub
		return joystick.getRawButton(6);
	}

	@Override
	public boolean liftNextLevel() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean liftLastLevel() {
		// TODO Auto-generated method stub
		return false;
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

	public boolean liftDriveUp() {
		// TODO Auto-generated method stub
		double axis = -joystick.getRawAxis(3);
		return axis > 0.4;
	}
	
	public boolean liftDriveDown() {
		double axis = -joystick.getRawAxis(3);
		return axis < -0.4;
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
