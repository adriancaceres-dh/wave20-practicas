package com.socialmeli.be_java_hisp_w20_g03.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SellerPromoCountDTO {
    private int userId;
    private String userName;
    private int promoCount;

}
