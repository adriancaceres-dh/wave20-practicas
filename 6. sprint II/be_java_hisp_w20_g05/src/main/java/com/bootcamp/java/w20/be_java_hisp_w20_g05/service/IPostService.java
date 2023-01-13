package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponseDTO getFollowedUsersPosts(int userId, String order);

    PostResponseDTO newPost(PostRequestDTO postRequestDTO);
}
