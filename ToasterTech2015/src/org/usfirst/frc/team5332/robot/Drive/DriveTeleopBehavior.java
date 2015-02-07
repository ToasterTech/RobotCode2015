package org.usfirst.frc.team5332.robot.Drive;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.SoftwareSystem;
import org.usfirst.frc.team5332.robot.SystemBehavior;

import edu.wpi.first.wpilibj.Joystick;

public class DriveTeleopBehavior extends SystemBehavior<DriveSoftware>{
	private Joystick joystick;
	public DriveTeleopBehavior(DriveSoftware sw) {
		super(sw);
		joystick=IO.joystick;
	}
	@Override
	public void run() {
		this.software.driveMotors(joystick.getX(), joystick.getY());
	}
}
