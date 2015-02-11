package org.usfirst.frc.team5332.robot.drive;

import org.usfirst.frc.team5332.robot.drive.system.DriveReal;

public class DriveSelector {
	public enum DriveMode{
		virtual,real
	}
	public static Drive get(DriveMode dm){
		Drive drive = null; 
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
