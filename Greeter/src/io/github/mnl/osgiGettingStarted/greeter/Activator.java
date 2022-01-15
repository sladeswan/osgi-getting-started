package io.github.mnl.osgiGettingStarted.greeter;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedServiceFactory;

public class Activator implements BundleActivator, ManagedServiceFactory {

    ServiceRegistration<ManagedServiceFactory> registration;
    Map<String, String> instances = new HashMap<>();
    
    @Override
    public void start(BundleContext context) throws Exception {
        registration = context.registerService(
                ManagedServiceFactory.class, this, new Hashtable<>(
                Map.of(Constants.SERVICE_PID, "GreeterFactory")));
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
    }

    @Override
    public String getName() {
        return "Greeter";
    }

    @Override
    public void updated(String pid, Dictionary<String, ?> properties)
            throws ConfigurationException {
        String text = (String)properties.get("text");
        if (!instances.containsKey(pid)) {
            // It's new.
            instances.put(pid, text);
            System.out.println("New Greeter \"" + pid + "\" says: " + text);
        } else {
            instances.put(pid, text);
            System.out.println("Greeter \"" + pid + "\" now says: " + text);
        }
    }

    @Override
    public void deleted(String pid) {
        instances.remove(pid);
        System.out.println("Greeter \"" + pid + "\" has been removed");
    }

    
    
}
