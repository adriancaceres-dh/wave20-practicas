package com.bootcamp.be_java_hisp_w20_g6.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostDiscountCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListDiscountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
    public PostDiscountCountResponseDto getPostCountDiscount(int user_id);
    public PostListDiscountResponseDto postDiscountBySeller(int sellerId);
}
