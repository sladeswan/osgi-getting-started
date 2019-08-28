/**
 * 
 */
package io.github.mnl.osgiGettingStarted.calculator.provider;

import io.github.mnl.osgiGettingStarted.calculator.Calculator;

public class CalculatorImpl implements Calculator {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

}
