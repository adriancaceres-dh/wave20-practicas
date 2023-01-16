package com.socialMeli.be_java_hisp_w20_g03.integration;

import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getFollowedCount()throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count",234))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("followers_count").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("user_id").value(234))
                .andExpect(MockMvcResultMatchers.jsonPath("user_name").value("usuario1"));
    }
}
