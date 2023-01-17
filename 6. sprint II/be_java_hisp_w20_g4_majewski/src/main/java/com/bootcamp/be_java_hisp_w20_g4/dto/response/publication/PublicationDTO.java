package com.bootcamp.be_java_hisp_w20_g4.dto.response.publication;


import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductResponseDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class PublicationDTO {
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;
    private ProductResponseDTO product;
    private Integer category;
    private double price;
}
