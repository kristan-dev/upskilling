package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.springboot.controller.RestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Application;


@SpringBootTest
public class ApplicationTests extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(RestService.class);
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllStudentsTest() {
		Response response = target("students").request().get(Response.class);
		Assert.assertEquals(response.getStatus(), "OK");
	}
}
