package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TestFollowersCount
{
    @Autowired
    private MockMvc mockMvc;

    @DisplayName("Test UserId Followers count - OK")
    @Test
    void testGetFollowersCount() throws Exception
    {
        int userId = 2;
        this.mockMvc.perform(get("/users/"+ userId +"/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(userId));
    }

    @DisplayName("Test UserId Followers count - BAD")
    @Test
    void testGetFollowersCountUserIdInvalid() throws Exception
    {
        int userId = 0;
        this.mockMvc.perform(get("/users/"+ userId +"/followers/count"))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"));
    }


}
