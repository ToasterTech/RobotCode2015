package org.usfirst.frc.team5332.robot.control;

public abstract class InputController {
	protected double maxSpeed;
	public abstract boolean intakeDriveLeft();
	public abstract boolean intakeMoveLeft();
	public abstract boolean intakeDriveRight();
	public abstract boolean intakeMoveRight();
	public abstract boolean intakeClamp();
	public abstract boolean intakeRelease();
	public abstract boolean intakeDriveForward();
	public abstract boolean intakeDriveBackward();
	
	public abstract boolean liftNextLevel();
	public abstract boolean liftLastLevel();
	
	public abstract double driveLeft();
	public abstract double driveRight();
}
