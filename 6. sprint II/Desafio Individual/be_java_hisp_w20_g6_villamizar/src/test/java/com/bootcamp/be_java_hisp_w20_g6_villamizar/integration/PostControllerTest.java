package com.bootcamp.be_java_hisp_w20_g6_villamizar.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US0002 - TI0004, Verificar registro de publicación ")
    void savePostValid() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/products/post")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content("{" +
                                        "\"user_id\": 3," +
                                        "\"date\": \"24-12-2022\"," +
                                        "\"product\": {" +
                                        "\"product_id\": 1," +
                                        "\"product_name\": \"Silla normal\"," +
                                        "\"type\": \"Gamer\"," +
                                        "\"brand\": \"Racer\"," +
                                        "\"color\": \"Red Black\"," +
                                        "\"notes\": \"Special Edition\"" +
                                        "}," +
                                        "\"category\": 100," +
                                        "\"price\": 1500.50" +
                                        "}"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").value(true));
    }

}


