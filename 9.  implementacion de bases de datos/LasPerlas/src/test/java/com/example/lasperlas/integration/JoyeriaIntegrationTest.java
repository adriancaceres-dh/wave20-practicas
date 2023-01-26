package com.example.lasperlas.integration;

import com.example.lasperlas.dto.JoyaRequestDTO;
import com.example.lasperlas.service.IJoyeriaService;
import com.example.lasperlas.utilities.Action;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest()
@AutoConfigureMockMvc
class JoyeriaIntegrationTest {
  @Autowired
  private MockMvc mockMvc;
  private static ObjectWriter writer;

  @Autowired
  private IJoyeriaService service;


  @BeforeAll
  public static void setUp() {
    writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

  }

  @Test
  void integrationTestCrear() throws Exception {
    // Arrange
    JoyaRequestDTO dto = JoyaRequestDTO.builder()
            .nombre("Pulsera")
            .peso(10f)
            .material("Oro")
            .particularidad("Ninguna")
            .tienePiedra(false)
            .build();

    String joyaJson = writer.writeValueAsString(dto);


    ResultMatcher expectedStatus = status().isCreated();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/jewelry/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content(joyaJson);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType, jsonPath("$.action").value(Action.ADDED.name()));

  }

  @Test
  void integrationTestGetAll() throws Exception {
    // Arrange
    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/jewelry")
            .contentType(MediaType.APPLICATION_JSON);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType);
  }

  @Test
  void integrationTestDeleteById() throws Exception {
    // Arrange
    Integer id = service.getAllJewelry().get(0).getId();
    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/jewelry/delete/" + id)
            .contentType(MediaType.APPLICATION_JSON);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType, jsonPath("$.action").value(Action.DELETED.name()));

  }

  @Test
  void integrationTestUpdateById() throws Exception {
    // Arrange
    Integer id = service.getAllJewelry().get(0).getId();
    JoyaRequestDTO dto = JoyaRequestDTO.builder()
            .nombre("Pulsera")
            .peso(10f)
            .material("Oro")
            .particularidad("Ninguna")
            .tienePiedra(false)
            .build();

    String joyaJson = writer.writeValueAsString(dto);

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/jewelry/update/" + id)
            .contentType(MediaType.APPLICATION_JSON)
            .content(joyaJson);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType, jsonPath("$.action").value(Action.UPDATED.name()));

  }

}
