package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class StudentControllerIntegrationTests {
    @Autowired
    MockMvc mockMvc;
    @Test
    void testGetStudent()throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void testRegisterStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Luis");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadDto)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(content().contentType(MediaType.APPLICATION_JSON))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Marcos"))
                .andReturn();

    }

    @Test
    void testModifyStudent() throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Andres");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    void testRemoveStudent()throws Exception{
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marcos");
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/removeStudent/{id}",studentDTO.getId()))
                .andDo(print()).andExpect(status()
                        .isOk())
                .andReturn();

        assertEquals(200, mvcResult.getResponse().getStatus());
    }
    @Test
    void testListStudent()throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                        .get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Pedro"))
                .andReturn();

    }


    @Test
    void validationBadRegisterNameNotCapitalized()throws Exception{
        StudentDTO userDto = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marcos");
        userDto.setStudentName("marcos");
        ErrorDTO errorDto = new ErrorDTO("MethodArgumentNotValidException","El nombre del estudiante debe comenzar con mayúscula.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(userDto);
        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andReturn();
        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    void validationBadRegisterSubjectListEmpty()throws Exception{
        StudentDTO userDto = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Marcos");
        userDto.setSubjects(null);
        ErrorDTO errorDto = new ErrorDTO("MethodArgumentNotValidException","La lista de materias no puede estar vacía.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(userDto);
        String errorExpected = writer.writeValueAsString(errorDto);

        MvcResult mvcResult= mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andReturn();
        assertEquals(errorExpected,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
