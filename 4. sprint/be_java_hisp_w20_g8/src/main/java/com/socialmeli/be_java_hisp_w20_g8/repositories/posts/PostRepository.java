package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;

import java.util.Set;

public interface PostRepository {
    Set<PostDTO> findPostsById(Set<Integer> id);
}
