package com.mercadolibre.starwars.integracion;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FindControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testFind() throws Exception {

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
            "/Luke");

    mockMvc.perform(request)
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("$[0].name").value("Luke Skywalker"))
            .andExpect(jsonPath("$[0].species").value("Human"))
            .andExpect(jsonPath("$[0].homeworld").value("Tatooine"))
            .andExpect(jsonPath("$[0].hair_color").value("blond"))
            .andExpect(jsonPath("$[0].skin_color").value("fair"))
            .andExpect(jsonPath("$[0].eye_color").value("blue"))
            .andExpect(jsonPath("$[0].birth_year").value("19BBY"))
            .andExpect(jsonPath("$[0].gender").value("male"))
            .andExpect(jsonPath("$[0].height").value("172"))
            .andExpect(jsonPath("$[0].mass").value("77"));
  }
}
