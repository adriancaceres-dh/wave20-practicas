package com.bootcamp.java.w20.be_java_hisp_w20_g05.repository;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;

import java.util.Set;

public interface IPostRepository extends IRepository<Post> {
    public int incrementId();
    Set<Post> filterByUserId(int userId);
}
