package org.usfirst.frc4230.OCTO;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class Drive {
	static double  prevSpd = 0.01;
	final static double TURNSENS = 0.0872;
	static double targetGyro = 0;
	static double turnDiff;
	static double rotation;
	
	
	public static void octoDrive (double joyX, double joyY, double joyZ, double maxSpeed, double maxRotate, double robotAngle) {
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
    	
    	double stickAngle = joyAngle(joyX,joyY);
    	
    	joyX = joyX * joyX *joyX;
    	joyY = joyY * joyY *joyY;
    	rotation = joyZ * 200;
    	//targetGyro = targetGyro + (1 * joyZ);
 //  robotAngle = robotAngle * (180/Math.PI);
    	//turnDiff = (targetGyro - robotAngle);// * (Math.PI/180);
    	
    	/*if (Math.abs(turnDiff) > TURNSENS) {
    		rotation = (turnDiff /90) * 150;
    	}
    	else {
    		//rotation = 0;
    	}*/
    	
    	/*if ((Math.abs(turnDiff) > TURNSENS)) {
			if (Math.sin(turnDiff) > 0) {
				if (Math.sin(turnDiff) > Math.sin(Math.PI)) {
					rotation = 100;
				} else {
					rotation = 100 * Math.sin(turnDiff);
				}
			} else {
				if (Math.sin(turnDiff) < Math.sin(-Math.PI)) {
					rotation = -100;
				} else {
					rotation = -100 * Math.sin(turnDiff);
				}
			}
		}*/
    	
    	double speed = Math.sqrt(joyX * joyX + joyY * joyY) * maxSpeed;
    	double totalSpeed = Math.abs(speed) + Math.abs(rotation);
		if (totalSpeed > maxSpeed) {
			speed = maxSpeed * speed / totalSpeed;
			rotation = maxSpeed * rotation / totalSpeed;
		}
		//rampSpeed (speed, prevSpd);
		//robotAngle = robotAngle * (Math.PI / 180);
		for (int i = 0; i < RobotMap.MAXWheels; i++) {
    		RobotMap.wheels[i].driveWheel(stickAngle, robotAngle, speed, rotation);
    	}
		SmartDashboard.putNumber("rotation", rotation);
		SmartDashboard.putNumber("turnDiff", turnDiff);
		SmartDashboard.putNumber("Robot Angle", robotAngle);
		prevSpd = speed;
	}
	
    private static double joyAngle (double xValue,double yValue) {
    	double angle;
    	angle = Math.atan2(yValue,  xValue);
    	if (angle < 0) {
    		angle = angle + 2 * Math.PI;
    	}
    	
    	return angle;
    }
    
    public static double rampSpeed (double prevSpeed, double targetSpeed) {
    	final double spinSpeed = 0.3;
    	double moveSpeed;
    	final double rampRate = 1.1;
    	double rampX = 1;
    	double ramp;
    	//Timer.delay(0.0001);
    	if (prevSpeed < targetSpeed) {
			if (prevSpeed > spinSpeed) {
				moveSpeed = targetSpeed;
				rampX = 1;
			}
			else {
				ramp = Math.pow(rampRate, rampX);
				moveSpeed = prevSpeed + ramp * 0.01;
				rampX++;
			}
		}
    	else {
    		moveSpeed = targetSpeed;
    		rampX = 1;
    	}
    	
    	return moveSpeed;
    }

}
