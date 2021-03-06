package com.team1458.turtleshell2.implementations.input;

import edu.wpi.first.wpilibj.Joystick;

public class TurtleXboxController {
	private Joystick j;

	public TurtleXboxController(int usbport) {
		j = new Joystick(usbport);
	}

	public static enum XboxButton {
		A(1), B(2), X(3), Y(4), LBUMP(5), RBUMP(6), SELECT(7), START(8), LSTICK(9), RSTICK(10);
		public final int val;

		XboxButton(int i) {
			val = i;
		}
	}

	public static enum XboxAxis {
		LX(0), LY(1), LT(2), RT(3), RX(4), RY(5),;
		public final int val;

		XboxAxis(int i) {
			val = i;
		}
	}

	public TurtleJoystickAxis getAxis(XboxAxis a) {
		if(a==XboxAxis.LY||a==XboxAxis.RY) {
			return new TurtleJoystickAxis(j, a.val,true);
		}
		return new TurtleJoystickAxis(j, a.val);
	}

	public TurtleJoystickButton getButton(XboxButton b) {
		return new TurtleJoystickButton(j, b.val);
	}
	
	public TurtleJoystickPOVSwitch getDPad() {
		return new TurtleJoystickPOVSwitch(j,0);
	}
}
