package com.socialMeli.be_java_hisp_w20_g03.integration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Test
  void integrationTestAddPostOk() throws Exception {

    String postJson = "{\n" +
            "    \"user_id\": 123,\n" +
            "    \"date\": \"29-04-2021\",\n" +
            "    \"product\": {\n" +
            "        \"product_id\": 1,\n" +
            "        \"product_name\": \"Silla Gamer\",\n" +
            "        \"type\": \"Gamer\",\n" +
            "        \"brand\": \"Racer\",\n" +
            "        \"color\": \"Red and Black\",\n" +
            "        \"notes\": \"Special Edition\"\n" +
            "    },\n" +
            "    \"category\": 100,\n" +
            "    \"price\": 1500.50\n" +
            "}";

    ResultMatcher expectedStatus = status().isOk();

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
            "/products/post")
            .contentType(MediaType.APPLICATION_JSON)
            .content(postJson);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(expectedStatus);
  }
}
