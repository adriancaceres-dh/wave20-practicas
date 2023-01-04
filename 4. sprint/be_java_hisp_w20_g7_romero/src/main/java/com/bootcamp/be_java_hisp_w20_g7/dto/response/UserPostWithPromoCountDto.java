package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserPostWithPromoCountDto {

    private int userId;
    private String userName;
    private int promoProductsCount;
}
