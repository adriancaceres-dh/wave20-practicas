package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostDTO;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);

    String addPromoPost(PromoPostDTO promoPostDTO);

/*    //DEV
    List<PromoPostDTO> getAllPostFromUser();
    //FIN*/
}
