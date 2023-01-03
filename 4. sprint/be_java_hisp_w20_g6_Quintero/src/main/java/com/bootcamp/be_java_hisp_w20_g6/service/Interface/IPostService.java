package com.bootcamp.be_java_hisp_w20_g6.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.DiscountPostCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6.dto.response.PostListResponseDTO;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
    DiscountPostCountResponseDTO countDiscountPost(int sellerId);

}
