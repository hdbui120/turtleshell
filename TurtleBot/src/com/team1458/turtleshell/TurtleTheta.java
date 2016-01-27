package com.team1458.turtleshell;

public interface TurtleTheta extends TurtleSensor {
	/**
	 * Get Continous theta, 
	 * @return Angle in degrees, continous
	 */
	public double getContinousTheta();
	
	/**
	 * get the rate, in degrees/second
	 */
	public double getRate();
	/**
	 * Reset the measurement
	 */
	public void reset();
}