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
		if(!(this.maxSwitch.get()||this.minSwitch.get())){
			liftMotor.set(Math.abs(speed)*speedConstant); //Go up
			isMoving = true;
		}
	}

	@Override
	public void goDown(double speed) {
		if(!(this.maxSwitch.get()||this.minSwitch.get())){
			liftMotor.set(-Math.abs(speed)*speedConstant); //Go down
			isMoving = true;
		}
	}

	@Override
	public void setMotors(double speed) {
		if(!(this.maxSwitch.get()||this.minSwitch.get())){
			liftMotor.set(speed*speedConstant); //Move
			isMoving = true;
		}
	}

	@Override
	public LiftSensor.switchnum getSwitchValue() {
		return this.sensor.getSwitchNumber();
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
