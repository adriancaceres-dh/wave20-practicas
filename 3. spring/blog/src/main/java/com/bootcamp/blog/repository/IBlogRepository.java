package com.bootcamp.blog.repository;

import com.bootcamp.blog.model.BlogPost;

import java.util.List;

public interface IBlogRepository {
    public BlogPost addPost(BlogPost blogPost);
    public BlogPost findById(String id);
    public List<BlogPost> getPosts();
}
