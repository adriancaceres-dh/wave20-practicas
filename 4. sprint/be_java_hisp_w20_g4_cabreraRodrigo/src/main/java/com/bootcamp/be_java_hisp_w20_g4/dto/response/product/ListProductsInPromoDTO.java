package com.bootcamp.be_java_hisp_w20_g4.dto.response.product;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ListProductsInPromoDTO {
    private Integer user_id;
    private String user_name;
    private List<PromoPostDTO> posts;
}
