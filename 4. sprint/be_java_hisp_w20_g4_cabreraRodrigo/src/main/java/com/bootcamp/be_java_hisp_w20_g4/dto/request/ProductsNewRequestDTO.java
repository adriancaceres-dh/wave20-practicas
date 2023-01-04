package com.bootcamp.be_java_hisp_w20_g4.dto.request;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductsNewRequestDTO {
    private Integer user_id;
    private LocalDate date;
    private List<ProductDTO> posts;
    private Integer category;
    private Double price;

}
