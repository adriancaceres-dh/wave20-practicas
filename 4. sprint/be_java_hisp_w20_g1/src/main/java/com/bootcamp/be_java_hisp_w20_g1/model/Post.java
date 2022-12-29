package com.bootcamp.be_java_hisp_w20_g1.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private int productId;
    private LocalDate creationDate;
    private int categoryId;
    private double price;
    private boolean hasPromo;
    private double discount;
}
