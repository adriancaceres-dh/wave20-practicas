package com.bootcamp.be_java_hisp_w20_g1.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g1.model.Post;

import java.util.List;

public interface IPostRepository {
    void add(Post post);

    List<Post> getPosts();
}
