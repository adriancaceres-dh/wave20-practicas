package com.bootcamp.be_java_hisp_w20_g4.dto.request;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPostDTO {
    private Integer user_id;
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private double price;
    private boolean has_promo;
    private double discount;
}
