package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.dto.request.PostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;

public interface IPostService {
    void createPost(PostRequestDTO postRequestDTO);

    PostResponseDTO sendLastPostOfFollowed(int userId);
}
