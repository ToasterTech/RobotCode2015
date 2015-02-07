package org.usfirst.frc.team5332.robot;

public abstract class SystemBehavior<E extends SoftwareSystem> {
	protected E software;
	public SystemBehavior(E sw){
		software=sw;
	}
	public abstract void run();
}
