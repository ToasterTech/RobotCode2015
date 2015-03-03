package org.usfirst.frc.team5332.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;
/*
 * A class defining the lift sensor that Josh designed. 
 * 
 * Can return the raw voltage as well as an enum detailing which switch is currently being triggered. 
 */
public class LiftSensor {
	public enum switchnum{
		one,two,three,four,five,none;
	}
	private AnalogInput input;
	public  LiftSensor(int port){
		input=new AnalogInput(port);
	}
	public double get(){
		return input.getVoltage();
	}
	public switchnum getSwitchNumber(){
		System.out.println("Analog Value"+get()+" : Rounded "+Math.round(get()));
		if(Math.round(get()) == 0)
			return switchnum.none;
		if(Math.round(get()) == 1)
			return switchnum.one;
		if(Math.round(get()) == 2)
			return switchnum.two;
		if(Math.round(get()) == 3)
			return switchnum.three;
		if(Math.round(get()) == 4)
			return switchnum.four;
		if(Math.round(get()) == 5)
			return switchnum.five;
		return switchnum.none;
	}
}
