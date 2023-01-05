package com.bootcamp.be_java_hisp_w20_g2.dto.response;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostPromoDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserProductsPromoResponseDTO extends UserResponseDTO{
    private List<PostPromoDTO> posts;

    public UserProductsPromoResponseDTO(int userId, String userName, List<PostPromoDTO> posts) {
        super(userId, userName);
        this.posts = posts;
    }

}
