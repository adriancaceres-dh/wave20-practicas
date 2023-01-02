package com.socialmeli.be_java_hisp_w20_g8.services.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostRequestDTO;

public interface IPostService {
    boolean createPost(PostRequestDTO postRequestDTO);
}
