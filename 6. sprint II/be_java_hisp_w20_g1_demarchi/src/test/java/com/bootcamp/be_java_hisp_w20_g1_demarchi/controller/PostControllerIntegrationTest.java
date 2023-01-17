package com.bootcamp.be_java_hisp_w20_g1_demarchi.controller;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_demarchi.dto.request.ProductRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.matchesPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    private static final String TIMESTAMP_REGEX = "\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{6}";
    private static ObjectWriter writer;


    @BeforeAll
    public static void setUpAll() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @Test
    @DisplayName("T14: cuando se envía un post valido se muestra el post que se ha agregado")
    public void givenAValidPostRequest_whenPosting_thenPostIsSaved() throws Exception {
        PostRequestDto postRequestDto = PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(getValidProduct())
                .category(3)
                .price(300d)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestDto)))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.post_id").value(7))
                .andExpect(MockMvcResultMatchers.jsonPath("$.product.product_id").value(66));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con una variable con tipo incorrecto, se muestra mensaje de error")
    public void givenAPostWithInvalidVariableType_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        String invalidTypeForUserId = "{\"user_id\":\"userIdString\"}";

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidTypeForUserId))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Tipo de dato inválido en user_id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(400))
                .andExpect(MockMvcResultMatchers.jsonPath("$.timestamp", matchesPattern(TIMESTAMP_REGEX)));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con una categoría inválida (0) se muestra mensaje de error")
    public void givenAPostWithInvalidCategory_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        PostRequestDto postRequestWithInvalidCategory = PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(getValidProduct())
                .category(0)
                .price(300d)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithInvalidCategory)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("category"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].rejected_value").value(0))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El campo debe ser mayor a 0"));
    }

    @Test
    @DisplayName("T14: cuando se envía un post sin categoría se muestra mensaje de error")
    public void givenAPostWithoutCategory_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        PostRequestDto postRequestWithMissingCategory = PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(getValidProduct())
                .price(300d)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithMissingCategory)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("category"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].rejected_value").value("empty field"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El campo no puede estar vacío"));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con un id inválido (0) se muestra mensaje de error")
    public void givenAPostWithAnInvalidId_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        PostRequestDto postRequestWithInvalidUserId = PostRequestDto.builder()
                .userId(0)
                .date(LocalDate.now())
                .product(getValidProduct())
                .category(3)
                .price(300d)
                .build();

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithInvalidUserId)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("userId"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El id debe ser mayor a 0"));
    }

    @Test
    @DisplayName("T14: cuando se envía un post sin producto se muestra mensaje de error")
    public void givenAPostWithoutProduct_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        PostRequestDto postRequestWithoutProduct = PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(null)
                .category(3)
                .price(300d)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithoutProduct)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("product"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("Debe ingresar un producto"));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con un precio mayor al permitido se muestra mensaje de error")
    public void givenAPostWithInvalidPrice_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        PostRequestDto postRequestWithHugePrice = PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(getValidProduct())
                .category(3)
                .price(300_000_000d)
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithHugePrice)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("price"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El precio máximo por producto es de 10.000.000"));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con un producto con nombre inválido se muestra mensaje de error")
    public void givenAPostWithAnInvalidProductName_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        ProductRequestDto productWithInvalidProductName = ProductRequestDto.builder()
                .productId(66)
                .productName("Som3 prod#ct na@me")
                .type("someType")
                .brand("someBrand")
                .color("someColor")
                .notes("someDummyNotes")
                .build();

        PostRequestDto postRequestWithInvalidProductName = getValidPost(productWithInvalidProductName);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithInvalidProductName)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("product.productName"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].rejected_value").value("Som3 prod#ct na@me"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El campo no puede poseer caracteres especiales."));
    }

    @Test
    @DisplayName("T14: cuando se envía un post con un producto con id inválido se muestra mensaje de error")
    public void givenAPostWithAProductWithInvalidId_whenSaving_thenAnErrorMessageIsShown() throws Exception {
        ProductRequestDto productWithInvalidProductId = ProductRequestDto.builder()
                .productId(0)
                .productName("Some product name")
                .type("someType")
                .brand("someBrand")
                .color("someColor")
                .notes("someDummyNotes")
                .build();

        PostRequestDto postRequestWithInvalidProductName = getValidPost(productWithInvalidProductId);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestWithInvalidProductName)))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Campos inválidos o faltantes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].field").value("product.productId"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].rejected_value").value("0"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.invalid_validations[0].reason").value("El id debe ser mayor a 0"));
    }

    @Test
    @DisplayName("T15: Obtener un listado de las publicaciones realizadas por los vendedores que un usuario sigue en las últimas dos semanas")
    public void givenAnIdOfASellerWithFollowers_whenGettingFollowers_thenFollowersResponseIsShown() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts", hasSize(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.posts[0].date").value("14-01-2023"));
    }


    private ProductRequestDto getValidProduct() {
        return ProductRequestDto.builder()
                .productId(66)
                .productName("Some product name")
                .type("someType")
                .brand("someBrand")
                .color("someColor")
                .notes("someDummyNotes")
                .build();
    }

    private PostRequestDto getValidPost(ProductRequestDto productRequestDto) {
        return PostRequestDto.builder()
                .userId(1)
                .date(LocalDate.now())
                .product(productRequestDto)
                .category(3)
                .price(300d)
                .build();
    }

}