package org.usfirst.frc.team5332.robot.lift;

import org.usfirst.frc.team5332.robot.RobotComponent;
import org.usfirst.frc.team5332.robot.lift.behavior.LiftBehavior;
import org.usfirst.frc.team5332.robot.lift.system.LiftSystem;

public class Lift extends RobotComponent<LiftSystem,LiftLogic,LiftBehavior>{
	public Lift(LiftSystem sys){
		this.system=sys;
		this.logic=new LiftLogic(sys);
		this.behavior=new LiftBehavior(logic);
	}
}
