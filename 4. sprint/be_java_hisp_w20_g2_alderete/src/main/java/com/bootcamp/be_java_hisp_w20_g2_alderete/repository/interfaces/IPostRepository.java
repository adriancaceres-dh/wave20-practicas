package com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Post;

import java.util.List;

public interface IPostRepository extends GenericRepository<Post, Integer> {
    List<Post> findByHasPromo(boolean hasPromo);
}
