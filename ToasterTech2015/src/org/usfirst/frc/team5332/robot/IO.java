package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class IO {
	public final static TalonSRX driveLeft1=new TalonSRX(1); //Create IO references to the talons
	public final static TalonSRX driveLeft2=new TalonSRX(2);
	public final static TalonSRX driveRight1=new TalonSRX(3);
	public final static TalonSRX driveRight2=new TalonSRX(4);
	public final static Joystick joystick1=new Joystick(1); //Left joystick should be [joystick1]
	public final static Joystick joystick2=new Joystick(2); //Right joystick should be [joystick2]
}
