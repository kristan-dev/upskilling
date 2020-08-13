package com.example.springboot;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
public class RestServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getStudentsTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:8080/students"))
                .andExpect(status().isOk());
    }

    @Test
    public void getProgramsTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:8080/programs"))
                .andExpect(status().isOk());
    }

    @Test
    public void getTestTest() throws Exception {
        this.mockMvc.perform(
                get("http://localhost:8080/students/get"))
                .andExpect(status().isOk());
    }

    @Test
    public void postTestTest() throws Exception {

        Map<String, String> jsonInput = new HashMap<>();
        jsonInput.put("key1", "value1");
        jsonInput.put("key2", "value2");

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(jsonInput);

        this.mockMvc.perform(MockMvcRequestBuilders
                .post("http://localhost:8080/students/post")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void putTestTest() throws Exception {

        Map<String, String> jsonInput = new HashMap<>();
        jsonInput.put("key1", "value1");
        jsonInput.put("key2", "value2");

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(jsonInput);

        this.mockMvc.perform(MockMvcRequestBuilders
                .put("http://localhost:8080/students/put")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void patchTestTest() throws Exception {

        Map<String, String> jsonInput = new HashMap<>();
        jsonInput.put("key1", "value1");
        jsonInput.put("key2", "value2");

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(jsonInput);

        this.mockMvc.perform(MockMvcRequestBuilders
                .patch("http://localhost:8080/students/patch")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteTestTest() throws Exception {

        Map<String, String> jsonInput = new HashMap<>();
        jsonInput.put("key1", "value1");
        jsonInput.put("key2", "value2");

        ObjectMapper mapper = new ObjectMapper();
        String requestBody = mapper.writeValueAsString(jsonInput);

        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("http://localhost:8080/students/delete")
                .content(requestBody)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
