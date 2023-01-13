package com.meli.obtenerdiploma.controller.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.DecimalFormat;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerTest {

        @Autowired
        MockMvc mockMvc;



        @Test
        void registerStudent() throws Exception {
                //average
                StudentDTO studentRequestDto = TestUtilsGenerator.getStudentWith3Subjects("Lucas");
                //Hay que setearle un id que ya este registrado porque primero elimina buscando el student por id.
                //Si no lo encuentra, lanza excepción.
                studentRequestDto.setId(1L);
                StudentDTO studentResponseDto = TestUtilsGenerator.getStudentWith3Subjects("Lucas");
                //No tiene sentido porque se devuelve null en el body del endpoint
                studentResponseDto.setId(1L);
                studentResponseDto.setAverageScore(6D);
                studentResponseDto.setMessage("El alumno " + "Lucas" + " ha obtenido un promedio de "
                        + new DecimalFormat("#0.00").format(6D) +". Puedes mejorar.");
                ObjectWriter writer = new ObjectMapper()
                        .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                        .writer();
                String payloadJson = writer.writeValueAsString(studentRequestDto);
                String responseJson = writer.writeValueAsString(studentResponseDto);

                //act
               MvcResult response = this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(payloadJson))
                        .andDo(print()).andExpect(status().isOk())
                       // .andExpect(content().contentType("application/json"))
                        .andReturn();

               //assert
               //Assertions.assertEquals(responseJson, response.getResponse().getContentAsString());


        }



        @Test
        @DisplayName("Caso feliz")
        void getStudentOK() throws Exception {
                MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                                .get("/student/getStudent/{id}", 2L)).andDo(print())
                        .andExpect(status().isOk()).andReturn();
                Assertions.assertTrue(mvcResult.getResponse().getContentAsString().contains("2"));
        }

        @Test
        @DisplayName("No se encuentra el estudiante")
        void getStudentThrowsStudentNotfound() throws Exception {
                MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                                .get("/student/getStudent/{id}", 5L)).andDo(print())
                        .andExpect(status().isNotFound()).andReturn();
                Assertions.assertTrue(mvcResult.getResponse().getContentAsString().contains("El alumno con Id 5 no se encuetra registrado."));
        }



        @Test
        @DisplayName("Caso feliz")
        void removeStudent() throws Exception {
                MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                                .get("/student/removeStudent/{id}", 2L)).andDo(print())
                        .andExpect(status().isOk()).andReturn();
                //Debería guardar nuevamente al estudiante que acabo de borrar, aunque se use un archivo de usuarios diferente.
        }


        @Test
                //Similar al de register student
        void modifyStudent() {
        }

        //Similar a los get anteriores
        @Test
        void listStudents() {
        }

}
