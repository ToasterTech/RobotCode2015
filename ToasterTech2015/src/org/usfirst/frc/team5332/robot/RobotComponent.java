package org.usfirst.frc.team5332.robot;

public abstract class RobotComponent<S extends RobotSystem,L extends SystemLogic<S>,B extends SystemBehavior<L>> {
	protected S system;
	protected L logic;
	protected B behavior;
	public void run(){
		behavior.run();
	}
	public void setBehavior(B b){
		behavior=b;
		behavior.setLogic(logic);
	}
}
