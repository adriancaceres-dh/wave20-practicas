package com.example.segurosvehiculos.integration;

import com.example.segurosvehiculos.dtos.request.SiniestroRequestDTO;
import com.example.segurosvehiculos.dtos.response.SiniestroResponseDTO;
import com.example.segurosvehiculos.model.Siniestro;
import com.example.segurosvehiculos.model.Vehiculo;
import com.example.segurosvehiculos.repository.ISiniestrosRepository;
import com.example.segurosvehiculos.repository.IVehiculosRepository;
import com.example.segurosvehiculos.utils.TestSiniestrosUtils;
import com.example.segurosvehiculos.utils.TestVehicleUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class SiniestrosIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  private static ObjectMapper mapper;

  @Autowired
  private IVehiculosRepository vehiculosRepository;
  @Autowired
  private ISiniestrosRepository siniestrosRepository;


  @BeforeAll
  public static void setUp() {
    mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

  }

  @Test
  void testCrearSiniestro() throws Exception {
    // Arrange
    Vehiculo vehiculo = TestVehicleUtils.getTestVehicle();
    vehiculo = vehiculosRepository.save(vehiculo);

    SiniestroRequestDTO dto = SiniestroRequestDTO.builder()
            .vehiculoId(vehiculo.getId())
            .fecha(LocalDate.of(2021, 1, 1))
            .perdidaTotal(13000)
            .build();

    String siniestroJson = mapper.writeValueAsString(dto);

    ResultMatcher expectedStatus = status().isCreated();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
    String expectedMessage = "Siniestro creado con exito";

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/siniestros/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content(siniestroJson);

    // Act&Assert

    mockMvc.perform(request)
            .andExpect(expectedStatus)
            .andExpect(expectedContentType)
            .andExpect(jsonPath("$.message").value(expectedMessage))
            .andDo(MockMvcResultHandlers.print());
  }

  @Test
  void testObtenerSiniestro() throws Exception {
    Vehiculo vehiculo = TestVehicleUtils.getTestVehicle();
    vehiculo = vehiculosRepository.save(vehiculo);
    Siniestro siniestro = TestSiniestrosUtils.getTestSiniestro(vehiculo);
    siniestro = siniestrosRepository.save(siniestro);

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    SiniestroResponseDTO expectedSiniestro = SiniestroResponseDTO.builder()
            .id(siniestro.getId())
            .fecha(siniestro.getFecha())
            .perdidaTotal(siniestro.getPerdidaTotal())
            .vehiculoId(siniestro.getVehiculo().getId())
            .build();

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/siniestros/{id}", siniestro.getId())
            .contentType(MediaType.APPLICATION_JSON);

    // Act&Assert

    mockMvc.perform(request)
            .andExpect(expectedStatus)
            .andExpect(expectedContentType)
            .andExpect(jsonPath("$.id").value(expectedSiniestro.getId()))
            .andExpect(jsonPath("$.fecha").value(expectedSiniestro.getFecha().toString()))
            .andExpect(jsonPath("$.perdida_total").value(expectedSiniestro.getPerdidaTotal()))
            .andExpect(jsonPath("$.vehiculo_id").value(expectedSiniestro.getVehiculoId()))
            .andDo(MockMvcResultHandlers.print());

  }

}
