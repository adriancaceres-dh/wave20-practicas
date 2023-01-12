package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegration {

    @Autowired
    MockMvc mockMvc;

    private static StudentDTO student1, student2;
    private static ObjectWriter writer;
    private static StudentDAO studentDAO;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        studentDAO = new StudentDAO();

        List<SubjectDTO> subjects1= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",5.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        List<SubjectDTO>subjects2= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",10.0));
            add(new SubjectDTO("Sub2",10.0));
            add(new SubjectDTO("Sub3",10.0));
        }};
        student1= new StudentDTO(9000L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,subjects1);
        student2= new StudentDTO(9999L,"Student2","El alumno Student2 ha obtenido un promedio de 10.00. Felicitaciones!",10.0,subjects2);

    }
    @BeforeEach
    public void beforeEach(){
        studentDAO.save(student1);
        studentDAO.save(student2);
    }
    @AfterEach
    public void afterEach(){
        studentDAO.delete(student1.getId());
        studentDAO.delete(student2.getId());
    }

    @Test
    public void analizeScoresTestOk() throws Exception{
        this.perform(student1);
    }
    @Test
    public void analizeScoresTestHonours() throws Exception{
        this.perform(student2);
    }

    private void perform(StudentDTO expected) throws Exception{
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}",expected.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(expected.getId()))
                .andExpect(jsonPath("$.message").value(expected.getMessage()))
                .andExpect(jsonPath("$.averageScore").value(expected.getAverageScore()))
                .andReturn();

        Assertions.assertEquals(writer.writeValueAsString(expected),mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void analizeScoresTestException() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", Long.MAX_VALUE))
                .andDo(MockMvcResultHandlers.print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
