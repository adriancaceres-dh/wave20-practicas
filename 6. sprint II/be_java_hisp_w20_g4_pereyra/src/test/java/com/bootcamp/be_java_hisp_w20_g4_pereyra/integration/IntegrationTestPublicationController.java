package com.bootcamp.be_java_hisp_w20_g4_pereyra.integration;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.request.ProductRequestDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPostDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.PublicationDTO;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Category;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.utils.TestUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class IntegrationTestPublicationController {
    @Autowired
    MockMvc mockMvc;

    PostDTO postDTO;
    ProductRequestDTO productRequestDTO;
    ProductResponseDTO productResponseDTO;
    Category category1;
    LocalDate dateForPost;

    @BeforeEach
    void setUp() {
        dateForPost = LocalDate.now().minusDays(5);
        productRequestDTO = new ProductRequestDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        productResponseDTO = new ProductResponseDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        postDTO = new PostDTO(3, dateForPost, productRequestDTO, 10, 1500.50);
        category1 = new Category(10, "football");
    }

    @Test
    @DisplayName("Test de integración de agregar una nueva publicación")
    public void addNewPostTest() throws Exception {
        String postDtoRequestJson = TestUtils.writer.writeValueAsString(postDTO);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO(1, "Silla Gamer", "Gamer", "Racer", "Red Black", "Special Edition");
        PublicationDTO publicationDtoExpected = new PublicationDTO(dateForPost, productResponseDTO, 10, 1500.5);
        String expectedPublicationDto = TestUtils.writer.writeValueAsString(publicationDtoExpected);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedPublicationDto);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(TestUtils.mediaTypeJson)
                        .content(postDtoRequestJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }

    @Test
    @DisplayName("Test de integración - obtener la publicaciones de un usuario de las ultimas 2 semanas")
    public void getLast2WeeksPublicationTest() throws Exception {

        ListedPostDTO expectedListedPostDTO = new ListedPostDTO(3,5, postDTO.getDate(), productResponseDTO, category1, postDTO.getPrice());
        ProductTwoWeeksResponseDTO expectedProductTwoWeeksResponseDTO = new ProductTwoWeeksResponseDTO(1, List.of(expectedListedPostDTO));
        String expectedResponse = TestUtils.writer.writeValueAsString(expectedProductTwoWeeksResponseDTO);

        ResultMatcher expectedStatus = status().isOk();
        ResultMatcher expectedJson = content().json(expectedResponse);
        ResultMatcher expectedContentType = content().contentType(MediaType.APPLICATION_JSON);

        // el usuario 1 sigue al usuario 3
        this.mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,3)
                .contentType(TestUtils.mediaTypeJson));
        // se crea una publicacion para el usuario 3
        String postDtoRequestJson = TestUtils.writer.writeValueAsString(postDTO);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postDtoRequestJson));

        // se consultan las publicaciones de los usuarios que sigue el usuario 1
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list")
                        .contentType(TestUtils.mediaTypeJson))
                .andDo(print())
                .andExpect(expectedStatus)
                .andExpect(expectedJson)
                .andExpect(expectedContentType);
    }

}
