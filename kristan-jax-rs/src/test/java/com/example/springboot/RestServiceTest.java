package com.example.springboot;

import com.example.springboot.controller.RestService;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

public class RestServiceTest extends JerseyTest
{
    @Override
    protected Application configure() {
        return new ResourceConfig(RestService.class);
    }

    @Test
    public void getAllStudentsTest() {
        Response response = target("students").request().get(Response.class);
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void getTestTest() {
        Response response = target("students/get").request().get(Response.class);
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void postTestTes() {
        Response response = target("students/post").request().get(Response.class);
        Assert.assertTrue(response.getStatus() == 200);
    }

    public void putTestTest() {
        Response response = target("students/put").request().get(Response.class);
        Assert.assertTrue(response.getStatus() == 200);
    }
}
