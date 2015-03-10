package org.usfirst.frc.team5332.robot.drive.behavior.auto;

import org.usfirst.frc.team5332.robot.drive.DriveLogic;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveBehavior;

import edu.wpi.first.wpilibj.Timer;
/*
 * Auto behavior for intaking a bin, turning, and driving into the auto zone.
 * Implements a Finite State Machine to determine what to do based on timer inputs. 
 */
public class DriveAutoIntakeBin extends DriveBehavior{
	protected States state;
	protected double startTime;
	protected Timer timer;
	protected final double waitTime1 = 0.5;
	protected final double waitTime2 = 1;
	protected final double waitTime3 = 0.9;
	public enum States{
		None,Start,InitIntake,Clamp,Wait1,StopIntake,Turn,Wait2,Drive,Wait3,Stop;
		public States next(){
			switch(this){
			case Start:
				return InitIntake;
			case InitIntake:
				return Clamp;
			case Clamp:
				return Wait1;
			case Wait1:
				return StopIntake;
			case StopIntake:
				return Turn;
			case Turn:
				return Wait2;
			case Wait2:
				return Drive;
			case Drive:
				return Wait3;
			case Wait3:
				return Stop;
			}
			return None;
		}
	}
	public DriveAutoIntakeBin(){
		super();
		state=States.Start;
		timer=new Timer();
	}
	public DriveAutoIntakeBin(DriveLogic sw){
		super(sw);
		state=States.Start;
		timer=new Timer();
	}
	public void init(){
		timer.start();
	}
	public void run(){
		double currentTime=timer.get();
		switch(state){
		case Start:startTime=currentTime;state=States.InitIntake;break;
		case Stop: logic.driveMotors(0,0); break;
		case None: break;
		}
	}
}
