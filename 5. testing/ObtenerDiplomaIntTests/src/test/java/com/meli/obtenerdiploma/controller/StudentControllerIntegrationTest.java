package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    @AfterEach
    public void setUp() {
        initializeDatabase();
    }

    @AfterAll
    public static void runAfterAll() {
        TestUtilsGenerator.emptyUsersFile();
    }

    @Test
    @DisplayName("Register a valid student")
    public void registerValidStudent() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepe");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Register a student with Invalid Name")
    public void registerStudentWithInvalidName() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("pepe");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante debe comenzar con mayúscula."));
    }

    @Test
    @DisplayName("Register a student with a long name")
    public void registerStudentWithMoreThan50Chars() throws Exception {
        String longName = "Estebannnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnnn";
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9(longName);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre del estudiante no puede superar los 50 caracteres."));
    }

    @Test
    @DisplayName("Register a student with a null name")
    public void registerStudentWithNullName() throws Exception {
        StudentDTO newStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre del estudiante no puede estar vacío."));
    }

    @Test
    @DisplayName("Register a student with no subjects")
    public void registerStudentWithNoSubjects() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacía."));
    }

    @Test
    @DisplayName("Register a student with a subject in lowercase")
    public void registerStudentWithASubjectInLowerCase() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "quimica",
                9d,
                "Matemática",
                10d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia debe comenzar con mayúscula."));
    }

    @Test
    @DisplayName("Register a student with a missing subject name")
    public void registerStudentWithAMissingSubjectName() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                9d,
                null,
                10d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre de la materia no puede estar vacío."));
    }

    @Test
    @DisplayName("Register a student with a subject name with more than 30 chars")
    public void registerStudentWithASubjectWithMoreThan30Chars() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                9d,
                "Historiaaaaaaaaaaaaaaaaaaaaaaaa",
                10d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La longitud del nombre de la materia no puede superar los 30 caracteres."));
    }

    @Test
    @DisplayName("Register a student with a subject with no grade")
    public void registerStudentWithASubjectWithNoGrade() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                null,
                "Historiaaaaaaaaaaaaaaaaaaaaaaaa",
                10d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota de la materia no puede estar vacía."));
    }

    @Test
    @DisplayName("Register a student with a subject with negative grade")
    public void registerStudentWithASubjectWithNegativeGrade() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                10d,
                "Historia",
                -1d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota mínima de la materia es de 0 pts."));
    }

    @Test
    @DisplayName("Register a student with a subject with a grade more than 10")
    public void registerStudentWithASubjectWithGradeMoreThan10() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setStudentName("Snoop");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                10d,
                "Historia",
                11d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("MethodArgumentNotValidException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La nota máxima de la materia es de 10 pts."));
    }

    @Test
    @DisplayName("Get a existent student")
    public void getAnExistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L ))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("student1"));
    }

    @Test
    @DisplayName("Get a non-existent student")
    public void getANonExistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 33L ))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 33 no se encuetra registrado."));
    }

    @Test
    @DisplayName("Update Valid Student")
    public void updateValidStudent() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(1L);
        newStudent.setStudentName("Student1");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                10d,
                "Historia",
                5d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Update non existent student (creates a new one)")
    public void updateNonExistentStudent() throws Exception {
        StudentDTO newStudent = new StudentDTO();
        newStudent.setId(444L);
        newStudent.setStudentName("Student1");
        newStudent.setSubjects(getSubjects(
                "Quimica",
                10d,
                "Historia",
                5d
        ));

        mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(getStudentAsString(newStudent)))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete existent student")
    public void deleteExistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L ))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Delete non existent student (mal comportamiento, revisar código)")
    public void deleteNonExistentStudent() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 213123L ))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Get all students")
    public void getAllStudents() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));
    }


    private List<SubjectDTO> getSubjects(String subjectName1, Double score1, String subjectName2, Double score2) {
        SubjectDTO subject1 =  new SubjectDTO(subjectName1, score1);
        SubjectDTO subject2 =  new SubjectDTO(subjectName2, score2);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(subject1);
        subjects.add(subject2);
        return subjects;
    }

    private String getStudentAsString(StudentDTO studentDTO) throws JsonProcessingException {
        ObjectWriter writer = new ObjectMapper().
                configure(SerializationFeature.WRAP_ROOT_VALUE, false).
                writer().withDefaultPrettyPrinter();

        return writer.writeValueAsString(studentDTO);
    }

    private void initializeDatabase() {
        TestUtilsGenerator.emptyUsersFile();
        StudentDTO regularStudent = TestUtilsGenerator.getStudentWithId(1L);
        StudentDTO highGradesStudent = TestUtilsGenerator.getStudentWith3SubjectsAverageOver9("Pepo");
        Set<StudentDTO> students = new HashSet<>();
        students.add(regularStudent);
        students.add(highGradesStudent);

        TestUtilsGenerator.appendSetOfStudents(students);
    }

}