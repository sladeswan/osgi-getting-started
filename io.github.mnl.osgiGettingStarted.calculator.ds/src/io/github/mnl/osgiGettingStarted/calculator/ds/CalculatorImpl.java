/**
 * 
 */
package io.github.mnl.osgiGettingStarted.calculator.ds;

import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import io.github.mnl.osgiGettingStarted.calculator.Calculator;

@Component(property = Constants.SERVICE_VENDOR + "=Michael N. Lipp",
		configurationPolicy = ConfigurationPolicy.REQUIRE)
public class CalculatorImpl implements Calculator {

	@Override
	public double add(double a, double b) {
		return a + b;
	}

}
