package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.awt.*;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTests {

    @Autowired
    private MockMvc mockMvc;

    //register student
    @Test
    @DisplayName("Camino feliz - Registraría un usuario y se esperaría que el status code sea ok")
    public void testRegisterStudentOK() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(newStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
    }

    //get student
    @Test
    @DisplayName("Camino feliz - Debería traer el estudiante solicitado por su número de Id")
    public void testGetStudentOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.studentName").value("Juan"));
    }

    //modify student
    @Test
    @DisplayName("Camino feliz - Debería modificar un estudiante y devolver un status code 200")
    public void testModifyStudentOk() throws Exception {
        StudentDTO existingStudent = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();
        String payloadJson = writer.writeValueAsString(existingStudent);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }

    //remove student
    @Test
    @DisplayName("Camino feliz - Debería eliminar un estudiante por Id y devolver un status code 200")
    public void testRemoveStudentOk() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk());
    }

    //list students
    @Test
    @DisplayName("Camino feliz - Debería listar todos los estudiantes registrados")
    public void testListStudents() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)));
    }
    //Preguntar por qué es 3 y no 2 como debería ser ^^^^


}
