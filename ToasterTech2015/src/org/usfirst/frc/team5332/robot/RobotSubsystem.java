package org.usfirst.frc.team5332.robot;

public abstract class RobotSubsystem<E extends SystemBehavior> {
	public abstract void run();
	public abstract void setBehavior(E b);
}
