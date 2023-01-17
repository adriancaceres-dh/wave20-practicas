package com.bootcamp.be_java_hisp_w20_g7.service;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils.userFollowersCountDto;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testNameSorayaOutput() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", "1"))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_name").value("Sebastian"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(0));

    }


}
