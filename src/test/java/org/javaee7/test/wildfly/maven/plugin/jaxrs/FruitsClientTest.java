package org.javaee7.test.wildfly.maven.plugin.jaxrs;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Test;

public class FruitsClientTest {

	private String base="http://127.0.0.1:9990/WildflyMavenPlugin-0.0.1-SNAPSHOT.jar/webresources/fruit";
	private static WebTarget target;

	@Test
	public void shouldContactWebservice() throws MalformedURLException {
		final String aFruit= "Banana";
		Client client = ClientBuilder.newClient();
		target = client.target(URI.create(new URL(base).toExternalForm()));
		target.request().post(Entity.json(aFruit));
		Response response = target.request().get();
		Assert.assertTrue(response.readEntity(String.class).contains(aFruit));
	}

}
