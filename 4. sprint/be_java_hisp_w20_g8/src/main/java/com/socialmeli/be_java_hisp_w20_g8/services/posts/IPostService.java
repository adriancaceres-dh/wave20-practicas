package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.ResponsePostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Seller;

import java.util.Set;

public interface IPostService {
    ResponsePostDTO findSellersByIdUser(int id);

    ResponsePostDTO findPostByIdSeller(Set<Seller> sellers, int idUser);
}
