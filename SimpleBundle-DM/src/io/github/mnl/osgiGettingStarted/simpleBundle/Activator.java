package io.github.mnl.osgiGettingStarted.simpleBundle;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import org.osgi.service.log.LogService;

public class Activator extends DependencyActivatorBase {
	
	public void init(BundleContext context, DependencyManager manager)
			throws Exception {
		manager.add(
			createComponent()
			.setImplementation(HelloWorld.class)
			.add(
				createServiceDependency()
				.setService(LogService.class)
				.setRequired(true)
			)
		);
	}
}
