package org.usfirst.frc4230.OCTO;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class OmniWheel {
	
	double wheelAngle = 0.0;
	CANTalon motor;
	double percentRotate;
	
	OmniWheel (CANTalon talon, double angle, double percentRotation) {
		wheelAngle = angle * (Math.PI/180.0);
		motor = talon;
		percentRotate = percentRotation;
	}
	
	public void driveWheel (double driveAngle, double botAngle, double speed, double rotation) {
		
		double moveAngle = driveAngle - botAngle + wheelAngle;
		//String str = "moveSpeed " + motor;
		double targetSpeed = speed * (Math.cos(moveAngle)- Math.cos(3 * moveAngle)* 0.2928) + rotation * percentRotate;
		//double targetSpeed = speed * Math.cos(moveAngle) + rotation * percentRotate;
		motor.set(targetSpeed);
		
		//SmartDashboard.putNumber(str, moveSpeed);
		
		
		
	}
			

}
