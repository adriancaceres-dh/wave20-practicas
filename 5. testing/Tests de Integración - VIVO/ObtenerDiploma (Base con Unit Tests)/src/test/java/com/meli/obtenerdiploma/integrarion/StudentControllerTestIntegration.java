package com.meli.obtenerdiploma.integrarion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.Charset;
import java.util.Set;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    IStudentService studentService;


    static StudentDAO studentDAO = new StudentDAO();

    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
        TestUtilsGenerator.emptyUsersFile();

    }

    @Test
    void registerStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        studentDTO.setAverageScore(6.0);
        studentDTO.setMessage("El alumno Pedro ha obtenido un promedio de 6.00. Puedes mejorar.");

        String studentDToJson = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDToJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    void modifyStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Pedro");
        studentDTO.setAverageScore(6.0);
        studentDTO.setMessage("El alumno Pedro ha obtenido un promedio de 6.00. Puedes mejorar.");

        String studentDToJson = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(studentDToJson))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    void getStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(1L);
        studentDTO.setAverageScore(6.0);
        studentDTO.setMessage("El alumno student1 ha obtenido un promedio de 6.00. Puedes mejorar.");
        studentDAO.save(studentDTO);
        String studentDToJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.studentName").value("student1"))
                .andReturn();

        Assertions.assertEquals(studentDToJson, mvcResult.getResponse().getContentAsString(Charset.defaultCharset()));
    }

    @Test
    void removeStudentOk() throws Exception {
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWithId(9L);
        studentDTO.setAverageScore(6.0);
        studentDTO.setMessage("El alumno student1 ha obtenido un promedio de 6.00. Puedes mejorar.");
        studentDAO.save(studentDTO);

        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 9))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk());
    }

    @Test
    void listStudentsOk() throws Exception{
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        students.forEach(studentDTO -> studentDAO.save(studentDTO));
        String studentDToJson = writer.writeValueAsString(students);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(6L))
                .andExpect(jsonPath("$[0].studentName").value("Julio"))
                .andReturn();
    }
}
