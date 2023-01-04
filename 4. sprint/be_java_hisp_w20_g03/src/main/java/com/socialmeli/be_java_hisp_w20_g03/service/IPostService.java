package com.socialmeli.be_java_hisp_w20_g03.service;

import com.socialmeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.SellerPromoCountDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.SellerPromoListDTO;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);
    SellerPromoCountDTO getPromoPostCount(int userId);
    SellerPromoListDTO getPromoPostList(int userId);
}
