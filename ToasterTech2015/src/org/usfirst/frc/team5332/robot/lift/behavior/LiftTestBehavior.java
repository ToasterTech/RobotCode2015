package org.usfirst.frc.team5332.robot.lift.behavior;

import org.usfirst.frc.team5332.robot.lift.LiftLogic;

public class LiftTestBehavior extends LiftBehavior{
	public LiftTestBehavior(){
		super();
	}
	public LiftTestBehavior(LiftLogic sw){
		super(sw);
		
	}
	public void run(){
		System.out.println(logic.getLiftHeight());
	}
}
