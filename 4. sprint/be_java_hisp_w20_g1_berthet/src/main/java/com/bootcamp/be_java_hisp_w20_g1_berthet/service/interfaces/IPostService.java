package com.bootcamp.be_java_hisp_w20_g1_berthet.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.request.PromoPostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoCounResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostPromoListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1_berthet.model.Post;

import java.util.List;

public interface IPostService {
    PostListResponseDto lastTwoWeeksPostsFromFollowers(int id, String order);
    boolean add(PostRequestDto postDto);

    PromoPostRequestDto addPromoPost(PromoPostRequestDto promoPost);

    List<Post> getPromoPostsByUserId(int userId);
    PostPromoCounResponseDto countPromoPosts(int userId);

    PostPromoListResponseDto getPromoPosts(int id);
}
