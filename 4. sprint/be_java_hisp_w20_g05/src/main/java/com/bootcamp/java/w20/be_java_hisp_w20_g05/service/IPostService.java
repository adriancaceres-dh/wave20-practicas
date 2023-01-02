package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import org.springframework.web.bind.annotation.PathVariable;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId);
}
