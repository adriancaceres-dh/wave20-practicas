package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    PostResponseDto add(PostRequestDto postDto);
    PostPromoResponseDto add(PostPromoRequestDto postDto);
    UserPromoPostsCountResponseDto promoPostsCountByUser(int id);
    PostPromoListResponseDto promoProductsByUserId(int userId);
}
