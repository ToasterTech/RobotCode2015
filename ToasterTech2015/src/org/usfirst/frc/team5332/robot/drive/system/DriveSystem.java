package org.usfirst.frc.team5332.robot.drive.system;
import org.usfirst.frc.team5332.robot.RobotSystem;

public abstract class DriveSystem extends RobotSystem{
	public abstract void setMotors(double left,double right);
	public abstract void zeroEncoders();
	public abstract void driveLeftEncoder(double distance, double speed, boolean forward);
	public abstract void driveRightEncoder(double distance, double speed, boolean forward);
	public abstract void nintyDegreeTurn(boolean direction, double speed); //True: Left; False: Right
}