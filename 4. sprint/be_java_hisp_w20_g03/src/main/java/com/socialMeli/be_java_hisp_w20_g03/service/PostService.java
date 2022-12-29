package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements IPostService {

    @Autowired
    PostRepository postRepository;

    @Override
    public boolean addPost(PostDTO postDTO) {
        return false;
    }

    @Override
    public List<PostDTO> getPost(int userId) {
        return null;
    }
}
