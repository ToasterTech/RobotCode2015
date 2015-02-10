package org.usfirst.frc.team5332.robot;

public abstract class SystemLogic<E extends HardwareSystem> {
	protected E hardware;
	public SystemLogic(){
		
	}
	public SystemLogic(E hws){
		hardware=hws;
	}
	public void setHardware(E hw){
		hardware=hw;
	}
}
