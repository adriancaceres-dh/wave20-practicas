package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;

import java.util.Set;

public interface IPostRepository {
    Set<PostDTO> findPostsById(Set<Integer> id);

    int createPost(Post post, PostDTO postDTO);

}
