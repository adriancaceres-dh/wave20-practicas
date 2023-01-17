package com.bootcamp.be_java_hisp_w20_g6_villamizar.service.Interface;

import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g6_villamizar.dto.response.PostListResponseDTO;

public interface IPostService {
    public boolean save(PostRequestDto postRequestDto);
    public PostListResponseDTO postFollowedLastWeeks(int user_id, String order);
}
