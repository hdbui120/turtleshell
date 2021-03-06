package org.usfirst.frc.team1458.robot;

import com.team1458.turtleshell.pid.TurtlePDD2Constants;
import com.team1458.turtleshell.pid.TurtlePIDConstants;

public class TurtwigConstants {
	public static final int RJOYSTICKPORT = 0;
	public static final int LJOYSTICKPORT = 1;
	public static final int BUTTONPANELPORT = 2;

	public static final int LEFT1VICTORPORT = 2;
	public static final int LEFT2VICTORPORT = 3;
	public static final int RIGHT1VICTORPORT = 5;
	public static final int RIGHT2VICTORPORT = 7;

	public static final int LEFTINTAKEVICTORPORT = 4;
	public static final int RIGHTINTAKEVICTORPORT = 9;//labelled 6
	public static final int SPININTAKETALONPORT = 1;

	public static final int POWERWINCHVICTORPORT = 8;
	public static final int HOOKWINCHTALONPORT = 0;

	public static final int LEFTENCODERPORT1 = 2;
	public static final int LEFTENCODERPORT2 = 3;
	public static final int RIGHTENCODERPORT1 = 0;
	public static final int RIGHTENCODERPORT2 = 1;

	public static final int LEFTINTAKEENCODERPORT1 = 6;
	public static final int LEFTINTAKEENCODERPORT2 = 7;
	public static final int RIGHTINTAKEENCODERPORT1 = 10;
	public static final int RIGHTINTAKEENCODERPORT2 = 11;

	// public static final int POWERWINCHENCODERPORT1 = 8;
	// public static final int POWERWINCHENCODERPORT2 = 9;
	public static final int HOOKWINCHENCODERPORT1 = 4;
	public static final int HOOKWINCHENCODERPORT2 = 5;

	public static final int INTAKETOPLIMITPORT = 25;
	
	public static final int BALLLIMITSWITCHPORT = 8;

	public static final TurtlePIDConstants straightConstants = new TurtlePDD2Constants(.00325, .001, .00008);
	
	public static final double straightPIDkLR = 0.0005;
	
	public static final TurtlePIDConstants turnConstants = new TurtlePDD2Constants(.008, .00035, .00045);
	public static final TurtlePIDConstants turnGyroConstants = new TurtlePDD2Constants(.015, .00035, .0004);

	public static final TurtlePIDConstants intakePIDConstants = new TurtlePDD2Constants(.05, .01, .0003);

	public static final double intakePIDkLR = 0.001;

	public static final TurtlePIDConstants hookRaiseConstants = new TurtlePDD2Constants(.008, .00035, .00045);
	public static final TurtlePIDConstants hookLowerConstants = new TurtlePDD2Constants(.008, .00035, .00045);
	public static final TurtlePIDConstants robotRaiseConstants = new TurtlePDD2Constants(.008, .002, .001);

	public static final double drivePIDTolerance = 20;
	public static final double hookPIDTolerance = 150;

	public static final double hookLiftEncoderTicks = 8360;
	public static final double hookDownEncoderTicks = 2046;
	// public static final double robotLiftEncoderTicks = 100;

	public static final double cameraHeight = 8;
	/**
	 * Elevation of camera in radians
	 */
	public static final double cameraAngle = 0;

	public static final double WHEELDIAMETER = 3.5;
	public static final double WHEELBASE = 24.70;
	/**
	 * In degrees
	 */
	public static final double roughTerrainFlatAngle = 5;

	/**
	 * In seconds
	 */
	public static final double roughTerrainMinFlatTime = 0.2;
	public static final double unfoldTime = .1;

	//public static final double INTAKEENCODERMAX = 250;
	public static final double yankTime = .3;
	public static final double intakePIDScale = 100;
	
	public static final double intakePIDCurrentWeight = .75;
	public static final double INTAKEENCODERMAX = 300;
	public static final double INTAKEENCODERMIN = -50;

	// Constructor so can't be initialised
	private TurtwigConstants() {
	};
}