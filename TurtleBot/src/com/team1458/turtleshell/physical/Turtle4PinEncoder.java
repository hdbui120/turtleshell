package com.team1458.turtleshell.physical;

import com.team1458.turtleshell.sensor.TurtleEncoder;

import edu.wpi.first.wpilibj.Encoder;

/**
 * A wrapper for standard encoders to get them to implement TurtleEncoder.
 * @author mehnadnerd
 *
 */
public class Turtle4PinEncoder implements TurtleEncoder {
	private Encoder encoder;
	private boolean isReversed;

	public Turtle4PinEncoder(int aChannel, int bChannel) {
		encoder = new Encoder(aChannel, bChannel);
		encoder.setDistancePerPulse(1.0);
	}
	public Turtle4PinEncoder(int aChannel, int bChannel, boolean isReversed) {
		this(aChannel, bChannel);
		this.isReversed=isReversed;
	}
	@Override
	public int getTicks() {
		return (isReversed ? -1 : 1) * encoder.get();
	}

	@Override
	public double getRate() {
		return (isReversed ? -1 : 1) * encoder.getRate();
	}

	@Override
	public void reset() {
		encoder.reset();
	}
	@Override
	public boolean isReversed() {
		return isReversed();
	}
	@Override
	public void update() {

	}
}
