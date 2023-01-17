package com.bootcamp.be_java_hisp_w20_g1;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.event.annotation.BeforeTestClass;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
@TestInstance(Lifecycle.PER_CLASS)
public class integrationTest {
    @Autowired
    private MockMvc mockMvc;

    private List<PostRequestDto> posts;

    @BeforeAll
    public void setup() {
        // en este método vamos a definir nuestro setup, es decir, los datos de test que vamos a utilizar en gran parte de nuestro proyecto.
        PostRequestDto post = new PostRequestDto(); // creamos nuestro objeto dto y empezamos a preparar nuestro payload para enviárselo al método.
        LocalDate date = LocalDate.now();
        post.setDate(date);
        post.setUserId(2);
        ProductRequestDto product = new ProductRequestDto();
        product.setProductId(20);
        product.setProductName("Galletas");
        product.setType("Alimentos");
        product.setBrand("Oreo");
        product.setColor("Marrones");
        product.setNotes("Deliciosas galletas");
        post.setProduct(product);
        post.setCategory(4);
        post.setPrice(50.0);
        posts = new ArrayList<>();
        posts.add(post);
        post = new PostRequestDto();
        LocalDate baddate = LocalDate.of(2022, 10, 29);
        post.setDate(baddate);
        post.setUserId(2);
        product = new ProductRequestDto();
        product.setProductId(21);
        product.setProductName("Fideos Chinos");
        product.setType("Alimentos");
        product.setBrand("Wahuuu");
        product.setColor("Marrones");
        product.setNotes("Fideos feos");
        post.setProduct(product);
        post.setCategory(4);
        post.setPrice(5000.0);
        posts.add(post);

        post = new PostRequestDto();
        LocalDate yesterday = date.minusDays(1);
        post.setDate(yesterday);
        post.setUserId(2);
        product = new ProductRequestDto();
        product.setProductId(22);
        product.setProductName("Televisores");
        product.setType("Teles");
        product.setBrand("Wahuuu");
        product.setColor("Negros");
        product.setNotes("Una tele trucha");
        post.setProduct(product);
        post.setCategory(5);
        post.setPrice(5000000.10);
        posts.add(post);
    }

    @Test
    @Order(1)
    void shouldInsertANewPost() throws Exception {
// Vamos a insertar los posts de nuestro setup.
        for (PostRequestDto payloadDto : posts) {
            ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
            String payloadJson = writer.writeValueAsString(payloadDto); // convertimos nuestro objeto dto a String.

            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print())
                    .andExpect(status().isCreated()).andReturn();
        }
    }

    @Test
    @Order(2)
    void shouldReturnAnInvalidParam() throws Exception {
        // Vamos a ponerle un precio indebido al producto y vamos a testear que dé error.
        // Esto se puede hacer para todos los campos, para asegurar que todas las validaciones estén OK.

        PostRequestDto payloadDto = new PostRequestDto(); // creamos nuestro objeto dto y empezamos a preparar nuestro payload para enviárselo al método.
        LocalDate fecha = LocalDate.now();
        payloadDto.setDate(fecha);
        payloadDto.setUserId(0);
        ProductRequestDto product = new ProductRequestDto();
        product.setProductId(20);
        product.setProductName("Galletas");
        product.setType("Alimentos");
        product.setBrand("Oreo");
        product.setColor("Marrones");
        product.setNotes("Deliciosas galletas");
        payloadDto.setProduct(product);
        payloadDto.setCategory(4);
        payloadDto.setPrice(0.0);
        ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).configure(SerializationFeature.WRAP_ROOT_VALUE, false).writer();
        String payloadJson = writer.writeValueAsString(payloadDto); // convertimos nuestro objeto dto a String.

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post").contentType(MediaType.APPLICATION_JSON).content(payloadJson)).andDo(print())
                .andExpect(status().isBadRequest()).andReturn();

    }
}
