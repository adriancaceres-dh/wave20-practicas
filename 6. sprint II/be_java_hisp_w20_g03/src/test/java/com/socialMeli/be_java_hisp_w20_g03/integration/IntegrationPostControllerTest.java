package com.socialMeli.be_java_hisp_w20_g03.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.request.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.socialMeli.be_java_hisp_w20_g03.utils.PostUtils;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationPostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    @DisplayName("T-0012: Agregar una publicacion")
    @Test
    public void testAddPost () throws Exception{
        PostDTO payloadDto = PostUtils.createPost(123);

        String payload = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("Publicacion agregada"))
                .andReturn();
    }

    @DisplayName("T-0012: Agregar una publicacion usuario invalido")
    @Test
    public void testAddPostNotValidUser () throws Exception{
        PostDTO payloadDto = PostUtils.createPost(1233);

        String payload = writer.writeValueAsString(payloadDto);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().string("El usuario ingresado no existe"))
                .andReturn();
    }

}
