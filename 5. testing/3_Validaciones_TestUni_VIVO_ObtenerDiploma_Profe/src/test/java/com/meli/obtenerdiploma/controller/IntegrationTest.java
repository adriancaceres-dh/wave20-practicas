package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    SubjectDTO kahoot;
    SubjectDTO musica;
    SubjectDTO poo;

    StudentDTO student;

    @BeforeAll
    public static void setup(){
        studentDAO.cleanData();
    }

    @BeforeEach
    public void beforEach() {

        kahoot = new SubjectDTO("Kahoot", 1.0);
        musica = new SubjectDTO("Musica", 9.0);
        poo =    new SubjectDTO("POO",    2.0);

        student =new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(kahoot, musica, poo) );

        // Se comenta para asegurarse que siempre existe un estudiante anibal con los datos de este metodo
        //if( ! studentDAO.exists( student ) ){
        studentDAO.save(student);
        //}

    }

    @Test
    @DisplayName("Obtener Diploma Ok")
    void obtenerDiplomaTestOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno Anibal ha obtenido un promedio de 4.00. Puedes mejorar."))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Obtener Diploma Not Ok")
    void obtenerDiplomaTestNotOk() throws Exception{
        Long studentId = (long)studentDAO.getStudents().size()+1;
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id "+ studentId + " no se encuetra registrado."))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Obtener Diploma Not Ok2")
    void obtenerDiplomaTestNotOk2() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 4.5))
                .andDo(print()).andExpect(status().isBadRequest())
                //.andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 4.5 no se encuetra registrado."))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("registerStudent Ok")
    void createStudentOk() throws Exception {
        StudentDTO studentDTO = new StudentDTO((long)studentDAO.getStudents().size()+2, "Manuel", "Hola soy Manuel", 4.3, new ArrayList<>(List.of(
                new SubjectDTO("Quimica",3.5),
                new SubjectDTO("Calculo",4.5)
        )) {
        });

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        //assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("getStudent Ok")
    void getStudentOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Anibal"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(4.0))
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("getStudent NotOk")
    void getStudentNotOk() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 50L))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 50 no se encuetra registrado."))
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("modifyStudent Ok")
    void modifyStudentOk() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L, "Anibal","El alumno Anibal ha obtenido un promedio de 5.00. Puedes mejorar.", 5.0, List.of(kahoot, musica, poo) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();

        //assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("removeStudent Ok")
    void removeStudentOk() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print()).andExpect(status().isOk())
                .andReturn();
        //System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("listStudents Ok")
    void listStudents() throws Exception{
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Anibal"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }


}
