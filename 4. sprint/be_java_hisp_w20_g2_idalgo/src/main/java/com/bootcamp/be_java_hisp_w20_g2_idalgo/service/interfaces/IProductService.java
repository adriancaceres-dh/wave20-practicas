package com.bootcamp.be_java_hisp_w20_g2_idalgo.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.response.PromosAmountDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    String createPost(PostDTO postRequestDTO);

    PostResponseDTO<PostWithIdDTO> sendLastPostOfFollowed(int userId, Optional<String> order);

    String createPromoPost(PromoPostRequestDTO postRequestDTO);

    PromosAmountDTO getAmountOfPromos(int userId);

    PostResponseDTO<PostWithPromoDTO> listPromosFromUser(int userId, Optional<String> order);

    List<PostWithPromoDTO> listPromos(Optional<String> order);
}
