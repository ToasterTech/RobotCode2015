package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SoftwareSystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends SystemBehavior<DriveSoftware>{
	private Joystick joystick1;
	private Joystick joystick2;
	//Return values (to be log/poly)
	private double JSLeftReturn; //Left Joystick's returned value
	private double JSRightReturn; //Right Joystick's returned value
	//Scaling operators (linear) 
	private double JSLeftScaling; //Scaling processing variable
	private double JSRightScaling; //Scaling processing variable
	private double n; //Down scaling number (speed/n for lowSpeedDrive)
	//Special curve values (poly/log)
	private double InitGain; //Initial speed gain (speed+InitGain to skip dead-band)
	private double Exp; //Exponent for curve polynomial (speed^Exp for log. curve [or something like that])
	
	public DriveTeleopBehavior(DriveSoftware sw) {
		super(sw);
		//NOTE: This code has been moved to DriveSpeedScaling.
		//The entire class file needs to be adjusted, taking values from DriveSpeedScaling instead of having everything
		//defined in here.
		/*//IO
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
		//Normal operation
		InitGain = 0; //Initial gain value
		Exp = 1; //Exponent for curve
		JSLeftReturn=Math.pow(joystick1.getY()+InitGain, Exp); //Speed scaling can be done here
		JSRightReturn=Math.pow(joystick2.getY()+InitGain, Exp); //Speed scaling can be done here
		//Half speed
		n = 2.0; //Scaling number (JSLeft-RightScaling / n)
		JSLeftScaling = joystick1.getY() + InitGain / n; //Speed reduction (y + InitGain / n)
		JSRightScaling =joystick2.getY() + InitGain / n; //Speed reduction (y + InitGain / n)*/
	}
	@Override
	public void run() {
		this.software.driveMotors(joystick1.getX(), joystick1.getY()); //Speed controlled by different axis(es)
	}
	
	public void tankDrive(){
		this.software.driveMotors(JSLeftReturn, JSRightReturn); //Speed controlled by Y of two joysticks
	}
	
	public void lowSpeedDrive(){
		this.software.driveMotors(JSLeftScaling, JSRightScaling); //Tank drive with new speed values
	}
}
