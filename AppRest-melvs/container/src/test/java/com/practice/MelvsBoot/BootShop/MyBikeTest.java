package com.practice.MelvsBoot.BootShop;

import com.practice.MelvsBoot.BootShop.repository.MyAccessoriesService;
import com.practice.MelvsBoot.BootShop.repository.MyBikeService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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

//    @Test
//        public void testbike () throws Exception {
//        mockMvc.perform(get("/Bike")).andExpect(status().isOk())
//                // .andExpect(jsonPath("$[0].ID").value("asd013"))
//                .andExpect(jsonPath("$[0].Brand").value("Bianchi"))
//                .andExpect(jsonPath("$[0].FrameSize").value("27er"))
//                .andExpect(jsonPath("$[0].Wheel").value("27"))
//                .andExpect(jsonPath("$[0].Speed").value("3x9"));
//    }

    @Test
    public void getBikeTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/Bike"))
                .andExpect(status().isOk());
    }

    @Test
    public void getAccessoriesTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/Accessories"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPostTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/PostEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPutTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/PutEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getPatchTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/DeletehEnd"))
                .andExpect(status().isOk());
    }

    @Test
    public void getDeleteTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:7224/PatchEnd"))
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
}

