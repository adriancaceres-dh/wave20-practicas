package com.bootcamp.be_java_hisp_w20_g7_anttury.repository;

import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> findAll();

    boolean save(Post post);
}
