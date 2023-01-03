package com.bootcamp.be_java_hisp_w20_g4.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublicationDiscountDTO {
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private double price;
}
