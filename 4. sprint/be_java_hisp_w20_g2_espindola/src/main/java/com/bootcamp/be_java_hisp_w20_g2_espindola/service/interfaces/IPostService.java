package com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request.PostPromoRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO);

    void createPromoPost(PostPromoRequestDTO postPromoRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);

    PostPromoCountResponseDTO countPromotionPosts(int userId);

}
