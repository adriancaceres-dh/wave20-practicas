package com.meli.obtenerdiploma.integration;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationApplicationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private StudentDAO studentDAO;
    @BeforeEach
    @AfterEach
    private void setUp() {
        TestUtilsGenerator.emptyUsersFile();
    }



    @Test
    void saveUser() throws Exception {
        ObjectWriter objectWriter = new ObjectMapper().writer();
        StudentDTO st = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        String payload = objectWriter.writeValueAsString(st);
        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

   @Test
   public void analyzeScoresAverage9() throws Exception{
       StudentDTO st = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepe");
       studentDAO.save(st);

       MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}",1))
               .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                       .value("El alumno Pepe ha obtenido un promedio de 9.00. Felicitaciones!"))
               .andReturn();


   }
    @Test
    public void analyzeScores() throws Exception {
        //save user
        StudentDTO st = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        studentDAO.save(st);


        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}",1))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message")
                        .value("El alumno Pepe ha obtenido un promedio de 6.00. Puedes mejorar."))
                .andReturn();
    }


    @Test
    public void analyzeScoresNotFound() throws Exception {
        //save user
        saveUserDAO();

        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{id}",1000))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 1000 no se encuetra registrado."))
                .andReturn();
    }


    void saveUserDAO() {
        StudentDTO st = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        studentDAO.save(st);
    }
    @Test
    public void getStudent() throws Exception {
        //save user

        saveUserDAO();

        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id")
                        .value(1))
                .andReturn();
    }

    @Test
    public void getStudentNotFound() throws Exception {
        //save user

        saveUserDAO();

        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",1000))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description")
                        .value("El alumno con Id 1000 no se encuetra registrado."))
                .andReturn();
    }

    @Test
    public void modifyStudent() throws Exception {
        //save user

        saveUserDAO();
        StudentDTO studentDTO = studentDAO.findById(1l);
        studentDTO.setStudentName("Fede");
        ObjectWriter objectWriter = new ObjectMapper().writer();
        StudentDTO st = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        String payload = objectWriter.writeValueAsString(st);

        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())

                .andReturn();
    }

    @Test
    public void modifyStudentNotFound() throws Exception {
        //save user

        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3Subjects("Fede");

        ObjectWriter objectWriter = new ObjectMapper().writer();
        StudentDTO st = TestUtilsGenerator.getStudentWith3Subjects("Pepe");
        String payload = objectWriter.writeValueAsString(st);


        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    public void listStudents() throws Exception {


        //save user

        saveUserDAO();
        saveUserDAO();


        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(2))
                        .andReturn();
    }

    @Test
    public void removeStudent() throws Exception {
        //save user

        saveUserDAO();

        MvcResult b = this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",1))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
    }

}
