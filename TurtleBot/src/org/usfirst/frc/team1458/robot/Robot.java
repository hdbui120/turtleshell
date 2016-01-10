
package org.usfirst.frc.team1458.robot;

import edu.wpi.first.wpilibj.SampleRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends SampleRobot {
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	SendableChooser chooser;

	public Robot() {

	}

	public void robotInit() {
		chooser = new SendableChooser();
		chooser.addDefault("Default Auto", defaultAuto);
		chooser.addObject("My Auto", customAuto);
		SmartDashboard.putData("Auto modes", chooser);
	}

	public void autonomous() {

		String autoSelected = (String) chooser.getSelected();
		// String autoSelected = SmartDashboard.getString("Auto Selector",
		// defaultAuto);
		System.out.println("Auto selected: " + autoSelected);

	}

	/**
	 * Runs the motors with arcade steering.
	 */
	public void operatorControl() {

	}

	/**
	 * Runs during test mode
	 */
	public void test() {
		
	}
}
