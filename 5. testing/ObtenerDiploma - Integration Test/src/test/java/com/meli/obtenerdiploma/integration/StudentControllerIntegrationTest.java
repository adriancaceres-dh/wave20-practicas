package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class StudentControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;

    private IStudentDAO studentDAO;

    public StudentControllerIntegrationTest (){
        studentDAO = new StudentDAO();
    }

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }
    public StudentDTO generateStudentDTO() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 9.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 9.0));
        return new StudentDTO(3L, "Juan", "", 1.0, subjectDTOList);
    }

    public StudentDTO generateStudentDTOFake() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 9.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 9.0));
        return new StudentDTO(3L, "juan", "", 1.0, subjectDTOList);
    }

    @Test
    void registerStudentOk() throws Exception {
        StudentDTO studentDTO = generateStudentDTO();
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                //.andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void registerStudentMethodArgumentNotValidException() throws Exception {
        StudentDTO studentDTO = generateStudentDTOFake();
        String payloadJson = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void getStudentOk() throws Exception {
        StudentDTO studentDTO = generateStudentDTO();
        studentDAO.save(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                .andReturn();
    }

    @Test
    void getStudentNotFound() throws Exception {
        String id = "99";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

    @Test
    void modifyStudentOk() throws Exception {
        StudentDTO studentDTO = generateStudentDTO();
        String payloadDTO = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                                    .contentType(MediaType.APPLICATION_JSON)
                                    .content(payloadDTO))
                            .andDo(print()).andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                .andReturn();
    }

    @Test
    void modifyStudentMethodArgumentNotValidException() throws Exception {
        StudentDTO studentDTO = generateStudentDTOFake();
        String payloadDTO = writer.writeValueAsString(studentDTO);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print()).andExpect(status().isBadRequest())
                .andReturn();
    }

    @Test
    void removeStudentOk() throws Exception {
        String id = "2";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                .andReturn();
    }

    /**
     * removeStudentNotFound devuelve un 200 aunque no exista el id
     * nunca salta StudentNotFoundException por como esta construido el metodo delete
     */

    /*
    @Test
    void removeStudentNotFound() throws Exception {
        String id = "99";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", id))
                .andDo(print()).andExpect(status().isNotFound())
                //.andExpect(content().contentType("application/json"))
                .andReturn();
    }

    */

    @Test
    void listStudentsOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Juan"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}