package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class PostDTO {
    private int user_id;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;

}
