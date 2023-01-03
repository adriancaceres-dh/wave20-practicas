package com.bootcamp.be_java_hisp_w20_g6_villamizar.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response.PromoPostCountResponseDto;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
    public PromoPostCountResponseDto getPromosCount(int id);
}
