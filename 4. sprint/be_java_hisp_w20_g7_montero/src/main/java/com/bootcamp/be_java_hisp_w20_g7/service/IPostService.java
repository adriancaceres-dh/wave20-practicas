package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostPromoCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PromoProductsCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PromoProductsDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;

public interface IPostService {

    String createPost(PostCreateDto postCreateDto);

    String createPromoPost(PostPromoCreateDto promoPost);

    void calculateId(Post post);

    UserPostFollowedDto postUsersFollowed(int userId, String order);

    PromoProductsCountDto countProductPromo(int userId);

    PromoProductsDto promoProductsList(int userId);
}
