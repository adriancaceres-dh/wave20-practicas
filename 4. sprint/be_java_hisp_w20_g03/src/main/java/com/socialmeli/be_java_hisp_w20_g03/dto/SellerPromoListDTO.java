package com.socialmeli.be_java_hisp_w20_g03.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class SellerPromoListDTO {
  private int userId;
    private String userName;
    private List<PromoPostDTO> posts;


}
