package com.bootcamp.be_java_hisp_w20_g7.controller;


import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("Aplicación de Test de Integración a US0002")
public class Test_T0009_US0002AplicationTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    @Test
    void followShouldBeZero() throws Exception{
        countFollowersTest(1,0);
    }

    @Test
    void followShouldBeOne() throws Exception{
        countFollowersTest(4,1);
    }

    @Test
    void followShouldBeTwo() throws Exception{
        countFollowersTest(2,1);
    }

    @Test
    void followShouldBeFour() throws Exception{
        countFollowersTest(3,4);
    }

    private void countFollowersTest(int userId, int followersCountExpected) throws Exception {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy( new PropertyNamingStrategies.SnakeCaseStrategy());

        //Obtener el resultado de la cantidad de usuarios que siguen a un determinado vendedor
        MvcResult mvcResult = this.mockMvc.perform(get("/users/"+userId+"/followers/count"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        UserFollowersCountDto postDtoResponse = objectMapper.readValue(contentAsString, UserFollowersCountDto.class);

        assertEquals(followersCountExpected, postDtoResponse.getFollowersCount());
    }

}

