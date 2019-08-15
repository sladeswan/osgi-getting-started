/**
 * @startuml
 * skinparam componentStyle uml2
 * 
 * package "OSGI Services" as OSGi {
 *     [LogServiceImpl] -up- ConfigurationListener 
 *     [LogServiceImpl] - LogService
 *     [ConfigurationAdminImpl] --> ConfigurationListener : sends info >
 * }
 * 
 * package "Simple Bundle" as SimpleBundle {
 *     [HelloWorldApp] -left-> LogService : "sends log messages"
 *     [HelloWorldApp] -up- ManagedService
 * }
 * 
 * [ConfigurationAdminImpl] --> ManagedService : "send info"
 * 
 * @enduml
 * 
 * @startuml
 * hide footbox
 * 
 * activate "OSGi Framework"
 * activate "Configuration Admin"
 * "OSGi Framework" -> Activator: start
 * activate Activator
 * Activator -> ServiceTracker ** : create
 * Activator -> ServiceTracker: open
 * deactivate Activator
 * activate ServiceTracker
 * "OSGi Framework" -> ServiceTracker: addService(LogService)
 * ServiceTracker -> HelloWorld ** : create
 * HelloWorld -> "OSGi Framework": register as ManagedService
 * "OSGi Framework" -> "Configuration Admin" : ManagedService registered 
 * "Configuration Admin" -> HelloWorld: update
 * activate HelloWorld
 * HelloWorld -> HelloWorld: start
 * 
 * @enduml
 * 
 */
package io.github.mnl.osgiGettingStarted.loggingBundle;

