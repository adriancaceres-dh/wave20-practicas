package com.socialmeli.be_java_hisp_w20_g8.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostDTO {
    private int userId;
    private int post_id;
    private LocalDate date;
    private ProductDTO product;
    private int caregory;
    private double price;


}
