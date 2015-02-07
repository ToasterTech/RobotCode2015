package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class IO {
	public final static TalonSRX driveLeft1=new TalonSRX(1);
	public final static TalonSRX driveLeft2=new TalonSRX(2);
	public final static Joystick joystick1=new Joystick(1);
	public final static Joystick joystick2=new Joystick(2);
}
