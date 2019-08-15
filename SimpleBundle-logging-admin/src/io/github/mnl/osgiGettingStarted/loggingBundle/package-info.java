/**
 * @startuml
 * skinparam componentStyle uml2
 * 
 * package "OSGI Services" {
 *     [LogServiceImpl] -left- ConfigurationListener 
 *     [LogServiceImpl] -down- LogService
 *     [ConfigurationAdminImpl] -right-> ConfigurationListener : sends info >
 *     [ConfigurationAdminImpl] -down- ConfigurationAdmin
 * }
 * package "Simple Bundle" {
 *     [HelloWorldApp] -up-> LogService : "sends log messages"
 * }
 * 
 * package "GoGo Shell" {
 *     [GoGoShell] -up-> ConfigurationAdmin
 * }
 * 
 * @enduml
 */
package io.github.mnl.osgiGettingStarted.loggingBundle;

