// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc4230.OCTO;

import org.usfirst.frc4230.OCTO.ADIS16448_IMU;
import org.usfirst.frc4230.OCTO.OmniWheel;
import org.usfirst.frc4230.OCTO.commands.Calibrate;

import com.ctre.CANTalon.FeedbackDevice;
import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Preferences;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static CANTalon driveTrainWheel0;
    public static CANTalon driveTrainWheel45;
    public static CANTalon driveTrainWheel135;
    public static CANTalon driveTrainWheel180;
    public static CANTalon driveTrainWheel225;
    public static CANTalon driveTrainWheel315;
    public static CANTalon shooterFlyWheel;
    public static Servo shooterRightActuate;
    public static Servo shooterLeftActuate;
    public static CANTalon shooterFeeder;
    public static Servo gearFlappersFrontFlap;
    public static Servo gearFlappersBackFlap;
    public static Relay gearFlappersLight;
    public static DigitalInput gearFlappersPeg;
    public static CANTalon climberClimber;
    public static SpeedController intakeIntakeSpinner;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static ADIS16448_IMU adiGyro;
	//public static ADXRS450_Gyro gyro;
	public static OmniWheel[] wheels;
	public static Preferences pref;
	public final static int ramp = 1;
	public static final int MAXWheels = 6;
	static boolean brake = true;

	public static void init() {
		try {
			pref = Preferences.getInstance();
			// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainWheel0 = new CANTalon(4);
        LiveWindow.addActuator("DriveTrain", "Wheel0", driveTrainWheel0);
        
        driveTrainWheel45 = new CANTalon(2);
        LiveWindow.addActuator("DriveTrain", "Wheel45", driveTrainWheel45);
        
        driveTrainWheel135 = new CANTalon(5);
        LiveWindow.addActuator("DriveTrain", "Wheel135", driveTrainWheel135);
        
        driveTrainWheel180 = new CANTalon(8);
        LiveWindow.addActuator("DriveTrain", "Wheel180", driveTrainWheel180);
        
        driveTrainWheel225 = new CANTalon(6);
        LiveWindow.addActuator("DriveTrain", "Wheel225", driveTrainWheel225);
        
        driveTrainWheel315 = new CANTalon(1);
        LiveWindow.addActuator("DriveTrain", "Wheel315", driveTrainWheel315);
        
        shooterFlyWheel = new CANTalon(9);
        LiveWindow.addActuator("Shooter", "FlyWheel", shooterFlyWheel);
        
        shooterRightActuate = new Servo(2);
        LiveWindow.addActuator("Shooter", "RightActuate", shooterRightActuate);
        
        shooterLeftActuate = new Servo(3);
        LiveWindow.addActuator("Shooter", "LeftActuate", shooterLeftActuate);
        
        shooterFeeder = new CANTalon(7);
        LiveWindow.addActuator("Shooter", "Feeder", shooterFeeder);
        
        gearFlappersFrontFlap = new Servo(9);
        LiveWindow.addActuator("GearFlappers", "FrontFlap", gearFlappersFrontFlap);
        
        gearFlappersBackFlap = new Servo(7);
        LiveWindow.addActuator("GearFlappers", "BackFlap", gearFlappersBackFlap);
        
        gearFlappersLight = new Relay(0);
        LiveWindow.addActuator("GearFlappers", "Light", gearFlappersLight);
        
        gearFlappersPeg = new DigitalInput(0);
        LiveWindow.addSensor("GearFlappers", "Peg", gearFlappersPeg);
        
        climberClimber = new CANTalon(10);
        LiveWindow.addActuator("Climber", "Climber", climberClimber);
        
        intakeIntakeSpinner = new Talon(1);
        LiveWindow.addActuator("Intake", "IntakeSpinner", (Talon) intakeIntakeSpinner);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        
        RobotMap.shooterLeftActuate.set(0.25);
        RobotMap.shooterRightActuate.set(0.25);
        
        shooterFlyWheel.setFeedbackDevice(FeedbackDevice.QuadEncoder);
        shooterFlyWheel.changeControlMode(TalonControlMode.Speed);
        shooterFlyWheel.configNominalOutputVoltage(+0.0f, -0.0f);
        shooterFlyWheel.configPeakOutputVoltage(+12.0f, -12.0f);
        shooterFlyWheel.configEncoderCodesPerRev(1024);
        shooterFlyWheel.setProfile(0);
        shooterFlyWheel.setInverted(true);
        shooterFlyWheel.setF(-0.0258);
        shooterFlyWheel.setP(-0.0272);
        shooterFlyWheel.setI(-0.01);
        shooterFlyWheel.setD(-0.05);

			adiGyro = new ADIS16448_IMU();
			//adiGyro.calibrate();
			//gyro = new ADXRS450_Gyro();
			

			driveTrainWheel0.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel0.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel0.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel0.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel0.configEncoderCodesPerRev(1024);
			driveTrainWheel0.setProfile(0);
			driveTrainWheel0.setF(0.23);
			driveTrainWheel0.setP(0.17);
			driveTrainWheel0.setI(0.001);
			driveTrainWheel0.setD(5.0);
			driveTrainWheel0.enableBrakeMode(brake);
			driveTrainWheel0.EnableCurrentLimit(true);
			driveTrainWheel0.setCurrentLimit(33);
			

			driveTrainWheel45.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel45.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel45.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel45.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel45.configEncoderCodesPerRev(1024);
			driveTrainWheel45.setProfile(0);
			driveTrainWheel45.setF(0.23);
			driveTrainWheel45.setP(0.17);
			driveTrainWheel45.setI(0.001);
			driveTrainWheel45.setD(5.0); 
			driveTrainWheel45.enableBrakeMode(brake);
			driveTrainWheel45.EnableCurrentLimit(true);
			driveTrainWheel45.setCurrentLimit(33);
			

			/*driveTrainWheel90.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel90.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel90.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel90.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel90.configEncoderCodesPerRev(1024);
			driveTrainWheel90.setProfile(0);
			driveTrainWheel90.setF(0.23);
			driveTrainWheel90.setP(0.17);
			driveTrainWheel90.setI(0.001);
			driveTrainWheel90.setD(5.0);
			driveTrainWheel90.enableBrakeMode(brake);*/
			

			driveTrainWheel135.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel135.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel135.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel135.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel135.configEncoderCodesPerRev(1024);
			driveTrainWheel135.setProfile(0);
			driveTrainWheel135.setF(0.23);
			driveTrainWheel135.setP(0.17);
			driveTrainWheel135.setI(0.001);
			driveTrainWheel135.setD(5.0);
			driveTrainWheel135.enableBrakeMode(brake);
			driveTrainWheel135.EnableCurrentLimit(true);
			driveTrainWheel135.setCurrentLimit(33);

			driveTrainWheel180.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel180.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel180.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel180.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel180.configEncoderCodesPerRev(1024);
			driveTrainWheel180.setProfile(0);
			driveTrainWheel180.setF(0.23);
			driveTrainWheel180.setP(0.17);
			driveTrainWheel180.setI(0.001);
			driveTrainWheel180.setD(5.0);
			driveTrainWheel180.enableBrakeMode(brake);
			driveTrainWheel180.EnableCurrentLimit(true);
			driveTrainWheel180.setCurrentLimit(33);
			

			driveTrainWheel225.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel225.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel225.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel225.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel225.configEncoderCodesPerRev(1024);
			driveTrainWheel225.setProfile(0);
			driveTrainWheel225.setF(0.23);
			driveTrainWheel225.setP(0.17);
			driveTrainWheel225.setI(0.001);
			driveTrainWheel225.setD(5.0);
			driveTrainWheel225.enableBrakeMode(brake);
			driveTrainWheel225.EnableCurrentLimit(true);
			driveTrainWheel225.setCurrentLimit(33);
		

			/*driveTrainWheel270.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel270.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel270.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel270.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel270.configEncoderCodesPerRev(1024);
			driveTrainWheel270.setProfile(0);
			driveTrainWheel270.setF(0.23);
			driveTrainWheel270.setP(0.17);
			driveTrainWheel270.setI(0.001);
			driveTrainWheel270.setD(5.0);
			driveTrainWheel270.enableBrakeMode(brake);*/
			

			driveTrainWheel315.setFeedbackDevice(FeedbackDevice.QuadEncoder);
			driveTrainWheel315.changeControlMode(TalonControlMode.Speed);
			driveTrainWheel315.configNominalOutputVoltage(+0.0f, -0.0f);
			driveTrainWheel315.configPeakOutputVoltage(+12.0f, -12.0f);
			driveTrainWheel315.configEncoderCodesPerRev(1024);
			driveTrainWheel315.setProfile(0);
			driveTrainWheel315.setF(0.23);
			driveTrainWheel315.setP(0.17);
			driveTrainWheel315.setI(0.001);
			driveTrainWheel315.setD(5.0);
			driveTrainWheel315.enableBrakeMode(brake);
			driveTrainWheel315.EnableCurrentLimit(true);
			driveTrainWheel315.setCurrentLimit(33);
			

			wheels = new OmniWheel[MAXWheels];
			wheels[0] = new OmniWheel(driveTrainWheel0, 0.0, 0.793);
			wheels[1] = new OmniWheel(driveTrainWheel45, 45.0, 0.845);
			//wheels[2] = new OmniWheel(driveTrainWheel90, 90.0, 0.828);
			wheels[2] = new OmniWheel(driveTrainWheel135, 135.0, 0.914);
			wheels[3] = new OmniWheel(driveTrainWheel180, 180.0, 0.845);
			wheels[4] = new OmniWheel(driveTrainWheel225, 225.0, 1.0);
			//wheels[6] = new OmniWheel(driveTrainWheel270, 270.0, 0.914);
			wheels[5] = new OmniWheel(driveTrainWheel315, 315.0, 0.879);
			
			//calibrateTrig.whenActive(new Calibrate());
			SmartDashboard.putData("Calibrate", new Calibrate());
	//		SmartDashboard.putData("Calibrate", calibrateTrig);

			
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			// throw ex;
		}
	}
}
