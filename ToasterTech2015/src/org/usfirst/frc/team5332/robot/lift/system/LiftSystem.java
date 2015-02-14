package org.usfirst.frc.team5332.robot.lift.system;

import org.usfirst.frc.team5332.robot.RobotSystem;

public abstract class LiftSystem extends RobotSystem{
	public enum LiftHeight{
		OneTote,TwoTote,ThreeTote,Min,Max,Transition,NONE;
	}
	protected boolean isMoving;
	public abstract void goUp(double speed);
	public abstract void goDown(double speed);
	public abstract void setMotors(double speed);
	public abstract void latch();
	public abstract void unlatch();
	public abstract void lowerFlaps();
	public abstract void raiseFlaps();
	public abstract LiftHeight getLiftHeight();
	public abstract void stop();
	public boolean getMoving(){
		return isMoving;
	}
}
