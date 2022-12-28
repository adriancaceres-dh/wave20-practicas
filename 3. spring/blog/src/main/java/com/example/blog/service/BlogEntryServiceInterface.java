package com.example.blog.service;

import com.example.blog.dto.request.BlogEntryRequestDto;
import com.example.blog.dto.response.BlogEntryResponseDto;

import java.util.List;

public interface BlogEntryServiceInterface {
    BlogEntryResponseDto getBlogEntryById(Long id);
    Long addBlogEntry(BlogEntryRequestDto blogEntryRequestDto);
    List<BlogEntryResponseDto> getBlogEntries();
}
