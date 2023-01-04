package com.bootcamp.be_java_hisp_w20_g6.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.FollowersListResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostPromoCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostPromoListResponseDto;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
    public PostPromoCountResponseDto postPromoCount(int user_id);

    public PostPromoListResponseDto promoPosts(int user_id);
}
