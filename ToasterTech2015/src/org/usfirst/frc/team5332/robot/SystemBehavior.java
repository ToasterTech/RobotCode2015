package org.usfirst.frc.team5332.robot;

public abstract class SystemBehavior<E extends SystemLogic> {
	protected E logic;
	public SystemBehavior(E sw){
		logic=sw;
	}
	public abstract void run();
}
