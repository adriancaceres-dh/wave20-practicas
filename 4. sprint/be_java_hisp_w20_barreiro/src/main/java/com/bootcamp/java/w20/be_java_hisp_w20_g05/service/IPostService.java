package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoPostsListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserPostsCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowingUsersPostsResponseDTO;

public interface IPostService extends IService<PostResponseDTO> {

    FollowingUsersPostsResponseDTO getFollowingUsersPosts(int userId, String order);
    void newPost(PostRequestDTO postRequestDTO);

    UserPostsCountDTO getPromoPostsCount(int userId);

    PromoPostsListDTO getPromoPostsList(int userId);
}
