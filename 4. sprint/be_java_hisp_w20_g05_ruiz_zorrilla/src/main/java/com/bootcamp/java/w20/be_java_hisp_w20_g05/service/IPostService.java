package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequest;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts.PromoPostCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_posts.PromoPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order);
    public Post newPost(PostRequestDTO postRequestDTO);

    void newPromoPost(PromoPostRequest request);

    PromoPostCountDTO getPromoPostCount(int userId);
    PromoPostsResponse getPromoPosts(int userId);
}
