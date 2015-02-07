
package org.usfirst.frc.team5332.robot;

import org.usfirst.frc.team5332.robot.Drive.Drive;
import org.usfirst.frc.team5332.robot.Drive.DriveHardware;
import org.usfirst.frc.team5332.robot.Drive.DriveSoftware;
import org.usfirst.frc.team5332.robot.Drive.DriveTeleopBehavior;

import edu.wpi.first.wpilibj.IterativeRobot;

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
    	DriveHardware dh=new DriveHardware();
    	DriveSoftware ds=new DriveSoftware(dh);
    	DriveTeleopBehavior	dt=new DriveTeleopBehavior(ds);
    	drive=new Drive(dh,ds,dt);
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
