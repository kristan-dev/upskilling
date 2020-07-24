package com.example.springboot;

import com.example.springboot.controller.RestService;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

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
        Response response = target("/cxf/students").request().get();
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void getTestTest() {
        Response response = target("/cxf/students/get").request().get();
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void postTestTes() {
        Response response = target("/cxf/students/post").request().get();
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void putTestTest() {
        Response response = target("/cxf/students/put").request().get();
        Assert.assertTrue(response.getStatus() == 200);
    }

    @Test
    public void delTestTest() {
        Response response = target("/cxf/students/delete").request().get();
        Assert.assertTrue(response.getStatus() == 200);
    }
}
