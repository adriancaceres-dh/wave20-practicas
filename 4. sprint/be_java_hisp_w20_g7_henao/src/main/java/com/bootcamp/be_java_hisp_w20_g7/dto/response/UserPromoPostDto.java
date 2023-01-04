package com.bootcamp.be_java_hisp_w20_g7.dto.response;

import com.bootcamp.be_java_hisp_w20_g7.dto.PromoPostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserPromoPostDto {

    private int userId;
    private List<PromoPostDto> posts;


}
