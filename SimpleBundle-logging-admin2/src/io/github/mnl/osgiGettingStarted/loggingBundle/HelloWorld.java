/**
 * 
 */
package io.github.mnl.osgiGettingStarted.loggingBundle;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Optional;

import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;
import org.osgi.service.log.LogService;

/**
 * @author mnl
 *
 */
public class HelloWorld extends Thread implements ManagedService {

    private long waitTime;
    
    public HelloWorld(BundleContext context) {
        // Register this class as managed service. The class does not
        // provide a service, but this doesn't matter. The important
        // point is that it is to be managed by Configuration Admin.
        //
        // Registration will cause update to be called (sooner or later).
        Dictionary<String, Object> properties = new Hashtable<>();
        properties.put( Constants.SERVICE_PID, HelloWorld.class.getName());        
        context.registerService(ManagedService.class, this, properties);
    }

    @Override
    public void updated(Dictionary<String, ?> properties)
            throws ConfigurationException {
        // Get the value. properties may be null if no configuration
        // object has been created yet. And even if it has been
        // created, there may be no entry for waitTime in it (yet).
        waitTime = Optional.ofNullable(properties)
            .map(props -> (Long)props.get("waitTime")).orElse(5000L);
        if (!isAlive()) {
            start();
            Activator.logService.log(LogService.LOG_INFO, "Hello World started.");
        }
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            try {
                System.out.println("Hello World!");
                Activator.logService.log(LogService.LOG_INFO, "Hello Word sleeping");
                sleep (waitTime);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
    
}
