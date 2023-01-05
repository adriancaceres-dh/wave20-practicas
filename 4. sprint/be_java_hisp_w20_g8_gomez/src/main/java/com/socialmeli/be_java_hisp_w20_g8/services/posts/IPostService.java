package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.*;

import com.socialmeli.be_java_hisp_w20_g8.models.Seller;

import java.util.Set;

public interface IPostService {

    boolean createPost(PostRequestDTO postRequestDTO);

    boolean createPromoPost(PromoPostRequestDTO promoPostRequestDTO);

    ResponsePostDTO findSellersByIdUser(int id, String order);

    ResponsePostDTO findPostByIdSeller(Set<Seller> sellers, int idUser, String order);

    PromoPostCountDTO promoPostCount(int userId);

    PromoPostListDTO listPromoPostCount(int user_id);
}
