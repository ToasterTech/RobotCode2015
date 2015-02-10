
package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.drive.Drive;
import org.usfirst.frc.team5332.robot.drive.DriveReal;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;
import org.usfirst.frc.team5332.robot.drive.DriveSelector;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveTeleopBehavior;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveTeleopComp;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Drive drive;
    public void robotInit() {
    	drive=DriveSelector.get(DriveSelector.DriveMode.real);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
