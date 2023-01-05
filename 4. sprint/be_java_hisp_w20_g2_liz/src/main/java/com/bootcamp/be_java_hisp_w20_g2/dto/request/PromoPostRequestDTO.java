package com.bootcamp.be_java_hisp_w20_g2.dto.request;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoPostRequestDTO extends PostDTO {
    boolean hasPromo;
    double discount;
}
