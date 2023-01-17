package com.bootcamp.be_java_hisp_w20_g7.integration;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.service.IPostService;
import com.bootcamp.be_java_hisp_w20_g7.service.UserService;
import com.bootcamp.be_java_hisp_w20_g7.utils.TestUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Condition;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.swing.text.Utilities;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    IPostService postService;

    @Autowired
    UserService userService;

    private static ObjectWriter objectWriter;
    @BeforeAll
    static void wsetUp(){
        objectWriter = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE,false).writer();
    }
    @Test
    public void mustReturnUserNotFoundException() throws Exception{

        //Arrange
        PostCreateDto postCreateDto = TestUtils.postCreateDtos().get(0);
        //String payload = objectWriter.writeValueAsString(postCreateDto);
        String payload = """
                                 {
                                 "user_id":13,
                                 "date": "29-04-2021",
                                 "product": {
                                     "product_id": 3,
                                     "product_name": "Silla Gamer",
                                     "type": "Gamer",
                                     "brand": "Racer",
                                     "color": "Red & Black",
                                     "notes": "Special Edition"
                                 },
                                 "category": 100,
                                 "price": 10000000
                             }""";
        String expectedMessage = "UserNotFoundException";

        //Act and Assert
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .content(payload)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value(expectedMessage));
    }

    @Test
    public void mustReturnUserFollowersInAscendentOrder() throws Exception{

        //Arrange
        PostCreateDto postCreateDto = TestUtils.postCreateDtos().get(0);
        String expected= """
                {"user_id":5,"user_name":"Nathalia","followed":[{"user_id":2,"user_name":"Manuel"},{"user_id":4,"user_name":"Ronald"}]}""";


        //Act and Assert
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list",5).param("order","name_asc"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        Assertions.assertEquals(expected,result.getResponse().getContentAsString());
    }
}
