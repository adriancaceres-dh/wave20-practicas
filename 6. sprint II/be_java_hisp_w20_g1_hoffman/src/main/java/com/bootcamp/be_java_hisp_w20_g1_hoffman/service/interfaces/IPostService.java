package com.bootcamp.be_java_hisp_w20_g1_hoffman.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.PostResponseDto;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);

    PostResponseDto add(PostRequestDto postDto);
}
