package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.sensors.LiftSensor;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.DigitalInput;

/*
 * Mapping of all IO devices. Combined in one file to keep everything easy to
 * find if changes are needed. System classes reference this file to find the
 * correct IO device to use.
 */

public class IO {
	public final static TalonSRX driveLeft1 = new TalonSRX(
			1); // Create IO references to the drive Talons
	public final static TalonSRX driveLeft2 = new TalonSRX(
			2);
	public final static TalonSRX driveRight1 = new TalonSRX(
			3);
	public final static TalonSRX driveRight2 = new TalonSRX(
			4);
	/*
	 * Encoders
	 * Grayhill Series 63R 5 Pin
	 * 250 pulses / rev
	 * 4.125" / rev
	 * 4.125" / 250 pulses
	 * (note: Ben, Casey and Myles disagreed on these things, so I'm not sure to trust what they ended up giving me)
	 * Some genius put our team numbers on top of the RIO so I don't know which DIO ports to use
	 * 0 is the generic value for now
	 * Also, I am not sure which encoder value needs to be reversed.
	 * Syntax:
	 * Encoder(int channelA, int channelB, bool reverseDirection);
	 */
	public final static Encoder encoderLeft = new Encoder(0,0,false);
	public final static Encoder encoderRight = new Encoder(0,0,false);

	public final static TalonSRX intakeLeft = new TalonSRX(
			5); // Create IO references to the intake Talons
	public final static TalonSRX intakeRight = new TalonSRX(
			6);
	public final static Solenoid intakeLeftPiston = new Solenoid(
			0); // Create IO references to the intake Solenoids
	public final static Solenoid intakeRightPiston = new Solenoid(
			4);

	public final static TalonSRX liftMotor = new TalonSRX(
			7); // Create IO reference to the lift Talon
	public final static Solenoid liftFlaps = new Solenoid(
			1); // Create IO references to the lift Solenoids
	public final static Solenoid liftLatch = new Solenoid(
			2);
	public final static DigitalInput liftMaxSwitch = new DigitalInput(
			5); // Create IO references to the DIO switches
	public final static DigitalInput liftMinSwitch = new DigitalInput(
			4);
	public final static LiftSensor liftSensor = new LiftSensor(
			1);

	public final static Joystick joystick1 = new Joystick(
			0); // Left joystick should be [joystick1]
	public final static Joystick joystick2 = new Joystick(
			1); // Operator joystick should be [joystick2]
}
