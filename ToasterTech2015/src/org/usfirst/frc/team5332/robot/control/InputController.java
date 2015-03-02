package org.usfirst.frc.team5332.robot.control;

public abstract class InputController {
	protected double maxSpeed;
	public boolean intakeDriveLeft() {
		return false;
	}
	public boolean intakeMoveLeft() {
		return false;
	}
	public boolean intakeDriveRight() {
		return false;
	}
	public boolean intakeMoveRight() {
		return false;
	}
	public boolean intakeClamp() {
		return false;
	}
	public boolean intakeRelease() {
		return false;
	}
	public boolean intakeDriveForward() {
		return false;
	}
	public boolean intakeDriveBackward() {
		return false;
	}
	
	public boolean liftNextLevel() {
		return false;
	}
	public boolean liftLastLevel() {
		return false;
	}
	public boolean liftDriveUp() {
		return false;
	}
	public boolean liftDriveDown() {
		return false;
	}
	
	public double driveLeft() {
		return 0;
	}
	public double driveRight() {
		return 0;
	}
	
	public boolean estopState() {
		return false;
	}
	
	public boolean goToMax() {
		return false;
	}
	public boolean goToMin() {
		return false;
	}
}
