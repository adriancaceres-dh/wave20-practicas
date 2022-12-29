package com.bootcamp.be_java_hisp_w20_g4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Publication {
    private int post_id;
    private LocalDate date;
    private double price;
    private boolean hasPromo;
    private double discount;
    private Product product;
    private Category category;
}
