package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;

import java.util.List;

public interface IPostService {
    public boolean addPost(PostDTO postDTO);
    public List<PostDTO> getPost(int userId);
}
