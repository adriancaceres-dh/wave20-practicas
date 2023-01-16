package com.bootcamp.be_java_hisp_w20_g1;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

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
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class integrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldInsertANewPost() throws Exception {

        PostRequestDto payloadDto = new PostRequestDto(); // creamos nuestro objeto dto y empezamos a preparar nuestro payload para enviárselo al método.
        LocalDate fecha = LocalDate.now();
        payloadDto.setDate(fecha);
        payloadDto.setUserId(2);
        ProductRequestDto product = new ProductRequestDto();
        product.setProductId(20);
        product.setProductName("Galletas");
        product.setType("Alimentos");
        product.setBrand("Oreo");
        product.setColor("Marrones");
        product.setNotes("Deliciosas galletas");
        payloadDto.setProduct(product);
        payloadDto.setCategory(4);
        payloadDto.setPrice(50.0);
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(payloadDto); // convertimos nuestro objeto dto a String.

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print()).andExpect(status().isCreated())
                .andReturn();
        System.out.println(payloadJson);
    }

}
