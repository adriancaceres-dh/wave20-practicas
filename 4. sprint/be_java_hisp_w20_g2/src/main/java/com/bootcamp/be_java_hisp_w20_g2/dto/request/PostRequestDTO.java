package com.bootcamp.be_java_hisp_w20_g2.dto.request;

import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor @Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostRequestDTO {
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private String category;
    private double price;
}
