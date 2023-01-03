package com.bootcamp.be_java_hisp_w20_g6.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PromoCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PromoPostListResponseDto;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);

    public PromoCountResponseDto countPromoProducts(int user_id);

    public PromoPostListResponseDto getPromoProducts(int user_id);
}
