package com.meli.obtenerdiploma.integration;

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

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegration {

    @Autowired
    MockMvc mockMvc;
    private static StudentDTO student;
    private static List<SubjectDTO> subjects;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        subjects= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",5.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        student= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,subjects);
    }
    @BeforeEach
    public void beforeAfterEach(){
        TestUtilsGenerator.emptyUsersFile();
        TestUtilsGenerator.appendNewStudent(new StudentDTO(1L,"Student1",null,null,subjects));
        TestUtilsGenerator.appendNewStudent(new StudentDTO(2L,"Student2",null,null,subjects));
    }

    @Test
    public void registerStudentTestNotCapitalizedNameArgument() throws Exception{
        StudentDTO invalidStudent= new StudentDTO(9999L,"student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,subjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestBlankNameArgument() throws Exception{
        StudentDTO invalidStudent= new StudentDTO(9999L,"","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,subjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestTooLongNameArgument() throws Exception{
        StudentDTO invalidStudent= new StudentDTO(9999L,"student1dkjahbskjdbehjdbkhjdbkjbkjshbfjhefbjhewbjewhebvjhwevfjhewvdghjewvdjhewvjhbedjhewbdhjwebdhjewbdjhewdvwhjevffdsfbjbfjfdsfjkewbnwjkfb","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,subjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestEmptySubjectsArgument() throws Exception{
        StudentDTO invalidStudent= new StudentDTO(9999L,"student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,new ArrayList<>());
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestBlankSubjectNameArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("",5.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestNotCapitalizedSubjectNameArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("sub1",5.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestTooLongSubjectNameArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("Skfjsndfjkdnsfkjdsnfjkdsbfjkdsfbsdjfbhfjkebdskjdsnfkjdbfjkdbfhjdsdfkjnrfbwfkdmklksndjfndjkbdbvhfvbfkvjdf",5.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestNullScoreArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",null));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestScoreAboveMaxArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",11.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }
    @Test
    public void registerStudentTestScoreBelowMinArgument() throws Exception{
        List<SubjectDTO>invalidSubjects= new ArrayList<>(){{
            add(new SubjectDTO("Sub1",-1.0));
            add(new SubjectDTO("Sub2",6.0));
            add(new SubjectDTO("Sub3",7.0));
        }};
        StudentDTO invalidStudent= new StudentDTO(9999L,"Student1","El alumno Student1 ha obtenido un promedio de 6.00. Puedes mejorar.",6.0,invalidSubjects);
        performInvalidArgumentsTest(invalidStudent);
    }

    private void performInvalidArgumentsTest(StudentDTO newStudent) throws Exception{
        String payload= writer.writeValueAsString(newStudent);
        //Register student
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(payload))
                        .andDo(print()).andExpect(status().isBadRequest())
                        .andExpect(content().contentType("application/json"))
                        .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
        //Modify student
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("MethodArgumentNotValidException"));
    }

    @Test
    public void registerStudentEndpointTest() throws Exception{
        String payload= writer.writeValueAsString(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
        //Register already existing student.
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void modifyStudentEndpointTest() throws Exception{
        String payload= writer.writeValueAsString(student);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
        //Modifying already existing student.
        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void getStudentEndpointTestOk() throws Exception{
        Long id= 1L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",id))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.id").value(id));
    }
    @Test
    public void getStudentEndpointTestNotFound() throws Exception{
        Long id= 7777L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}",id))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id "+id+" no se encuetra registrado."));
    }
    @Test
    public void removeStudentEndpointTestOk() throws Exception{
        Long id= 1L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",id))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void removeStudentEndpointTestNotFound() throws Exception{
        Long id= 378423L;
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}",id))
                .andDo(print()).andExpect(status().isOk());
    }
    @Test
    public void listStudentsEndpointTestOk() throws Exception{
        this.mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.size()").value(2));
    }

}
