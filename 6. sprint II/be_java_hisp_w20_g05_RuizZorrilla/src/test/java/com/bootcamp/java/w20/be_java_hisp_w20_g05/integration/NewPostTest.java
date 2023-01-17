package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;


import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.ProductRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.PostRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class NewPostTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    PostRepository repo;

    @Test
    public void newPostTest_InvalidDto() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();


        PostRequestDTO requestObject = new PostRequestDTO();
        String payload = writer.writeValueAsString(requestObject);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post").content(payload).contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"));

    }
    @Test
    public void newPostTest_Ok() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer().withDefaultPrettyPrinter();


        PostRequestDTO requestObject = new PostRequestDTO(2, LocalDate.now(), new ProductRequestDTO(1, "aProduct", "aTyoe", "aBrand", "aColour", "notes"),3, 12.3);
        String payload = writer.writeValueAsString(requestObject);

        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post").content(payload).contentType("application/json"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(jsonPath("$.user_id").value(requestObject.getUserId()))
                .andExpect(jsonPath("$.date").value(LocalDate.now().toString()))
                .andExpect(jsonPath("$.category").value(requestObject.getCategory()))
                .andExpect(jsonPath("$.price").value(requestObject.getPrice()))
                .andExpect(jsonPath("$.product.type").value(requestObject.getProduct().getType()))
                .andExpect(jsonPath("$.product.brand").value(requestObject.getProduct().getBrand()))
                .andExpect(jsonPath("$.product.color").value(requestObject.getProduct().getColor()))
                .andExpect(jsonPath("$.product.notes").value(requestObject.getProduct().getNotes()));



    }

}
