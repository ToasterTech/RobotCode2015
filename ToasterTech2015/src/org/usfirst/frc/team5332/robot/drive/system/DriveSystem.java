package org.usfirst.frc.team5332.robot.drive.system;
import org.usfirst.frc.team5332.robot.RobotSystem;

public abstract class DriveSystem extends RobotSystem{
	public abstract void setMotors(double left,double right);
	public abstract void zeroEncoders();
}
