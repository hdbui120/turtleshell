package com.team1458.turtleshell;

public interface TurtleServo {
	/**
	 * Get the angle of the servo
	 * @return Angle in degrees
	 */
	public double getAngle();
	/**
	 * Set angle of the servo, in degrees
	 */
	public void setAngle(double angle);
}
