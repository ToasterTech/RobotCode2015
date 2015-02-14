package org.usfirst.frc.team5332.robot.lift;

import org.usfirst.frc.team5332.robot.SystemLogic;
import org.usfirst.frc.team5332.robot.lift.system.LiftSystem;
import org.usfirst.frc.team5332.robot.sensors.LiftSensor;

public class LiftLogic extends SystemLogic<LiftSystem>{
	public enum LiftHeight{
		Min(0),OneTote(1),TwoTote(2),ThreeTote(3),Max(4),Transition(-1),NONE(-1);
		private final int value;
		private LiftHeight(int val){
			this.value=val;
		}
		public int direction(LiftHeight height){
			if(height==Transition||height==NONE){
				return 0;
			}
			else{
				return height.value-this.value;
			}
		}
		private LiftHeight mapping(int i){
			switch(i){
			case 0:	return Min;
			case 1:	return OneTote;
			case 2: return TwoTote;
			case 3: return ThreeTote;
			case 4: return Max;
			}
			return NONE;
		}
		public LiftHeight getNext(){
			int next=this.value+1;
			if(value>4){
				return Max;
			}
			return mapping(next);
		}
		public LiftHeight getLast(){
			int next=this.value-1;
			if(value>4){
				return Min;
			}
			return mapping(next);
		}
	}

	public LiftLogic(LiftSystem sys){
		super(sys);
	}
	private LiftHeight lastHeight;
	public LiftHeight getLastHeight(){
		LiftHeight temp=this.getLiftHeight();
		if((temp==LiftHeight.NONE)||(temp==LiftHeight.Transition)){
			return lastHeight;
		}else{
			return temp;
		}
	}
	public boolean goToHeight(LiftHeight height){
		lastHeight=this.getLastHeight();
		if(height.direction(lastHeight)<0){
			system.goDown(1);
			return false;
		}
		if(height.direction(lastHeight)>0){
			system.goUp(1);
			return false;
		}else{
			system.stop();
			return true;
		}
	}
	public boolean goToNextLevel(){
		return goToHeight(lastHeight.getNext());
	}
	public boolean goToLastLevel(){
		return goToHeight(lastHeight.getLast());
	}
	public void goUp(){
		system.goUp(1);
	}
	public void goDown(){
		system.goDown(1);
	}
	public void goUpSlow(){
		system.goUp(.2);
	}
	public void goDownSlow(){
		system.goDown(.2);
	}
	public LiftHeight getLiftHeight(){
		/*
		Voltage:
		5- Highest Magnetic Reed Switch value
		4
		3
		2
		1- Lowest Magnetic Reed Switch value
		0- No Magnetic Reed Switch value, is in TRANSITION
		*/
		LiftSensor.switchnum sensorReturnedValue;
		sensorReturnedValue=system.getSwitchValue();
		switch(sensorReturnedValue){
		case five:
			return LiftHeight.OneTote; //Highest
		case four:
			return LiftHeight.NONE; //Unused
		case three:
			return LiftHeight.NONE; //Middle
		case two:
			return LiftHeight.TwoTote; //Unused
		case one:
			return LiftHeight.ThreeTote; //Lowest
		case none:
			if(this.system.isMax())
				return LiftHeight.Max;
			if(this.system.isMin())
				return LiftHeight.Min;
			if(system.getMoving())
				return LiftHeight.Transition; //Because it is not reading anything, but is moving, it is in transition
			else
				return LiftHeight.NONE; //Because it is not reading anything, and it is not moving, return NONE
		default:
			return null;
		}	
	}
	public void stop(){
		system.stop();
	}
	public void latch(){
		system.latch();
	}
	public void unlatch(){
		system.unlatch();
	}
}
