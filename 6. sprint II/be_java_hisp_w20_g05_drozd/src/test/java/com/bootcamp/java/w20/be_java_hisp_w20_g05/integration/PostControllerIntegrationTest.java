package com.bootcamp.java.w20.be_java_hisp_w20_g05.integration;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.ProductRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    @BeforeAll
    public static void setUp(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();
    }
    @Test
    @DisplayName("T-0010 Ok")
    public void newPostTestEndpointOk() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":2.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    @DisplayName("T-0010 Validate_User_Id_Min")
    public void newPostTestMethodArgumentNotValidException1() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","Notes");
        String payload="{\"user_id\":0,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":2.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El Id debe ser mayor a 0."));
    }

    @Test
    @DisplayName("T-0010 Validate_Date_Null")
    public void newPostTestMethodArgumentNotValidException2() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":null,\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":2.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("La fecha no puede estar vacia."));
    }

    @Test
    @DisplayName("T-0010 Validate_Price_Min")
    public void newPostTestMethodArgumentNotValidException4() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":-1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El precio no puede ser menor a 0"));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Id_Min")
    public void newPostTestMethodArgumentNotValidException5() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(0,"Name","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El id debe ser mayor a 0"));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Name_Empty")
    public void newPostTestMethodArgumentNotValidException6() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo no puede estar vacio."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Name_Special")
    public void newPostTestMethodArgumentNotValidException7() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"N@me","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo product-name no puede tener caracteres especiales."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Name_Size")
    public void newPostTestMethodArgumentNotValidException8() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Naksjdbsahjdbsahjkdbaskdabsdksndjkndhjbqwhjdbfkjnekjfnekjfbehfbekjfnejdnifhddfadjjsdhshjd","Type","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("La longitud no puede superar los 40 caracteres."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Type_Empty")
    public void newPostTestMethodArgumentNotValidException9() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo no puede estar vacio."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Type_Size")
    public void newPostTestMethodArgumentNotValidException10() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Typeeeeeeeeeeeeeeeeeeeeeeeeeee","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("La longitud no puede superar los 15 caracteres."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Type_Special")
    public void newPostTestMethodArgumentNotValidException11() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Typ%","Brand","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo type no puede tener caracteres especiales."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Brand_Special")
    public void newPostTestMethodArgumentNotValidException12() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Bra#nd","Color","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo brand no puede tener caracteres especiales."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Color_Empty")
    public void newPostTestMethodArgumentNotValidException13() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand",null,"Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo no puede estar vacio."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Color_Special")
    public void newPostTestMethodArgumentNotValidException14() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Co lor","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo color no puede tener caracteres especiales."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Color_Size")
    public void newPostTestMethodArgumentNotValidException15() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Colorrrrrrrrrrrrrrrrrrrrr","Notes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("La longitud no puede superar los 15 caracteres."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Notes_Size")
    public void newPostTestMethodArgumentNotValidException16() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","Notes".repeat(80));
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("La longitud no puede superar los 80 caracteres."));
    }

    @Test
    @DisplayName("T-0010 Validate_Product_Notes_Special")
    public void newPostTestMethodArgumentNotValidException17() throws Exception{
        ProductRequestDTO productRequestDTO= new ProductRequestDTO(1,"Name","Type","Brand","Color","N|tes");
        String payload="{\"user_id\":1,\"date\":\"02-04-2022\",\"product\":"+writer.writeValueAsString(productRequestDTO)+",\"category\":1,\"price\":1.0}";

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print()).andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.messageException").value("El campo no puede tener caracteres especiales."));
    }


}

