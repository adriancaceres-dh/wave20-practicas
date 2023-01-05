package com.bootcamp.be_java_hisp_w20_g2_ambroggio.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.PostPromoCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_ambroggio.dto.response.UserProductsPromoResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);

    public boolean createPostPromo(PostPromoDTO postRequestDTO);

    public PostPromoCountResponseDTO countsProductsPromo (int userId);
    public UserProductsPromoResponseDTO listUserProductsPromo(int id);
}
