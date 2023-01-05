package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PromoPostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PromoPostCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.promo_post_list.PromoPostListResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import org.springframework.http.ResponseEntity;

public interface IPostService extends IService<PostResponseDTO> {
    FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order);
    public Post newPost(PostRequestDTO postRequestDTO);
    public ResponseEntity<String> newPromoPost(PromoPostRequestDTO promoPostRequestDTO);
    public PromoPostCountDTO getPromoPostCount(int userId);
    public PromoPostListResponse getPromoPostList(int userId);

    public ResponseEntity<String> convertPromoPost (int postId);
    public ResponseEntity<String> deletePost (int postId);
}
