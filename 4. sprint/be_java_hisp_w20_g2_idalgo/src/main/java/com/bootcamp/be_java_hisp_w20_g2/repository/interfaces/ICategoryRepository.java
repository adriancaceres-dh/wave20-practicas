package com.bootcamp.be_java_hisp_w20_g2.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.model.PostCategory;

import java.util.Optional;

public interface ICategoryRepository extends GenericRepository<PostCategory, Integer> {
    Optional<PostCategory> findByCode(int code);
}
