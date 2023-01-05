package com.bootcamp.be_java_hisp_w20_g7.dto.request;


import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductPromoDto {
    private int userId;
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDto product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;

}
