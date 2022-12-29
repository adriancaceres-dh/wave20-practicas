package com.bootcamp.be_java_hisp_w20_g1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {

    private int userId;
    private int postId;
    private LocalDate date;
    private ProductResponseDto product;
    private int category;
    private double price;
}
