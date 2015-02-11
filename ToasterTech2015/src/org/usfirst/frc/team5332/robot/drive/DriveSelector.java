package org.usfirst.frc.team5332.robot.drive;

public class DriveSelector {
	public enum DriveMode{
		virtual,real
	}
	public static Drive get(DriveMode dm){
		Drive drive = null; //Drive has to be initialized, otherwise Line 16 returns an error
		switch(dm){
		case virtual:
			break;
		case real:
			drive=new Drive(new DriveReal());
			break;
		}		
		return drive;
	}
}
