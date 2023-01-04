package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserPromoPostCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserPromoPostsDTO;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);

    String addPromoPost(PromoPostDTO promoPostDTO);
    UserPromoPostCountDTO getUserPromoPostCount(int userId);

    UserPromoPostsDTO getUserPromoPosts(int userId);
}
