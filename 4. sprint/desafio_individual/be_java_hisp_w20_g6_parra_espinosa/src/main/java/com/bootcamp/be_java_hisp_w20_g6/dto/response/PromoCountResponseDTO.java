package com.bootcamp.be_java_hisp_w20_g6.dto.response;
import com.bootcamp.be_java_hisp_w20_g6.model.PostModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;



@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PromoCountResponseDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;

}