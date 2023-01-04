package com.bootcamp.be_java_hisp_w20_g7.dto.request;

import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private ProductDto product;
    private int category;
    private double price;

}
