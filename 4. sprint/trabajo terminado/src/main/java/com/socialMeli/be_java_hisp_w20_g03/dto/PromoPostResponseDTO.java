package com.socialMeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    //private ProductDTO product;
    private List<PromoPostDTO> post;
   // private int category;
   // private double price;
   // private boolean hasPromo;
    //private double discount;



}
