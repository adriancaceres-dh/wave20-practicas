package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.interfaces.BasePostDto;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    PostResponseDto add(PostRequestDto postDto);

    PromoPostResponseDto addPromoPost(PromoPostRequestDto promoPost);

    //PromoPostCountDto getSellerPromoProducts(int userId);

    //List<PromoPostResponseDto> getListSellerPromoProducts(int userId);

    List<BasePostDto> getSellerPromoProducts(int userId, boolean list,  Optional<String> order);

    PromoPostResponseDto modifyPost(PromoPostRequestDto postDto);
}
