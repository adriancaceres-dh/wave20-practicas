package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.socialmeli.be_java_hisp_w20_g8.models.PostPromo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostPromoListDTO {
    private int user_id;
    private String user_name;
    private List<PostPromoDTO> posts;

}
