package org.usfirst.frc.team5332.robot.drive.behavior.auto;

import org.usfirst.frc.team5332.robot.drive.DriveLogic;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveBehavior;
import org.usfirst.frc.team5332.robot.drive.behavior.auto.DriveAutoDriveForward.States;

import edu.wpi.first.wpilibj.Timer;

/*
 * TIMING:
 * 0.0: Start
 * 0.0 - 1.0: Open and allow pneumatics to sufficently warm up
 * 1.0 - 2.0: Clamp and wait for clamp action to finish
 * 2.0: Stop intake motors
 * 2.5 - 3.5: Turn left (drive right motor)
 * 3.5 - 4.4: Drive
 * 4.4: Stop driving
 */

/*
 * Auto behavior for intaking a bin, turning, and driving into the auto zone.
 * Implements a Finite State Machine to determine what to do based on timer inputs. 
 */
public class DriveAutoIntakeBin extends DriveBehavior{
	protected States state;
	protected double startTime;
	protected Timer timer;
	protected final double waitTime1 = 2.5; //To finish intake stuff
	protected final double waitTime2 = 1; //To complete turn
	protected final double waitTime3 = 0.9; //To drive to auto zone
	public enum States{
		None,Start,Wait1,Turn,Wait2,Drive,Wait3,Stop;
		public States next(){
			switch(this){
			case Start:
				return Wait1;
			case Wait1:
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
		case Start:startTime=currentTime;state=States.Wait1;break;
		case Wait1: if((currentTime-startTime)>waitTime1){
			state=States.Turn;
		}
		break;
		case Turn: logic.driveMotors(0, 0.6); state=States.Wait2; break;
		case Wait2: if((currentTime-startTime)>waitTime2){
			state=States.Drive;
		}
		break;
		case Drive: logic.driveMotors(0.5,0.5); state=States.Wait3; break;
		case Wait3: if((currentTime-startTime)>waitTime3){
			state=States.Stop;
		}
		break;
		case Stop: logic.driveMotors(0,0); break;
		case None: break;
		}
	}
}
