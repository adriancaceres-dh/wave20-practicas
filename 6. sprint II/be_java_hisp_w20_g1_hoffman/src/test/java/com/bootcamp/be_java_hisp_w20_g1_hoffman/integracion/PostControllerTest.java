package com.bootcamp.be_java_hisp_w20_g1_hoffman.integracion;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.util.TestUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ModelMapper mapper = new ModelMapper();

    static ObjectWriter writer;


    @BeforeAll
    public static void setUpAll() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void lastTwoWeeksPostsFromFollowers(int id) throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", id)).
                andDo(print()).
                andExpect(status().isOk()).
                andExpect(content().contentType("application/json")).
                andExpect(jsonPath("$.posts").isArray()).
                andReturn();
    }

    @Test
    void addPost() throws Exception {
        //arrange
        PostRequestDto postDto = TestUtil.getPostRequestDto();
        String payloadJson = writer.writeValueAsString(postDto);
        PostResponseDto responseDto = mapper.map(postDto, PostResponseDto.class);
        responseDto.setPostId(7); //el ultimo post cargado en el archivo json tiene id 6, como se autoincrementa en 1, el valor de id necesario para el nuevo post es 7.
        String response = writer.writeValueAsString(responseDto);

       //act
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post").
                contentType(MediaType.APPLICATION_JSON).
                content(payloadJson)).
                andExpect(status().isCreated()).
                andExpect(content().contentType("application/json")).
                andReturn();

        //assert
        Assertions.assertEquals(response, result.getResponse().getContentAsString());
    }

}
