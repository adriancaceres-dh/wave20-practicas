package com.bootcamp.be_java_hisp_w20_g7.dto.request;

import com.bootcamp.be_java_hisp_w20_g7.entity.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostCreateDto {


    private int userId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private Product product; // Deberia ser ProductDto?
    private int category;
    private double price;

}
