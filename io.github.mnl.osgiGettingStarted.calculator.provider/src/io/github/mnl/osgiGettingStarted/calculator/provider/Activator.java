package io.github.mnl.osgiGettingStarted.calculator.provider;

import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;

import io.github.mnl.osgiGettingStarted.calculator.Calculator;

public class Activator implements BundleActivator {

	private ServiceRegistration<Calculator> publishedService;
	
	@Override
	public void start(BundleContext context) throws Exception {
		publishedService = context.registerService(
			Calculator.class, new CalculatorImpl(),
			new Hashtable<>(
					Map.of(Constants.SERVICE_VENDOR, "Michael N. Lipp")));
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		publishedService.unregister();
	}

}
