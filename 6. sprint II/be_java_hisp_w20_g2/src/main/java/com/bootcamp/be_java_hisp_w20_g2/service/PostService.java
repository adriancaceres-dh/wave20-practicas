package com.bootcamp.be_java_hisp_w20_g2.service;

import com.bootcamp.be_java_hisp_w20_g2.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g2.service.interfaces.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;
    public PostService(){

    }

}
