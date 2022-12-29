package com.socialMeli.be_java_hisp_w20_g03.repository;

import com.socialMeli.be_java_hisp_w20_g03.model.Post;

import java.util.List;

public interface IPostRepository {
    public boolean addPost(Post post);
    public List<Post> getPosts();
}
