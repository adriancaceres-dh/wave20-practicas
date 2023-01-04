package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoProductCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoProductListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order);
    public Post newPost(PostRequestDTO postRequestDTO);
    public String addPromoPost(PromoPostRequestDTO post);
    public boolean isPosted(PromoPostRequestDTO post);
    public PromoProductCountDTO countPromoByUser (int id);
    public PromoProductListDTO listPromoByUser (int id);
}
