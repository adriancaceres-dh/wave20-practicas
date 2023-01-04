package com.socialmeli.be_java_hisp_w20_g03.service;

import com.socialmeli.be_java_hisp_w20_g03.dto.PostDTO;

import java.util.List;

public interface IPostService {
    String addPost(PostDTO postDTO);
    List<PostDTO> getPost(int userId, String order);
}
