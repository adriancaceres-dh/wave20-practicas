package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IStudentService studentService;

    StudentDAO studentDAO = new StudentDAO();

    @Test
    void registerStudentTestOk() throws Exception{
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setAverageScore(5.00);
        studentDTO.setMessage("El promedio del alumno es bajo");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void modifyStudentTestOk() throws Exception{
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setAverageScore(5.00);
        studentDTO.setMessage("El promedio del alumno es bajo");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(post("/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }
    @Test
    void removeStudentTestOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(6L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setAverageScore(5.00);
        studentDTO.setMessage("El promedio del alumno es bajo");
        studentDTO.setSubjects(new ArrayList<>(Arrays.asList(
                new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Física",8.0),
                new SubjectDTO("Química",4.0)
        )));
        studentDAO.save(studentDTO);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String payloadDto = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(get("/removeStudent/{id}",6)
                       .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

}
