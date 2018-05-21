package org.javaee7.test.wildfly.maven.plugin.jaxrs;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;


@ApplicationPath("webresources")
public class MyApplication extends Application {
}