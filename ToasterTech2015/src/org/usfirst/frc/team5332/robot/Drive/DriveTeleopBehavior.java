package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SoftwareSystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends SystemBehavior<DriveSoftware>{
	private Joystick joystick1;
	private Joystick joystick2;
	//Return values
	private Double JSLeftReturn; //Left Joystick's returned value
	private Double JSRightReturn; //Right Joystick's returned value
	private Double JSLeftScaling; //Scaling processing variable
	private Double JSRightScaling; //Scaling processing variable
	private Double n; //Scaling number
	public DriveTeleopBehavior(DriveSoftware sw) {
		super(sw);
		joystick1=IO.joystick1;
		joystick2=IO.joystick2;
		JSLeftReturn=joystick1.getY(); //Speed scaling can be done here
		JSRightReturn=joystick2.getY(); //Speed scaling can be done here
		n = 2.0; //Scaling number (JSReturnedValue / n)
	}
	@Override
	public void run() {
		this.software.driveMotors(joystick1.getX(), joystick1.getY()); //Speed controlled by different axis(es)
	}
	
	public void tankDrive(){
		this.software.driveMotors(JSLeftReturn, JSRightReturn); //Speed controlled by Y of two joysticks
	}
	
	public void lowSpeedDrive(){
		JSLeftScaling = JSLeftReturn / n; //Get scaled value
		JSRightScaling = JSRightReturn / n; //Get scaled value
		this.software.driveMotors(JSLeftScaling, JSRightScaling); //Tank drive with new speed values
	}
}
