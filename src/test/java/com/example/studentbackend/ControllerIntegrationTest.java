package com.example.studentbackend;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getTest1() throws Exception {

        MvcResult result =  this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students")).andDo(print()).andExpect(status().isOk()).andReturn();
        String resultgot = result.getResponse().getContentAsString();
//        System.out.println(resultgot);
        assertTrue(resultgot.contains("{\"name\":\"faiaz\",\"address\":\"dhaka\",\"student_id\":11805},{\"name\":\"admin\",\"address\":\"adsf\",\"student_id\":123}"));

    }

    @Test
    public void getTest2() throws Exception {

        MvcResult result =  this.mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students")).andDo(print()).andExpect(status().isOk()).andReturn();
        String resultgot = result.getResponse().getContentAsString();
//        System.out.println(resultgot);
        assertTrue(resultgot.contains("{\"name\":\"username\",\"address\":\"dhaka\",\"student_id\":11805},{\"name\":\"admin\",\"address\":\"adsf\",\"student_id\":123}"));

    }

    @Test
    public void postTest() throws Exception{
        this.mockMvc.perform(post("/api/v1/students").content("{\"name\":\"tahiyat\",\"address\":\"dilu\",\"student_id\":\"11506\",\"age\":\"24\",\"role\":\"STUDENT\",\"pass\":\"$2a$12$GMssNL49WfZP9DDvksLRsugNFgoZ4tsRc073GopwbMcebBwHsWvcm\"}")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
