package com.bootcamp.be_java_hisp_w20_g7.integration;

import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.exception.ExceptionDTO;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class Test_T010_IntegrationTest {

    @Autowired
    MockMvc mockMvc;
    //Test-T010 throws exception if user does not exist
    @Test
    void testNotValidUserFollowers() throws Exception {
        UserFollowersDto userFollowersDto = new UserFollowersDto(2, "Andres",
                new ArrayList<>(List.of(new UserDto(7, "Steven"))));

        ExceptionDTO error = new ExceptionDTO("UserNotFoundException", "User Not Found");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payload = writer.writeValueAsString(userFollowersDto);
        String expected = writer.writeValueAsString(error);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 9)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andReturn();

        assertEquals(expected, mvcResult.getResponse().getContentAsString());
    }
    
}
