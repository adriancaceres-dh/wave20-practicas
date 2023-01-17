package com.socialmeli.be_java_hisp_w20_g8.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.ErrorDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.SellerDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.UserFollowedDTO;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
class UserControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void testGetFollowed() throws Exception {
        List<SellerDTO> sellerDTOList = List.of(new SellerDTO(5,"seller3")
                ,new SellerDTO(6,"seller4")
                ,new SellerDTO(9,"zxc"));

        UserFollowedDTO userFollowedDTO = new UserFollowedDTO(1,"user1",sellerDTOList);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String userFollowedExpected = writer.writeValueAsString(userFollowedDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(userFollowedExpected,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void testGetFollowedExceptionWrongId() throws Exception {

        ErrorDTO errorDto = new ErrorDTO("Not found exception","Invalid user please check information.");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",11))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void testGetFollowedExceptionWrongPathVariable() throws Exception {

        ErrorDTO errorDto = new ErrorDTO("ConstraintViolationException","El id debe ser mayor a cero");

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",-1))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString());
    }
}
