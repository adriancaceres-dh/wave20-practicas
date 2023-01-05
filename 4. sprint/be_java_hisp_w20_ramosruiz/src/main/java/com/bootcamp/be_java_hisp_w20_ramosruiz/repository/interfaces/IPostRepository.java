package com.bootcamp.be_java_hisp_w20_ramosruiz.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_ramosruiz.model.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getPostsByUserId(int id);
    Post add(Post post);
    List<Post> getPosts();
    Post update(Post post);

    Post getPostByProductId(int productId);
}
