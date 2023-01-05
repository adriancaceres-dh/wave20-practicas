package com.bootcamp.be_java_hisp_w20_g4.dto.response.publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoPublicationListDTO {
    private Integer user_id;
    private String user_name;
    List<ListedPromoPostDTO> posts;
}
