package org.usfirst.frc.team5332.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

public class IO {
	public final static TalonSRX driveLeft1=new TalonSRX(1);
	public final static TalonSRX driveLeft2=new TalonSRX(2);
	public final static Joystick joystick=new Joystick(1);
}
