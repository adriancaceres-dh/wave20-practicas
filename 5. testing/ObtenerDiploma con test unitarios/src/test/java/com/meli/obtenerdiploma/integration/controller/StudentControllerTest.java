package com.meli.obtenerdiploma.integration.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.UTF8JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.meli.obtenerdiploma.util.TestUtilsGenerator.getStudentWith3Subjects;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Endpoint para registrar un estudiante, camino feliz.")
    void testRegisterStudentOK() throws Exception {
        StudentDTO payloadStudentDTO = TestUtilsGenerator.getStudentWith3Subjects("Ronaldo");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadStudentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

    }

    @Test
    @DisplayName("Endpoint para registrar un estudiante, camino triste, arrojando excepcion.")
    void testRegisterStudentNotOK() throws Exception {
        StudentDTO payloadStudentDTO = new StudentDTO();
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadStudentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON).content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacía."))
                .andReturn();

    }

    @Test
    @DisplayName("Obtener estudiante por su ID, caso feliz")
    void testGetStudentOK() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(1L, "Ronaldo", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(expectedStudent);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student//getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        Assertions.assertEquals(expectedJson, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    @DisplayName("Obtener estudiante por su ID pero con id inexistente, caso no feliz")
    void testGetStudentNotOK() throws Exception {
        StudentDTO expectedStudent = new StudentDTO(2L, "Ronaldo", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(expectedStudent);


        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student//getStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 2 no se encuetra registrado."))
                .andReturn();


        //Assertions.assertEquals(expectedJson,mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));

    }

    @Rollback
    @Test
    @DisplayName("Modificando un estudiante existente")
    void testModifyStudentOK() throws Exception {
        StudentDTO payloadStudentDTO = new StudentDTO(1L, "Roman", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadStudentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andExpect(status().isOk());
    }

    @Test
    @DisplayName("Modificando un estudiante existente, pero con un minuscula")
    void testModifyStudentNotOK() throws Exception {
        StudentDTO payloadStudentDTO = new StudentDTO(3L, "alejandro", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String payloadJson = writer.writeValueAsString(payloadStudentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Eliminando un estudiante existente")
    void testRemoveStudent() throws Exception{

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", "1"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Listando estudiantes caso feliz")
    void testListStudentsOK() throws Exception{

        Set<StudentDTO> expectedSetEstudentDTO = new HashSet<>();
        StudentDTO expectedStudent1 = new StudentDTO(3L, "Alejandro", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));
        StudentDTO expectedStudent2 = new StudentDTO(2L, "Ronaldo", null, null,
                List.of(new SubjectDTO("Matemática", 8.0), new SubjectDTO("Lengua", 6.0),
                        new SubjectDTO("Física", 4.0)));
        expectedSetEstudentDTO.add(expectedStudent1);
        expectedSetEstudentDTO.add(expectedStudent2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        String expectedJson = writer.writeValueAsString(expectedSetEstudentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        Assertions.assertEquals(expectedJson,mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));

    }


}
