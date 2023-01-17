package com.bootcamp.be_java_hisp_w20_g7.integration;

import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.service.IPostService;
import com.bootcamp.be_java_hisp_w20_g7.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class IntegrationTests {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    IPostService postService;

    @Autowired
    UserService userService;


    @Test
    public void mustReturnUserNotFoundException(){

        //Arrange
        String expectedMessage = "UserNotFoundException";

        //Act
        this.mockMvc.perform(MockMvcRequestBuilders.post())


        //Assert
    }
}
