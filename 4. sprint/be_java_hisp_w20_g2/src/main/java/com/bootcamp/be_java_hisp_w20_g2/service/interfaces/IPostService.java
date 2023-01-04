package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;

import java.util.Optional;

public interface IPostService {
    void createPost(PostDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);
}
