package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.SystemBehavior;
import org.usfirst.frc.team5332.robot.lift.LiftLogic;
/*
 * Base class for both Teleop and Auto lift behaviors. 
 */
public class LiftBehavior extends SystemBehavior<LiftLogic>{
	public LiftBehavior(){
		super();
	}
	public LiftBehavior(LiftLogic l){
		super(l);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
