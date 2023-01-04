package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostWithDiscountRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order);
    Post newPost(PostRequestDTO postRequestDTO);
    void newPostWithDiscount(PostWithDiscountRequestDTO postWithDiscountRequestDTO);
    UserProductDiscountCountDTO getDiscountUserProducts(int userId);
    UserProductDiscountListDTO getDiscountedUserProductList(int userId);
}
