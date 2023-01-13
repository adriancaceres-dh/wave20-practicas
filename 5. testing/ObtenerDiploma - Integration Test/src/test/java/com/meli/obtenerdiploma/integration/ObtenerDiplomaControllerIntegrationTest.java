package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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
class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    private StudentDAO studentDAO;

    public ObtenerDiplomaControllerIntegrationTest() {
        studentDAO = new StudentDAO();
    }

    public StudentDTO generateStudentDTO() {
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(new SubjectDTO("Matematica", 9.0));
        subjectDTOList.add(new SubjectDTO("Fisica", 10.0));
        return new StudentDTO(3L, "Flavio", "", 0.0, subjectDTOList);
    }

    @Test
    @DisplayName("Camino Feliz")
    void analyzeScoresOK() throws Exception {
        StudentDTO studentDTO = generateStudentDTO();
        studentDAO.save(studentDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentDTO.getId()))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Flavio"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(9.5))
                .andReturn();
    }

    @Test
    @DisplayName("Estudiante no encontrado")
    void analyzeScoresStudentNotFound() throws Exception {
        String studentId = "99";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 99 no se encuetra registrado."))
                .andReturn();
    }
}