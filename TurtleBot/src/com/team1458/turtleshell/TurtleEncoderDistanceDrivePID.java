package com.team1458.turtleshell;

public class TurtleEncoderDistanceDrivePID extends TurtlePID {
	protected final int dist;
	protected final double kLRP;

	/**
	 * Create a new TurtleEncoderDIstanceDrivePID.
	 * 
	 * @param kP
	 *            constant for proportional
	 * @param kD
	 *            constant for derivative
	 * @param kLRP
	 *            constant for left-right ratio (proportional)
	 * @param dist
	 */
	public TurtleEncoderDistanceDrivePID(double kP, double kD, double kLRP, int dist) {
		super(kP, 0, kD);
		this.kLRP = kLRP;
		this.dist = dist;
	}

	/**
	 * This no longer makes sense in this context, this override will simply
	 * return 0.
	 */
	@Override
	public double simplePID(double value, double integralvalue, double derivativevalue, double target,
			double integraltarget, double derivativetarget) {
		return 0;
	}

	// error = encoder-dist
	public double[] getP(int lEncoder, int rEncoder) {

		return new double[] { kP * (lEncoder - dist) - kLRP * (lEncoder - rEncoder),
				kP * (rEncoder - dist) + kLRP * (lEncoder - rEncoder) };
	}

	public double[] getPD(int lEncoder, double lEncoderRate, int rEncoder, double rEncoderRate) {
		return new double[] { kP * (lEncoder - dist) - kD * lEncoderRate - kLRP * (lEncoder - rEncoder),
				kP * (rEncoder - dist) - kD * rEncoderRate + kLRP * (lEncoder - rEncoder) };
	}

}