package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PromosAmountDTO;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    String createPost(PostDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);

    String createPromoPost(PromoPostRequestDTO postRequestDTO);

    PromosAmountDTO getAmountOfPromos(int userId);

    PostResponseDTO listPromosFromUser(int userId, Optional<String> order);

    List<PostWithIdDTO> listPromos(Optional<String> order);
}
