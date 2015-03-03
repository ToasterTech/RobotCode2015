package org.usfirst.frc.team5332.robot;

/*
 * Defines the base constructors for the SystemLogic.
 * 
 * SystemLogic controls higher level actions and state. These actions are made
 * out of simpler atomic actions defined in System such as turn the motors
 * on/off or read sensors values.
 * 
 * Uses generics to ensure the correct System is passed into it. 
 */
public abstract class SystemLogic<E extends RobotSystem> {
	protected E system;

	public SystemLogic() {

	}

	public SystemLogic(E hws) {
		system = hws;
	}

	public void setSystem(E hw) {
		system = hw;
	}
}
