package com.socialmeli.be_java_hisp_w20_g8.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductDTO {

    private Integer idProduct;
    private String nameProduct;
    private String type;
    private String brand;
    private String color;
    private String note;
}
