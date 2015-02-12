package org.usfirst.frc.team5332.robot.intake.systems;

import org.usfirst.frc.team5332.robot.RobotSystem;

public abstract class IntakeSystem extends RobotSystem{
	public enum Side{left,right};
	public abstract void extend(Side s);
	public abstract void retract(Side side);
	public abstract void runIntake(Side side,double speed);
	public abstract void intakeForward(Side side,double speed);
	public abstract void intakeBackward(Side side,double speed);
}
