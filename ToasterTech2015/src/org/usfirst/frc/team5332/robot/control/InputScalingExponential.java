package org.usfirst.frc.team5332.robot.control;

/*
Pseudo-code:

if(input > 0) then
	returnV = input + dbGain ^ input x (input x 1.3)
else
	returnV = -(|input| + dbGain ^ |input| x [|input| x 1.3])

If the input is positive (>0) return the positive curve. Otherwise (<0) return the negative curve.
*/

public class InputScalingExponential extends InputScaling{
	private double returnV;
	public double dbGain; //This is also called in LinearScaling
	public InputScalingExponential(double db){
		dbGain=db;
	}
	public double getScaled(double in){
		double Exp;
		Exp = Math.abs(in)*(Math.abs(in)*1.3);
		if(in > 0)
			returnV = Math.pow(in+dbGain, Exp);
		else
			returnV = -(Math.pow(Math.abs(in)+dbGain, Exp));
		return returnV;
	} 
}
