package com.bootcamp.be_java_hisp_w20_g2_ambroggio.controller;

import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    void addNewProductOk() throws Exception {
        ProductDTO productDTO = new ProductDTO(120, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        PostDTO postDTO = new PostDTO(1, LocalDate.now(), productDTO, 200, 10000D);
        String payloadJson = writer.writeValueAsString(postDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(120))
                .andReturn();
    }

    @Test
    void sendLastPostOfFollowedOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts").isNotEmpty())
                .andReturn();
    }

    @Test
    void sendLastPostOfFollowedPriceAsc() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .param("order", "price_asc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].price").value(100000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].price").value(120000))
                .andReturn();
    }

    @Test
    void sendLastPostOfFollowedPriceDesc() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                        .param("order", "price_desc"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].post_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].price").value(120000))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[1].price").value(100000))
                .andReturn();
    }

    @Test
    void sendLastPostOfFollowedUserNotFound() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 55))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("The given userId not exist."))
                .andReturn();
    }
}