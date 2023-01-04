package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoProductsCountDto {

    private int userId;
    private String userName;
    private long promoProductsCount;

}
