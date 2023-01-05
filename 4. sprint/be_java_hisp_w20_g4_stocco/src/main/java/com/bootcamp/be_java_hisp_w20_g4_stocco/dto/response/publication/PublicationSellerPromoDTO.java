package com.bootcamp.be_java_hisp_w20_g4_stocco.dto.response.publication;

import com.bootcamp.be_java_hisp_w20_g4_stocco.dto.request.PostPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PublicationSellerPromoDTO {
    private  Integer user_id;
    private String user_name;
    private List<PostPromoDTO> posts;
}
