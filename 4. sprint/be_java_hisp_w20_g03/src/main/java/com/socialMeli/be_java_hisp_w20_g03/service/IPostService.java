package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.Request.PromoPostRequestDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.Response.PromoPostCountDTO;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);
    String addPromoPost(PromoPostRequestDTO promoPostDto);
    PromoPostCountDTO getPromoProducts(int userId);
}
