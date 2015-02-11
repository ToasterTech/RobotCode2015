package org.usfirst.frc.team5332.robot;

public abstract class SystemLogic<E extends RobotSystem> {
	protected E system;
	public SystemLogic(){
		
	}
	public SystemLogic(E hws){
		system=hws;
	}
	public void setSystem(E hw){
		system=hw;
	}
}
