package com.bootcamp.java.w20.be_java_hisp_w20_g05.controller;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IPostService;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.IService;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class PostController {
    @Autowired
    private IPostService postService;
}
