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

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4230.OCTO.RobotMap;
import org.usfirst.frc4230.OCTO.Drive;
import org.usfirst.frc4230.OCTO.Robot;

/**
 *
 */
public class TeleopDrive extends Command {

	final static public double NORMAL = 350.0; 
	final static public double FAST = 600.0;
	final static public double SLOW = 100.0;
	final static double stickSensitivity = 0.05;
	static public double maxSpeed;
	static public double maxRotation = 200.0;
	//double startAngle;
	final static double center = 320.0;
	final static double camMax = 240.0;
	double camDiff;
	double joyZ;
	double targetX;
	boolean toggleDrive = true;
	double prevSpd = 0.0;
	boolean toggleGyro = false;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
	public TeleopDrive() {

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.driveTrain);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		//RobotMap.adiGyro.reset();
		
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		/*
		 * double[] targetNum = new double[10];
		 * 
		 * 
		 * 
		 * targetNum = Robot.table.getNumberArray("LINE_PATTERN", targetNum); if
		 * (targetNum == null || targetNum.length < 2) { targetX = 320; } else {
		 * SmartDashboard.putNumber("num", targetNum.length); targetX =
		 * targetNum[1]; } SmartDashboard.putNumber("Camera Target", targetX);
		 */
		if (Robot.oi.driver.getPOV() == -1) {

			double joyX;
			double joyY;
			double joyZ;
			
			
			
			joyX = Robot.oi.driver.getRawAxis(1);
			joyY = Robot.oi.driver.getRawAxis(0);
			
			double[] targetNum = new double[10];
			targetNum = Robot.table.getNumberArray("LINE_PATTERN", targetNum);
			if (targetNum == null || targetNum.length <= 2) {
				targetX = 0;
			}
			else {
				targetX = targetNum[1];
			}
			//SmartDashboard.putNumber("Camera Target", targetX);
			
			joyZ = Robot.oi.driver.getRawAxis(2) * -1;
			joyZ = joyZ * joyZ * joyZ;

			if (Robot.oi.operator.getRawButton(1)) {
				RobotMap.adiGyro.reset();
			}

			double gyroAngle = RobotMap.adiGyro.getAngleX();
			double robotAngle = gyroAngle * (Math.PI / 180.0);
			
			SmartDashboard.putNumber("gyro", gyroAngle);

			if (Robot.oi.operator.getRawButton(2)) {
				toggleGyro = !toggleGyro;
			}

			if (toggleGyro) {
				gyroAngle = 0.0;
			}

			if (toggleDrive) {

				//SmartDashboard.putNumber("Gyro ", RobotMap.adiGyro.getAngleX());
				SmartDashboard.putNumber("speed", maxSpeed);

				Drive.octoDrive(joyX, joyY, joyZ, maxSpeed, maxRotation, robotAngle);

			} else {

				final double TURNSENS = 1;
				final double stickSensitivity = 0.15;

				if (Math.abs(joyX) < stickSensitivity) {
					joyX = 0.0;
				}
				if (Math.abs(joyY) < stickSensitivity) {
					joyY = 0.0;
				}
				if (Math.abs(joyZ) < stickSensitivity) {
					joyZ = 0.0;
				}

				double stickAngle = joyAngle(joyX, joyY);
				
				double rotation = joyZ * maxRotation;
				double difference = stickAngle - robotAngle;
				double speed = Math.sqrt(joyX * joyX + joyY * joyY) * maxSpeed;

				if ((Math.abs(difference) > TURNSENS) && (joyX != 0 || joyY != 0)) {
					if (Math.sin(difference) > 0) {
						if (Math.sin(difference) > Math.sin(Math.PI)) {
							rotation = maxRotation;
						} else {
							rotation = maxRotation * Math.sin(difference);
						}
					} else {
						if (Math.sin(difference) < Math.sin(-Math.PI)) {
							rotation = -maxRotation;
						} else {
							rotation = maxRotation * Math.sin(difference);
						}
					}
				}

				double totalSpeed = Math.abs(speed) + Math.abs(rotation);
				if (totalSpeed > maxSpeed) {
					speed = maxSpeed * speed / totalSpeed;
					rotation = maxSpeed * rotation / totalSpeed;
				}
				// rampSpeed (speed, prevSpd);
				for (int i = 0; i < RobotMap.MAXWheels; i++) {
					RobotMap.wheels[i].driveWheel(stickAngle, robotAngle, 0.0, 0.0);
				}
				prevSpd = speed;
			}
		} else {
			double angle = 0;
			double povSpeed;
			if (Robot.oi.driver.getPOV() == 90 || Robot.oi.driver.getPOV() == 270) {
				angle = Robot.oi.driver.getPOV() * (Math.PI/180);
				povSpeed = 100.0;
			}
			else if (Robot.oi.driver.getPOV() == 45 || Robot.oi.driver.getPOV() == 135 || Robot.oi.driver.getPOV() == 225 || Robot.oi.driver.getPOV() == 315) {
				povSpeed = 0.0;
			}
			else {
				angle = Robot.oi.driver.getPOV() * (Math.PI/180) + Math.PI;
				povSpeed = 100.0;
			}
			for (int i = 0; i < RobotMap.MAXWheels; i++) {
				RobotMap.wheels[i].driveWheel(angle, 0.0, povSpeed, 0.0);
			}
			SmartDashboard.putNumber("Thing", angle);
			
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

	private double joyAngle(double xValue, double yValue) {
		double angle;
		angle = Math.atan2(yValue, xValue);
		if (angle < 0) {
			angle = angle + 2 * Math.PI;
		}

		return angle;
	}
}