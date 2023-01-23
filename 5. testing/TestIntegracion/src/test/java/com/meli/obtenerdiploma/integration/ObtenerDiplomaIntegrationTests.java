package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaIntegrationTests {

    @Autowired
    MockMvc mockMvc;
    static StudentDAO studentDAO = new StudentDAO();

    @BeforeAll
    static void createTestUser(){
        SubjectDTO subjectDTO1 = new SubjectDTO("subject1", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("subject2", 4.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("subject3", 2.0);
        SubjectDTO subjectDTO4 = new SubjectDTO("subject4", 8.0);

        StudentDTO studentDTO1 =new StudentDTO();
        studentDTO1.setStudentName("student1");
        studentDTO1.setId(1L);
        studentDTO1.setSubjects(List.of(subjectDTO1,subjectDTO2,subjectDTO3,subjectDTO4));
        studentDAO.save( studentDTO1 );
    }
    @Test
    public void returnCorrectAnalizeScore() throws Exception{


        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("student1"))
                .andExpect(jsonPath("$.averageScore").value(6.0))
                .andExpect(jsonPath("$.subjects.length()").value(4));

    }
    @Test
    public void postProductTestValidPost() throws Exception{
        SubjectDTO subjectDTO1 = new SubjectDTO("Subject1", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Subject2", 4.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Subject3", 2.0);
        SubjectDTO subjectDTO4 = new SubjectDTO("Subject4", 8.0);

        StudentDTO studentDTO2 =new StudentDTO();
        studentDTO2.setStudentName("Student2");
        studentDTO2.setSubjects(List.of(subjectDTO1,subjectDTO2,subjectDTO3,subjectDTO4));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());

    }
    @Test
    public void postProductTestInvalidPost() throws Exception{
        SubjectDTO subjectDTO1 = new SubjectDTO("subject1", 10.0);
        SubjectDTO subjectDTO2 = new SubjectDTO("Subject2", 4.0);
        SubjectDTO subjectDTO3 = new SubjectDTO("Subject3", 2.0);
        SubjectDTO subjectDTO4 = new SubjectDTO("Subject4", 8.0);

        StudentDTO studentDTO2 =new StudentDTO();
        studentDTO2.setStudentName("Student2");
        studentDTO2.setSubjects(List.of(subjectDTO1,subjectDTO2,subjectDTO3,subjectDTO4));

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(studentDTO2);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));

    }
}
