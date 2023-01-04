package com.bootcamp.be_java_hisp_w20_g2.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.model.Post;

import java.util.List;

public interface IPostRepository extends GenericRepository<Post, Integer> {
    List<Post> findByHasPromo(boolean hasPromo);
}
