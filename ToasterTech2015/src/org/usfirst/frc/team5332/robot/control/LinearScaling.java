package org.usfirst.frc.team5332.robot.control;

import org.usfirst.frc.team5332.robot.control.InputScalingExponential;

public class LinearScaling extends InputScaling{
	private double returnV;
	private double divisor;
	protected double maxSpeed;
	private double myGain;
	public LinearScaling(double deadband){
		maxSpeed=0;
		divisor=2;
		myGain = deadband;
		//Call dbGain and assign it to a private variable
	}
	
	public double get(double in){
		returnV = in/divisor + myGain*divisor;
		if(returnV < maxSpeed) 
			return returnV;
		else
			return maxSpeed;
	}
}
