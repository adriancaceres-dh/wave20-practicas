package com.socialmeli.be_java_hisp_w20_g8.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("findAllPostsByIdUser")
    void testFindAllPostsByIdUserOK(){
        int userId=1;
        String order = "date_asc"; //date_desc - date_asc
        //Ruta: products/followed/{userId}/list

    }


}
