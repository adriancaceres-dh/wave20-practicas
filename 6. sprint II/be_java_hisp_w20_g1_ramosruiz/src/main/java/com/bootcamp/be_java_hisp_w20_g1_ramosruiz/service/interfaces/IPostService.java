package com.bootcamp.be_java_hisp_w20_g1_ramosruiz.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_ramosruiz.dto.response.PostResponseDto;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);

    PostResponseDto add(PostRequestDto postDto);
}
