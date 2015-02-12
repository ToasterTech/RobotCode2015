package org.usfirst.frc.team5332.robot.intake;

import org.usfirst.frc.team5332.robot.RobotComponent;
import org.usfirst.frc.team5332.robot.intake.behavior.IntakeBehavior;
import org.usfirst.frc.team5332.robot.intake.systems.IntakeSystem;

public class Intake extends RobotComponent<IntakeSystem,IntakeLogic,IntakeBehavior>{
	public Intake(IntakeSystem sys){
		this.system=sys;
		this.logic=new IntakeLogic(system);
		this.behavior=new IntakeBehavior(logic);
	}
}
