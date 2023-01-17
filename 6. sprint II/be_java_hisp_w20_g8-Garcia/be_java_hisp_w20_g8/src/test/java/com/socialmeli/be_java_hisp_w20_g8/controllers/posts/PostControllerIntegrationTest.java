package com.socialmeli.be_java_hisp_w20_g8.controllers.posts;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;
    private PostRequestDTO postRequestDTO;
    private PostRequestDTO postRequestDTOPromo;


    public PostControllerIntegrationTest() {
         postRequestDTO = PostRequestDTO.builder().user_id(6).date(LocalDate.of(2022, 11, 12)).productDTO(
                ProductDTO.builder().product_id(4).product_name("Shirt").type("Clothes").brand("Woft").color("Black").notes("Sports shirt").build()
        ).category(1).price(2.000).build();


        postRequestDTOPromo = PostRequestDTO.builder().user_id(6).date(LocalDate.of(2022, 11, 12)).productDTO(
                ProductDTO.builder().product_id(4).product_name("Shirt").type("Clothes").brand("Woft").color("Black").notes("Sports shirt").build()
        ).category(1).price(2.000).has_promo(true).discount(2.0).build();

    }

    @Test
    @DisplayName("TI-Find all posts by id user")
    void findAllPostByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_user").value(1))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Find all posts by id user invalid")
    void findAllPostByIdUserIvalidIdTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 5))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist user"))
                .andReturn();
    }

    @Test
    @DisplayName("TI-count post promo by id user")
    void countPostPromoByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "5"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(5))
                .andReturn();
    }

    @Test
    @DisplayName("TI-count post promo by id user invalid")
    void countPostPromoByIdUserInvalidTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/count")
                        .param("user_id", "1"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist id"))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Find all products promo by id user")
    void findAllProductsPromoByIdUserTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list")
                .param("user_id", "5"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id_user").value(5))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Find all products promo by id user invalid")
    void findAllProductsPromoByIdUserInvalidTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/products/promo-post/list")
                        .param("user_id", "1"))
                .andDo(print()).andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("Doesn't exist id"))
                .andReturn();
    }

    @Test
    @DisplayName("TI-Create new post")
    void createNewPostTest() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = objectWriter.writeValueAsString(postRequestDTO);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }

    @Test
    @DisplayName("TI-Create new post promo")
    void createNewPostPromoTest() throws Exception{
        ObjectWriter objectWriter = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = objectWriter.writeValueAsString(postRequestDTOPromo);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/products/promo-post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
    }
}
