package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
class StudentControllerTestIntegration {
    @Autowired
    private MockMvc mockMvc;
    static StudentDAO studentDAO = new StudentDAO();
    private static ObjectWriter writer;
    private StudentDTO studentDTO;
    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }
    @BeforeEach
    private void studentDTO(){
        List<SubjectDTO> list = new ArrayList<>();
        list.add(new SubjectDTO("Matemática",8.0));
        list.add(new SubjectDTO("Física",9.0));
        list.add(new SubjectDTO("Química",10.0));
        StudentDTO student = new StudentDTO(1L,"Pedro","",0.0,list);
        studentDTO = student;
        studentDAO.save(student);
    }

    @Test
    void registerStudent() throws Exception {
        String payloadJson = writer.writeValueAsString(studentDTO);
        StudentDTO studentDTO1 = studentDTO;
        this.mockMvc.perform(
                        MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                .andDo(print()).andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"))
                //.andReturn();
        //Assertions.assertEquals(studentDTO1, mvcResult.getResponse().getContentAsString());



    }

  /*  @Test
    void getStudent() throws Exception  {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/getStudent/{id}",2L))
                .andDo(print()).andExpect(status().isOk());
    }*/

    @Test
    void modifyStudent() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void listStudents() {
    }
}