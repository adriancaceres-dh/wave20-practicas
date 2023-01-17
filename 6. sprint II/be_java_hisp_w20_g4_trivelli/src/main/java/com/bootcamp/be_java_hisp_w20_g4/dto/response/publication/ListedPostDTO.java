package com.bootcamp.be_java_hisp_w20_g4.dto.response.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListedPostDTO {
    private Integer user_id;
    private Integer post_id;
    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate date;
    private ProductResponseDTO product;
    private Category category;
    private double price;
}
