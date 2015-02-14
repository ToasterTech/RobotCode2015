package org.usfirst.frc.team5332.robot.lift.system;

import org.usfirst.frc.team5332.robot.IO;
import org.usfirst.frc.team5332.robot.sensors.LiftSensor;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TalonSRX;

public class LiftReal extends LiftSystem{
	private TalonSRX liftMotor;
	private LiftSensor sensor;
	private DigitalInput maxSwitch,minSwitch;
	private Solenoid liftFlaps, liftLatch;
	private final double speedConstant=1;
	public LiftReal(){
		super();
		liftMotor = IO.liftMotor; //Call these from the IO
		liftFlaps = IO.liftFlaps;
		liftLatch = IO.liftLatch;
		maxSwitch = IO.liftMaxSwitch;
		minSwitch = IO.liftMinSwitch;
		sensor = IO.liftSensor;
	}

	@Override
	public void goUp(double speed) {
		liftMotor.set(Math.abs(speed)*speedConstant); //Go up
		isMoving = true;
	}

	@Override
	public void goDown(double speed) {
		liftMotor.set(-Math.abs(speed)*speedConstant); //Go down
		isMoving = true;
	}

	@Override
	public void setMotors(double speed) {
		liftMotor.set(speed*speedConstant); //Move
		isMoving = true;
	}

	@Override
	public LiftHeight getLiftHeight() {
		/*
		Voltage:
		5- Highest Magnetic Reed Switch value
		4
		3
		2
		1- Lowest Magnetic Reed Switch value
		0- No Magnetic Reed Switch value, is in TRANSITION
		*/
		LiftSensor.switchnum sensorReturnedValue;
		sensorReturnedValue=sensor.getSwitchNumber();
		switch(sensorReturnedValue){
		case five:
			return LiftHeight.ThreeTote; //Highest
		case four:
			return LiftHeight.NONE; //Unused
		case three:
			return LiftHeight.TwoTote; //Middle
		case two:
			return LiftHeight.NONE; //Unused
		case one:
			return LiftHeight.OneTote; //Lowest
		case none:
			if(getMoving())
				return LiftHeight.Transition; //Because it is not reading anything, but is moving, it is in transition
			else
				return LiftHeight.NONE; //Because it is not reading anything, and it is not moving, return NONE
		default:
			return null;
		}
	}

	@Override
	public void latch() {
		liftLatch.set(true); //Latch
	}

	@Override
	public void unlatch() {
		liftLatch.set(false); //Unlatch
	}

	@Override
	public void lowerFlaps() {
		liftFlaps.set(true); //Lower the flaps
	}

	@Override
	public void raiseFlaps() {
		liftFlaps.set(false); //Raise the flaps
	}

	@Override
	public void stop() {
		liftMotor.set(0); //Stop the motor
		latch(); //Latch
		isMoving = false;
	}
	
}
