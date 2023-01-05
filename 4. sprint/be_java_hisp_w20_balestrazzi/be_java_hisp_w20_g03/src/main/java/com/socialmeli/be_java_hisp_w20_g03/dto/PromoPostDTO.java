package com.socialmeli.be_java_hisp_w20_g03.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PromoPostDTO extends PostDTO {
    private boolean hasPromo = false;
    private double discount = 0;

}
