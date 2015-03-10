package org.usfirst.frc.team5332.robot.intake.behavior.auto;

import org.usfirst.frc.team5332.robot.intake.IntakeLogic;
import org.usfirst.frc.team5332.robot.intake.behavior.IntakeBehavior;
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
public class IntakeAutoIntakeBin extends IntakeBehavior{
	protected States state;
	protected double startTime;
	protected Timer timer;
	protected final double waitTime1 = 1; //To wait to clamp
	protected final double waitTime2 = 1; //To finish clamping action
	public enum States{
		None,Start,StartIntake,Wait1,Clamp,Wait2,Stop;
		public States next(){
			switch(this){
			case Start:
				return StartIntake;
			case StartIntake:
				return Wait1;
			case Wait1:
				return Clamp;
			case Clamp:
				return Wait2;
			case Wait2:
				return Stop;
			}
			return None;
		}
	}
	public IntakeAutoIntakeBin(){
		super();
		state=States.Start;
		timer=new Timer();
	}
	public IntakeAutoIntakeBin(IntakeLogic sw){
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
		case Start:startTime=currentTime;state=States.StartIntake;break;
		case StartIntake: this.logic.intakeBothWheels(); this.logic.open(); state=States.Wait1; break;
		case Wait1:if((currentTime-startTime)>waitTime1){
			state=States.Clamp;
		}
		break;
		case Clamp: this.logic.clamp(); state=States.Wait2; break;
		case Wait2: if((currentTime-startTime)>waitTime2){
			state=States.Stop;
		}
		break;
		case Stop: this.logic.stop(); break;
		case None: break;
		}
	}
}
