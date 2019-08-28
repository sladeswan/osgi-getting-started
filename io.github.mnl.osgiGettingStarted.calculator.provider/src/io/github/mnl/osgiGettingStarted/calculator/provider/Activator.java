package io.github.mnl.osgiGettingStarted.calculator.provider;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import io.github.mnl.osgiGettingStarted.calculator.Calculator;

public class Activator implements BundleActivator {

	private ServiceRegistration<Calculator> publishedService;
	
	@Override
	public void start(BundleContext context) throws Exception {
		publishedService = context.registerService(
				Calculator.class, new CalculatorImpl(), null);
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		publishedService.unregister();
	}

}
