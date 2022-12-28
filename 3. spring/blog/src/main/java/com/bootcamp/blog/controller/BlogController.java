package com.bootcamp.blog.controller;

import com.bootcamp.blog.dto.BlogDTO;
import com.bootcamp.blog.dto.OperationResultDTO;
import com.bootcamp.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public OperationResultDTO createBlog(@RequestBody BlogDTO blogDTO) {
        return blogService.create(blogDTO);
    }

    @GetMapping("/blog/{id}")
    public BlogDTO getBlog(@PathVariable long id) {
        return blogService.get(id);
    }

    @GetMapping("/blog")
    public List<BlogDTO> listBlogs() {
        return blogService.listAll();
    }

}
