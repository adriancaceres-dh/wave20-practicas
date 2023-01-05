package com.bootcamp.be_java_hisp_w20_g2_podio.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.response.PromoPostListByUserIdResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);
    void createPromoPost(PromoPostDTO promoPostRequestDTO);

    PromoPostCountResponseDTO getPromoProductsCountByUserId(int userId);

    PromoPostListByUserIdResponseDTO getPromoPostListByUserId(int userId);
}
