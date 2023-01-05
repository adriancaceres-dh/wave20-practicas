package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostPromoRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.CountProductWithDiscountDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ListOfProductsWithDiscountDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.postResponsePromoDto;

import java.util.List;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    PostResponseDto add(PostRequestDto postDto);
    postResponsePromoDto addWithPromo (PostPromoRequestDto postDto);
    ListOfProductsWithDiscountDto productsWithDiscount(int id);
    CountProductWithDiscountDto CountProductWithDiscount(int id);
}
