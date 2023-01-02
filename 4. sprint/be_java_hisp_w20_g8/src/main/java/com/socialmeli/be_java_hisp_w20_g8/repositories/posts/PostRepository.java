package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;


import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;

import java.util.List;

public interface PostRepository {
    List<PostDTO> findALlPostsByIdUser(int id);
}
