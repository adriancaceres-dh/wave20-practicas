package com.bootcamp.blog.service;


import com.bootcamp.blog.dto.request.BlogPostRequestDto;
import com.bootcamp.blog.dto.response.BlogPostResponseDto;

import java.util.List;

public interface IBlogService {
    String addPost(BlogPostRequestDto blogPostRequestDto);
    BlogPostResponseDto getPost(String id);
    List<BlogPostResponseDto> getPosts();
}
