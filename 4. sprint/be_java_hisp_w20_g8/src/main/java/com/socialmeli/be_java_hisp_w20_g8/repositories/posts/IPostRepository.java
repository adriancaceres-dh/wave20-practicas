package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.models.Post;

public interface IPostRepository {
    boolean createPost(Post post);
}
