package com.bootcamp.be_java_hisp_w20_g4.dto.response.product;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostPromotionDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductsPromotionSellerDTO {

    private int user_id;
    private String user_name;
    private List<PostPromotionDTO> posts;

}
