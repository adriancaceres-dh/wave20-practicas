package com.bootcamp.be_java_hisp_w20_g2_espindola.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;

import java.util.Optional;

public interface IPostService {
    PostDTO createPost(PostDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId, Optional<String> order);
}
