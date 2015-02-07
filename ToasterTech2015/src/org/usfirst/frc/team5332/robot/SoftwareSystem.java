package org.usfirst.frc.team5332.robot;

public abstract class SoftwareSystem<E extends HardwareSystem> {
	protected E hardware;
	public SoftwareSystem(E hws){
		hardware=hws;
	}
}
