package org.usfirst.frc.team5332.robot.control;

public class Deadband {
	protected double highVal;
	protected double lowVal;
	public Deadband(double val){
		highVal=val;
		lowVal=val;
	}
	public Deadband(double high,double low){
		highVal=high;
		lowVal=low;
	}
	public double get(double in){
		return ((in>highVal)||(Math.abs(in)>lowVal))?in:0;
	}
}
