package org.usfirst.frc.team5332.robot;

public abstract class SystemBehavior<E extends SystemLogic> {
	protected E logic;
	public SystemBehavior(){
		
	}
	public SystemBehavior(E sw){
		logic=sw;
	}
	public void setLogic(E l){
		logic=l;
	}
	public abstract void run();
}
