package org.usfirst.frc.team5332.robot.Drive;

public class LowSpeedMode {
	private double returnV;
	private double divisor;
	protected double maxSpeed;
	public LowSpeedMode(){
		maxSpeed=0;
		divisor=2;
		/*
		 * TODO: Import InitGain (to jump the deadband) from another class
		 */
	}
	/*
	 * 
	 */
	public double get(double in){
		returnV = in/divisor;
		if(returnV < maxSpeed) 
			return returnV;
		else
			return maxSpeed;
	}
}
