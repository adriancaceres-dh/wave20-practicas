package com.bootcamp.be_java_hisp_w20_g1.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoCountResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    boolean add(PostRequestDto postDto);
    PostPromoCountResponseDto promoPostCountByUser(int userId);
    PostListResponseDto promoPostListByUser(int userId);
}
