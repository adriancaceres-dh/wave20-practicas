package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PromoPostCountDTO {

    private int user_id;
    private String user_name;
    private int promoPostCount;

}
