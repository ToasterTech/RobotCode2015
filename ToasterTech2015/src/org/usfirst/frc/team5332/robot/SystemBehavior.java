package org.usfirst.frc.team5332.robot;

/*
 * Parent class defining the interface for running a behavior.
 * 
 * Behaviors tell the robot what to do at certain times, based on what actions
 * are programmed in the logic level. See DriveBehavior,LiftBehavior, and
 * IntakeBehavior Subclasses for a more complete example of how behaviors work.
 * 
 * Uses generics to ensure the correct system logic is used in the subclasses.
 * Defines the base behavior for the constructors to set the logic that is being
 * used.
 */
public abstract class SystemBehavior<E extends SystemLogic> {
	protected E logic;

	public SystemBehavior() {

	}

	public SystemBehavior(E sw) {
		logic = sw;
	}

	public void setLogic(E l) {
		logic = l;
	}

	public abstract void run();
}
