package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromoPostListResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO);
    void createPromoPost(PromoPostRequestDTO promoPostRequestDTO);
    PromoPostCountResponseDTO getPromoPostCount(int userId);
    PromoPostListResponseDTO getPromoPostList(int userId);
    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);
}
