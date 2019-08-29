/**
 * 
 */
package io.github.mnl.osgiGettingStarted.calculator.ds;

import org.osgi.service.component.annotations.Component;

import io.github.mnl.osgiGettingStarted.calculator.Calculator;

@Component
public class CalculatorImpl implements Calculator {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

}
