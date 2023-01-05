package com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoDTO {
    private Integer user_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
