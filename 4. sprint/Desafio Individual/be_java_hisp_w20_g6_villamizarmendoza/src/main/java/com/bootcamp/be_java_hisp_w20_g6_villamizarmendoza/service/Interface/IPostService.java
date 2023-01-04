package com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PostListResponseDTO;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PromoPostCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizarmendoza.dto.response.PromoPostListResponseDTO;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
    public PromoPostCountResponseDto getPromosCount(int id);
    public PromoPostListResponseDTO getPromoPostList(int user_id, String orderBy);

}
