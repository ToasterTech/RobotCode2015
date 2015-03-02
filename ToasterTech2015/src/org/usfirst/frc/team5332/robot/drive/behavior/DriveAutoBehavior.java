package org.usfirst.frc.team5332.robot.drive.behavior;

import org.usfirst.frc.team5332.robot.drive.DriveLogic;

import edu.wpi.first.wpilibj.Timer;

public class DriveAutoBehavior extends DriveBehavior{
	protected States state;
	protected double startTime;
	protected final double waitTime=.9;
	protected Timer timer;
	public enum States{
		None,PreStart,Start,Move,Wait,Stop;
		public States next(){
			switch(this){
			case Start:
				return Move;
			case Move:
				return Wait;
			case Wait:
				return Stop;
			case Stop:
				return Stop;
			}
			return None;
		}
	}
	public DriveAutoBehavior(){
		super();
		state=States.Start;
		timer=new Timer();
	}
	public DriveAutoBehavior(DriveLogic sw){
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
		case Start:startTime=currentTime;state=States.PreStart;break;
		case PreStart:
		if((currentTime-startTime)>1){
			state=States.Move;
		}
		case Move: this.logic.driveMotors(.5,.5);state=States.Wait;break;
		case Wait: if((currentTime-startTime)>waitTime){
			state=States.Stop;
		}
		System.out.println(" Current "+currentTime+" startTime "+startTime+" difference "+(currentTime-startTime));
		break;
		case Stop: logic.driveMotors(0,0); break;
		case None: break;
		}
	}
}
