package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

import java.util.List;
import java.util.Set;

public interface IPostRepository extends IRepository<Post> {
    Set<Post> filterByUserId(int userId);
    List<Post> getPostsById(int userId);
}
