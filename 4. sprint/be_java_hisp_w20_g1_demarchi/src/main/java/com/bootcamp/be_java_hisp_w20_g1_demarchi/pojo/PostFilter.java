package com.bootcamp.be_java_hisp_w20_g1_demarchi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostFilter {
    private double minPrice;
    private double maxPrice;
    private double minDiscount;
    private int category;
}
