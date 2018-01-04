// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4230.OCTO.commands;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc4230.OCTO.Robot;
import org.usfirst.frc4230.OCTO.RobotMap;

/**
 *
 */
public class FlapGear extends Command {

	double startTime;
	double time;
	boolean open = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public FlapGear() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.gearFlappers);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		try {
			RobotMap.gearFlappersLight.set(Relay.Value.kForward);
			if (Robot.oi.driver.getRawButton(2)) {
				startTime = Timer.getFPGATimestamp();
				RobotMap.gearFlappersFrontFlap.set(0);
				Thread.sleep(250);

				RobotMap.gearFlappersBackFlap.setPosition(0.25);

				Thread.sleep(500);

				RobotMap.gearFlappersBackFlap.setPosition(0.95);
				Thread.sleep(500);
				RobotMap.gearFlappersBackFlap.setPosition(0.25);
				open = true;
			} else {
				if (open) {
					if (Timer.getFPGATimestamp() - startTime > 4) {
						RobotMap.gearFlappersBackFlap.setPosition(0.95);
						RobotMap.gearFlappersFrontFlap.set(30);
						open = false;
					}
				}

			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
