package org.usfirst.frc.team5332.robot.sensors;

import edu.wpi.first.wpilibj.AnalogInput;

public class LiftSensor {
	private AnalogInput input;
	public  LiftSensor(int port){
		input=new AnalogInput(port);
	}
	public double get(){
		return input.getVoltage();
	}
}
