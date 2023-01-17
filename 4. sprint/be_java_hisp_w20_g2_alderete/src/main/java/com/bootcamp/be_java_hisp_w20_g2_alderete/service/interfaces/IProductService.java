package com.bootcamp.be_java_hisp_w20_g2_alderete.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.request.PromotionRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.response.AmountOfPromotionsDTO;

import java.util.Optional;

public interface IProductService {
    String createPost(PostDTO postRequestDTO);

    PostResponseDTO<PostWithIdDTO> sendLastPostOfFollowed(int userId, Optional<String> order);

    String createPromoPost(PromotionRequestDTO postRequestDTO);

    AmountOfPromotionsDTO getAmountOfPromos(int userId);

    PostResponseDTO<PostPromotionDTO> listPromosFromUser(int userId, Optional<String> order);

}
