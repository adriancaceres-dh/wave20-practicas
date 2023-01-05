package com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {
    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;
}