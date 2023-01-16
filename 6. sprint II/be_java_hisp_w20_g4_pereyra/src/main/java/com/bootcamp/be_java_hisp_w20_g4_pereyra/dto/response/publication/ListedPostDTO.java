package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Category;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductResponseDTO product;
    private Category category;
    private double price;
}
