package com.example.segurosvehiculos.integration;

import com.example.segurosvehiculos.dtos.request.VehiculoRequestDTO;
import com.example.segurosvehiculos.dtos.response.VehiculoResponseDTO;
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

import java.time.Year;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class VehiculosIntegrationTest {
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private IVehiculosRepository vehiculosRepository;
  @Autowired
  private ISiniestrosRepository siniestrosRepository;

  private static ObjectMapper mapper;

  @BeforeAll
  public static void setUp() {
    mapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();

  }

  @Test
  void testCrearVehiculo() throws Exception {
    // Arrange
    VehiculoRequestDTO dto = VehiculoRequestDTO.builder()
            .marca("Ford")
            .modelo("Fiesta")
            .patente("1234ABC")
            .cantRuedas(4)
            .anio(Year.of(2010))
            .build();

    String vehiculoJson = mapper.writeValueAsString(dto);

    ResultMatcher expectedStatus = status().isCreated();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
    String expectedMessage = "Vehiculo creado con exito";

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/vehiculos/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content(vehiculoJson);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType, jsonPath("$.message").value(expectedMessage));
  }

  @Test
  void testObtenerVehiculo() throws Exception {
    // Arrange
    Vehiculo vehiculo = TestVehicleUtils.getTestVehicle();
    vehiculo = vehiculosRepository.save(vehiculo);

    VehiculoResponseDTO expectedVehiculo = VehiculoResponseDTO.builder()
            .id(vehiculo.getId())
            .marca(vehiculo.getMarca())
            .modelo(vehiculo.getModelo())
            .patente(vehiculo.getPatente())
            .cantRuedas(vehiculo.getCantRuedas())
            .anio(vehiculo.getAnio())
            .build();

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/vehiculos/{id}", vehiculo.getId())
            .contentType(MediaType.APPLICATION_JSON);

    // Act & Assert

    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType, jsonPath("$.id").value(expectedVehiculo.getId()))
            .andExpect(jsonPath("$.marca").value(expectedVehiculo.getMarca()))
            .andExpect(jsonPath("$.modelo").value(expectedVehiculo.getModelo()))
            .andExpect(jsonPath("$.patente").value(expectedVehiculo.getPatente()))
            .andExpect(jsonPath("$.anio").value(expectedVehiculo.getAnio().toString()))
            .andExpect(jsonPath("$.cantidad_ruedas").value(expectedVehiculo.getCantRuedas()));
  }

  @Test
  void testFindVehiclesThatHadExpensiveAccidents() throws Exception {
    // Arrange
    Vehiculo vehiculo = TestVehicleUtils.getTestVehicle();
    vehiculo = vehiculosRepository.save(vehiculo);
    Siniestro siniestro = TestSiniestrosUtils.getTestExpensiveSiniestro(vehiculo);
    siniestrosRepository.save(siniestro);

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/vehiculos/expensive-accidents/{perdida}", 10000)
            .contentType(MediaType.APPLICATION_JSON);

    // Act & Assert

    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType)
            .andExpect(jsonPath("$[0].patente").value(vehiculo.getPatente()));
  }

  @Test
  void testFindVehiclesWithMoreThen4WheelsManufacturedThisYear() throws Exception {
    // Arrange
    Vehiculo vehiculo = TestVehicleUtils.getTestVehicleManufacturedYhisYear();
    vehiculo = vehiculosRepository.save(vehiculo);

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
    String expectedMessage = vehiculo.getPatente();

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/vehiculos/cantidad-ruedas/{cantidad_ruedas}/anio/{anio}", 4, Year.now().getValue())
            .contentType(MediaType.APPLICATION_JSON);

    // Act & Assert

    String response = mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpectAll(expectedStatus, expectedContentType)
            .andReturn().getResponse().getContentAsString();
    assert response.contains(expectedMessage);

  }


}
