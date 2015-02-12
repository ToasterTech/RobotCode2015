package org.usfirst.frc.team5332.robot.control;

import org.usfirst.frc.team5332.robot.control.InputScalingExponential;

//NOTE: This is half speed mode

public class LinearScaling extends InputScaling{
	private double returnV;
	private double divisor;
	protected double maxSpeed;
	private double myGain;
	public LinearScaling(double deadband){
		maxSpeed=0;
		divisor=2;
		myGain = deadband;
		//Get deadband and assign it to a private variable
	}
	
	public double get(double in){
		returnV = in/divisor + myGain*divisor; //You need to increase the gain since you're decreasing the start speed
		if(returnV < maxSpeed) 
			return returnV;
		else
			return maxSpeed;
	}
}
