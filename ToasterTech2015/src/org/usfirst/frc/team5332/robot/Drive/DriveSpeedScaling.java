package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SoftwareSystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

import edu.wpi.first.wpilibj.Joystick;


public class DriveSpeedScaling {
	//Numbers 'n' stuff (shouldn't be operated on or changed)
	public double InitGain; //Initial gain (all)
	public double Exp; //Exponent
	public double n; //Low speed scaling divisor
	//Variables (normal operation)
	public double JSLeftReturn;
	public double JSRightReturn;
	//Variables (scaling)
	public double JSLeftScaling;
	public double JSRightScaling;
	//Joysticks
	public Joystick joystick1;
	public Joystick joystick2;
	
	public DriveSpeedScaling (){
		//NOTE: Needs to be tweaked, just copied over what I had to make sure all the values were in place and being operated on correctly
		//IO
		joystick1=IO.joystick1; //Set the joysticks
		joystick2=IO.joystick2;
		//Normal operation
		InitGain = 0; //Initial gain value
		Exp = 1; //Exponent for curve
		JSLeftReturn=Math.pow(joystick1.getY()+InitGain, Exp); //Speed scaling (y + InitGain ^ Exp)
		JSRightReturn=Math.pow(joystick2.getY()+InitGain, Exp); //Speed scaling (y + InitGain ^ Exp)
		//Half speed
		n = 2.0; //Scaling number (JSLeft-RightScaling / n)
		JSLeftScaling = joystick1.getY() + InitGain / n; //Speed reduction (y + InitGain / n)
		JSRightScaling =joystick2.getY() + InitGain / n; //Speed reduction (y + InitGain / n)
	}
	
}
