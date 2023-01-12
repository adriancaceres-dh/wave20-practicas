package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//No llegue a terminarlo, me faltarian un par de casos no felices y testear el otro controlador
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ObtenerDiplomaIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    public void testPostRegisterStudent() throws Exception {
        SubjectDTO sub1 = new SubjectDTO("Matematica",8.00);
        SubjectDTO sub2 = new SubjectDTO("Historia",8.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);
        StudentDTO res = new StudentDTO(4L,"Ignacio","",0.00,subjects);
        String payloadJson = writer.writeValueAsString(res);
        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
        ;
    }

    @Test
    public void testGetGetStudentById () throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}" , "2"))
            .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.subjects.length()").value(3));
    }

    @Test
    public void testGetGetStudentByIdDoesntExists () throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}" , "5"))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType( "application/json" ))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 5 no se encuetra registrado."));
    }

    @Test
    public void testPostModifyStudent () throws Exception {

        SubjectDTO sub1 = new SubjectDTO("Matematica",8.00);
        SubjectDTO sub2 = new SubjectDTO("Historia",8.00);
        List<SubjectDTO> subjects = List.of(sub1,sub2);
        StudentDTO res = new StudentDTO(4L,"Ignacio","",0.00,subjects);
        String payloadJson = writer.writeValueAsString(res);

        this.mockMvc.perform(
                MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isOk());
        ;
    }

    @Test
    public void testPostDeleteStudentThatDoesntExists () throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}" , "16"))
                .andDo(print())
                .andExpect(status().isOk());
        ;
    }

    @Test
    public void testPostDeleteStudentThatExists () throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}" , "3"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testGetGetListOfStudents () throws Exception {

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType( "application/json" ))
                .andReturn();

        String response  = result.getResponse().getContentAsString();

        ObjectMapper mapper = new ObjectMapper();

        List<StudentDTO> students = mapper.readValue(response, new TypeReference<List<StudentDTO>>(){});

        assertEquals(3,students.size());
    }

}
