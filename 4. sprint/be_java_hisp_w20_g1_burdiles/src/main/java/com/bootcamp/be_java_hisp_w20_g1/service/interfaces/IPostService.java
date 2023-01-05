package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;

import java.util.List;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    PostResponseDto add(PostRequestDto postDto);

    PostPromoResponseDto addPromo(PostPromoRequestDto postPromo);
    PostPromoCountResponseDto countPromoPost(int userId);
    PostPromoListByUserResponseDto promoPostListByUser(int userId);



}
