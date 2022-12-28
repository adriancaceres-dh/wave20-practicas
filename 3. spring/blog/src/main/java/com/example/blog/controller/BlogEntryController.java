package com.example.blog.controller;

import com.example.blog.dto.request.BlogEntryRequestDto;
import com.example.blog.dto.response.BlogEntryResponseDto;
import com.example.blog.model.BlogEntry;
import com.example.blog.service.BlogEntryServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogEntryController {

    private final BlogEntryServiceInterface blogEntryService;

    @Autowired
    public BlogEntryController(BlogEntryServiceInterface blogEntryService) {
        this.blogEntryService = blogEntryService;
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<BlogEntryResponseDto>> getBlogEntries() {
        return ResponseEntity.ok().body(blogEntryService.getBlogEntries());
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<BlogEntryResponseDto> getBlogEntry(@PathVariable Long id) {
        return ResponseEntity.ok().body(blogEntryService.getBlogEntryById(id));
    }

    @PostMapping("/blog")
    public ResponseEntity<Long> addBlogEntry(@RequestBody BlogEntryRequestDto blogEntry) {
        return ResponseEntity.ok().body(blogEntryService.addBlogEntry(blogEntry));
    }
}
