package org.usfirst.frc.team5332.robot;

/*
 * A generic wrapper for a robot subsystem. Combines a RobotSystem,a
 * SystemLogic,and SystemBehavior to fully define a robot subsystem. The
 * behavior can be swapped at runtime in order to enable autonomous and teleop
 * modes.
 * 
 * This class mostly exists for convenience to prevent a lot of classes from
 * existing in the Robot class, and to make maintenance easier.
 * 
 * Unfortunately due to type erasure, java generics don't allow for an easy way
 * to make base constructors, so constructors have to be made in each subclass
 * of RobotComponenet.
 */
public abstract class RobotComponent<S extends RobotSystem, L extends SystemLogic<S>, B extends SystemBehavior<L>> {
	protected S system;
	protected L logic;
	protected B behavior;

	public void run() {
		behavior.run();
	}

	public void setBehavior(B b) {
		behavior = b;
		behavior.setLogic(logic);
	}
}
