package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTest {

  @Autowired
  private MockMvc mockMvc;

  static StudentDAO studentDAO = new StudentDAO();

  private static ObjectWriter writer;

  SubjectDTO kahoot;
  SubjectDTO musica;
  SubjectDTO poo;

  StudentDTO student;


  @BeforeAll
  public static void setUp() {
    writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer().withDefaultPrettyPrinter();

  }

  @BeforeEach
  public void beforeEach() {
    studentDAO.delete(11L);
    kahoot = new SubjectDTO("Kahoot", 1.0);
    musica = new SubjectDTO("Musica", 9.0);
    poo =    new SubjectDTO("POO",    2.0);

    student =new StudentDTO(11L, "Anibal","El alumno Anibal ha obtenido un promedio de 4. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

    studentDAO.save( student );

  }

  @Test
  void testAnalyzeScores() throws Exception {
    // Arrange

    String userJson = writer.writeValueAsString(student);
    System.out.println(userJson);

    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedJson = content().json(userJson);
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
            "/analyzeScores/{studentId}",
            11L);

    // Act & Assert
    mockMvc.perform(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(expectedContentType)
            .andExpect(expectedJson)
            .andExpect(expectedStatus);

  }

  @Test
  void testStudentNotFoundException() {
    // Arrange
    ResultMatcher expectedStatus = status().isNotFound();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
            "/analyzeScores/{studentId}",
            111L);

    // Act & Assert
    try {
      mockMvc.perform(request)
              .andDo(MockMvcResultHandlers.print())
              .andExpect(expectedContentType)
              .andExpect(expectedStatus)
              .andExpect(jsonPath("$.name").value("StudentNotFoundException"));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Test
  void testMethodArgumentNotValidException() throws JsonProcessingException {
    // Arrange
    student.setStudentName(" ");
    String userJson = writer.writeValueAsString(student);
    ResultMatcher expectedStatus = status().isBadRequest();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
            "/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson);

    // Act & Assert
    try {
        mockMvc.perform(request)
              .andDo(MockMvcResultHandlers.print())
              .andExpect(expectedStatus)
              .andExpect(expectedContentType)
              .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  @Test
  void testModifyStudent() throws JsonProcessingException {
    // Arrange
    StudentDTO newStudent = new StudentDTO(13L, "Arnold","El alumno Anibal ha obtenido un promedio de 4. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

    String userJson = writer.writeValueAsString(newStudent);
    ResultMatcher expectedStatus = status().isOk();
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post(
                    "/student/modifyStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(userJson);

    // Act & Assert
    try {
      mockMvc.perform(request)
              .andDo(MockMvcResultHandlers.print())
              .andExpect(expectedStatus);

    } catch (Exception e) {
      e.printStackTrace();
    }

    assertTrue(studentDAO.exists(newStudent));

  }

  @Test
  void testRemoveStudent() {
    // Arrange
    ResultMatcher expectedStatus = status().isOk();
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
                    "/student/removeStudent/{studentId}",
                    1L);
    // Act & Assert
    try {
      mockMvc.perform(request)
              .andDo(MockMvcResultHandlers.print())
              .andExpect(expectedStatus);

    } catch (Exception e) {
      e.printStackTrace();
    }

    assertThrows(StudentNotFoundException.class, () -> studentDAO.findById(1L));

  }

  @Test
  void testListStudent() {
    // Arrange
    ResultMatcher expectedStatus = status().isOk();
    ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);
    MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get(
            "/student/listStudents");
    // Act & Assert
    try {
      mockMvc.perform(request)
              .andDo(MockMvcResultHandlers.print())
              .andExpect(expectedStatus)
              .andExpect(expectedContentType)
              .andReturn();

    } catch (Exception e) {
      e.printStackTrace();
    }


  }

}
