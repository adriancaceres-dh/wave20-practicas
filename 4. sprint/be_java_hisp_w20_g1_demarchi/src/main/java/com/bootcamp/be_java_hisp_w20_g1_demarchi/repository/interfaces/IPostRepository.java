package com.bootcamp.be_java_hisp_w20_g1_demarchi.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g1_demarchi.model.Post;

import java.util.List;

public interface IPostRepository {
    List<Post> getPostsByUserId(int id);
    List<Post> getPostOnPromotionByUserId(int id);
    Post add(Post post);

    List<Post> getPosts();
}
