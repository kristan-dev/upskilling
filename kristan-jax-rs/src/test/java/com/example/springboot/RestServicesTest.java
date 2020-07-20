package com.example.springboot;

import com.example.springboot.controller.RestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Application;

public class RestServicesTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(RestService.class);
    }

    @Test
    public void getAllStudentsTest() {
        Response response = target("students").request().get(Response.class);
        Assert.assertEquals(response.getStatus(), 200);
    }
}
