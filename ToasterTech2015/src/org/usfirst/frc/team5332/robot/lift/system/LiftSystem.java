package org.usfirst.frc.team5332.robot.lift.system;

import org.usfirst.frc.team5332.robot.RobotSystem;
import org.usfirst.frc.team5332.robot.sensors.LiftSensor;

public abstract class LiftSystem extends RobotSystem{
	protected boolean isMoving;
	public abstract void goUp(double speed);
	public abstract void goDown(double speed);
	public abstract void setMotors(double speed);
	public abstract void latch();
	public abstract void unlatch();
	public abstract void lowerFlaps();
	public abstract void raiseFlaps();
	public abstract void stop();
	public abstract LiftSensor.switchnum getSwitchValue();
	public boolean getMoving(){
		return isMoving;
	}
}
