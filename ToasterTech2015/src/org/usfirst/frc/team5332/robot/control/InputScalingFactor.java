package org.usfirst.frc.team5332.robot.control;

public class InputScalingFactor extends InputScaling{
	private double factor;
	public InputScalingFactor(double factor){
		this.factor=factor;
	}
	public double get(double in){
		return in*factor;
	}
}
