package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserPromoProductsCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserPromoProductsListResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO,boolean promotion);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);

    UserPromoProductsCountResponseDTO getPromotionProductsQuantity(int userId);
    UserPromoProductsListResponseDTO getPromotionProductsList(int userId);

}
