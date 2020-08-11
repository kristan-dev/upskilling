package com.practice.MelvsBoot.BootShop;

import com.practice.MelvsBoot.BootShop.repository.MyAccessoriesService;
import com.practice.MelvsBoot.BootShop.repository.MyBikeService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Test;
import org.junit.Before;


public class MyBikeTest extends BootShopApplicationTests{

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void getBikeTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/page/bikes"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccessoriesTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/page/accessories"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPostTest() throws Exception {
        this.mockMvc.perform(
                post("http://localhost:7224/page/postEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPutTest() throws Exception {
        this.mockMvc.perform(
                put("http://localhost:7224/page/putEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPatchTest() throws Exception {
        this.mockMvc.perform(
                patch("http://localhost:7224/page/patchEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getDeleteTest() throws Exception {
        this.mockMvc.perform(
                delete("http://localhost:7224/page/deleteEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAllAccesories() {
        MyAccessoriesService acctest = new MyAccessoriesService();
        Assert.assertEquals("Available accessories",2, acctest.getAcc().size() );
    }

    @Test
    public void getAllBike() {
        MyBikeService mybiketest = new MyBikeService();
        Assert.assertEquals("Available bikes", 5, mybiketest.getBikeList().size());
    }

    @Test
    public void getAccessoriesTrueTest() {
        MyAccessoriesService myaccessoriestruetest = new MyAccessoriesService();
        Assert.assertTrue("Ok",myaccessoriestruetest.getAcc().size() == 2);
    }

    @Test
    public void getBikeTrueTest() {
        MyBikeService mybiketruetest = new MyBikeService();
        Assert.assertTrue("Ok",mybiketruetest.getBikeList().size() == 5);
    }

}

