
package org.usfirst.frc.team5332.robot;
/*DRIVE*/
import org.usfirst.frc.team5332.robot.drive.Drive;
import org.usfirst.frc.team5332.robot.drive.DriveLogic;
import org.usfirst.frc.team5332.robot.drive.DriveSelector;
//import org.usfirst.frc.team5332.robot.drive.behavior.DriveIntakeToteAuto;
import org.usfirst.frc.team5332.robot.drive.behavior.DriveTeleopBehavior;
import org.usfirst.frc.team5332.robot.drive.behavior.auto.DriveAutoDriveForward;
import org.usfirst.frc.team5332.robot.drive.behavior.auto.DriveAutoIntakeBin;
import org.usfirst.frc.team5332.robot.drive.behavior.auto.DriveAutoIntakeTote;
import org.usfirst.frc.team5332.robot.drive.system.DriveReal;
/*INTAKE*/
import org.usfirst.frc.team5332.robot.intake.Intake;
//import org.usfirst.frc.team5332.robot.intake.behavior.IntakeIntakeToteAuto;
import org.usfirst.frc.team5332.robot.intake.behavior.IntakeTeleopBehavior;
import org.usfirst.frc.team5332.robot.intake.behavior.auto.IntakeAutoIntakeBin;
import org.usfirst.frc.team5332.robot.intake.behavior.auto.IntakeAutoIntakeTote;
import org.usfirst.frc.team5332.robot.intake.systems.IntakeReal;
/*LIFT*/
import org.usfirst.frc.team5332.robot.lift.Lift;
import org.usfirst.frc.team5332.robot.lift.behavior.LiftTeleopBehavior;
import org.usfirst.frc.team5332.robot.lift.behavior.LiftTestBehavior;
import org.usfirst.frc.team5332.robot.lift.system.LiftReal;




/*MISC.*/
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

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
	Intake intake;
	Lift lift;
	Camera camera;
	NetworkTable ntTable;
	int selectedAuto;
    public void robotInit() {
    	drive=new Drive(new DriveReal());
    	intake=new Intake(new IntakeReal());
    	lift=new Lift(new LiftReal());
    	camera=new Camera("cam0");
    	camera.init();
    	ntTable = NetworkTable.getTable("driverStationData");
    	selectedAuto=(int)Math.round(ntTable.getNumber("selectedAuto"));
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousInit(){
    	switch(selectedAuto){
    	case 1:
    		/*AutoDriveForward*/
    		DriveAutoDriveForward d_AutoDriveForward=new DriveAutoDriveForward();
    		break;
    	case 2:
    		/*AutoIntakeTote*/
    		DriveAutoIntakeTote d_AutoIntakeTote=new DriveAutoIntakeTote();
    		IntakeAutoIntakeTote i_AutoIntakeTote=new IntakeAutoIntakeTote();
    		break;
    	case 3:
    		/*AutoIntakeBin*/
    		DriveAutoIntakeBin d_AutoIntakeBin=new DriveAutoIntakeBin();
    		IntakeAutoIntakeBin i_AutoIntakeBin=new IntakeAutoIntakeBin();
    		break;
    	case 4:
    		/*AutoIntakeToteAndBin*/
    		/*
    		DriveAutoIntakeToteAndBin d_AutoIntakeToteAndBin=new DriveAutoIntakeToteAndBin();
    		IntakeAutoIntakeToteAndBin i_AutoIntakeToteAndBin=new IntakeAutoIntakeToteAndBin();
    		LiftAutoIntakeToteAndBin l_AutoIntakeToteAndBin=new LifAutoIntakeToteAndBin();
    		*/
    		break;
    	case 5:
    		/*Auto3Stack*/
    		/*
    		DriveAuto3Stack d_Auto3Stack=new DriveAuto3Stack();
    		IntakeAuto3Stack i_Auto3Stack=new IntakeAuto3Stack();
    		LiftAuto3Stack l_Auto3Stack=new LiftAuto3Stack();
    		*/
    		break;
    	}
    	/*
    	 * Old Auto Code (in the event that the auto selector fails I left this in place)
    	//DrivePushToteAuto dauto=new DrivePushToteAuto();
    	DriveAutoDriveForward dauto=new DriveAutoDriveForward();
    	//DriveIntakeToteAuto dauto=new DriveIntakeToteAuto();
    	//IntakeIntakeToteAuto iauto = new IntakeIntakeToteAuto();
    	dauto.init();
    	drive.setBehavior(dauto);
    	//intake.setBehavior(iauto);
    	*/
    }
    public void autonomousPeriodic() {
    	/*
    	 * TODO: Auton state switch machines
    	 */
    	drive.run();
    	//intake.run();
    }
    public void teleopInit(){
    	drive.setBehavior(new DriveTeleopBehavior());
    	intake.setBehavior(new IntakeTeleopBehavior());
    	lift.setBehavior(new LiftTeleopBehavior());
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        drive.run();
        intake.run();
        lift.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
