package com.bootcamp.be_java_hisp_w20_ramosruiz.service.interfaces;

import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostListResponseDto;
import com.bootcamp.be_java_hisp_w20_ramosruiz.dto.response.PromoPostCountResponseDto;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    PostResponseDto add(PostRequestDto postDto);
    PromoPostCountResponseDto countPromoPost(int userId);
    PostResponseDto addPromo(PromoPostRequestDto postDto);
    PromoPostListResponseDto listPromoPostByUserId(int userId, String order);
}
