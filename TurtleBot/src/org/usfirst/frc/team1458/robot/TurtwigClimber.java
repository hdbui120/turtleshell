package org.usfirst.frc.team1458.robot;

import com.team1458.turtleshell.Input;
import com.team1458.turtleshell.Input.XboxButton;
import com.team1458.turtleshell.MotorValue;
import com.team1458.turtleshell.TurtleEncoder;
import com.team1458.turtleshell.TurtleMotor;
import com.team1458.turtleshell.TurtleRobotComponent;
import com.team1458.turtleshell.TurtleSolenoid;
import com.team1458.turtleshell.physical.Turtle4PinEncoder;
import com.team1458.turtleshell.physical.TurtleElectricalSolenoid;
import com.team1458.turtleshell.physical.TurtleVictor;
import com.team1458.turtleshell.pid.TurtleDualPID;

import edu.wpi.first.wpilibj.Timer;

public class TurtwigClimber implements TurtleRobotComponent {
	private TurtleMotor powerWinch = new TurtleVictor(TurtwigConstants.POWERWINCHVICTORPORT, false);
	private TurtleMotor hookWinch = new TurtleVictor(TurtwigConstants.HOOKWINCHVICTORPORT, false);

	private TurtleEncoder powerEncoder = new Turtle4PinEncoder(TurtwigConstants.POWERWINCHENCODERPORT1,
			TurtwigConstants.POWERWINCHENCODERPORT2, false);
	private TurtleEncoder hookEncoder = new Turtle4PinEncoder(TurtwigConstants.HOOKWINCHENCODERPORT1,
			TurtwigConstants.HOOKWINCHENCODERPORT2, false);

	private TurtleSolenoid folder = new TurtleElectricalSolenoid(TurtwigConstants.SOLENOIDPORT);

	private TurtleDualPID pid;

	private Timer unfoldTimer = new Timer();

	private ClimberState state = ClimberState.FOLDED;
	
	private final double unfoldTime = 1.0;

	private enum ClimberState {
		FOLDED, UNFOLDING, UNFOLDED, RAISING, RAISED, CLIMBING, CLIMBED
	}

	@Override
	public void init() {
		folder.set(false);

	}

	@Override
	public void teleUpdate() {
		// read user input and change state if necessary
		if (Input.getXboxButton(XboxButton.Y)) {
			switch (state) {
			case FOLDED:
				this.state = ClimberState.UNFOLDING;
				folder.set(true);
				unfoldTimer.start();
				break;
			case RAISED:
				this.state = ClimberState.CLIMBING;
				break;
			default:
				break;
			}
		}
		// execute actions for state change
		if (pid != null) {
			driveMotors(pid.newValue(new double[] { powerEncoder.getTicks(), hookEncoder.getTicks(),
					powerEncoder.getRate(), hookEncoder.getRate() }));
		}

		// check if move to new state
		switch (state) {
		case UNFOLDING:
			if (unfoldTimer.get() > unfoldTime) {
				state = ClimberState.UNFOLDED;
				unfoldTimer.stop();
			}
			break;
		case UNFOLDED: 
			state = ClimberState.RAISING;
			break;
		case RAISING:
			break;
		case CLIMBING:
			break;
		default:
			break;
		}
	}

	/**
	 * Power, hook
	 * 
	 * @param v
	 */
	private void driveMotors(MotorValue[] v) {
		powerWinch.set(v[0]);
		hookWinch.set(v[1]);
	}

	@Override
	public void stop() {
		powerWinch.stop();
		hookWinch.stop();
	}

}
