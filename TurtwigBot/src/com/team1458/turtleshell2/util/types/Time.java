package com.team1458.turtleshell2.util.types;

/**
 * Unit-extending class representing an interval of time
 * @author mehnadnerd
 *
 */
public class Time implements Unit {
	private final double value;

	/**
	 * Create a time, with the amount in seconds
	 */
	public Time(double seconds) {
		value = seconds;
	}

	@Override
	public double getValue() {
		return value;
	}
}
