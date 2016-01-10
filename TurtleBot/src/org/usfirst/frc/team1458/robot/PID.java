package org.usfirst.frc.team1458.robot;

public class PID {
	private final double kP;
	private final double kI;
	private final double kD;
	public PID(double kP, double kI, double kD) {
		this.kP=kP;
		this.kI=kI;
		this.kD=kD;
	}
	/**
	 * A simple PID function, using the k that are created with the object
	 * @return
	 */
	public double singlePID(double value, double integralvalue, double derivativevalue, double target, double integraltarget, double derivativetarget) {
		return kP*(value-target)+kI*(integralvalue-integraltarget)+kD*(derivativevalue-derivativetarget);
	}
}