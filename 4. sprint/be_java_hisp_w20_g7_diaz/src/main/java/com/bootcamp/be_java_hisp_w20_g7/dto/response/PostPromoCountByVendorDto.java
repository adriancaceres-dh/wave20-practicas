package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostPromoCountByVendorDto {

    private int userId;
    private String userName;
    private int promoProductsCount;
}
