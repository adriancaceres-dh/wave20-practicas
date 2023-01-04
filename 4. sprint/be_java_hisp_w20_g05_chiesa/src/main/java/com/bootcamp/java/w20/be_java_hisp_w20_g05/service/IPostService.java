package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostPromoRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order);
    public Post newPost(PostRequestDTO postRequestDTO);
    Post newPostPromo(PostPromoRequestDTO postRequestDTO);
    PromoCountDTO getPromoCountByUserId(int userId);
    PromoListDTO getPromoProductsByUserId(int userId);
}
