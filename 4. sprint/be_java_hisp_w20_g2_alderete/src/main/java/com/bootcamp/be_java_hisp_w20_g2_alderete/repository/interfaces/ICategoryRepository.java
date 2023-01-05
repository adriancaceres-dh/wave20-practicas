package com.bootcamp.be_java_hisp_w20_g2_alderete.repository.interfaces;

import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Category;

import java.util.Optional;

public interface ICategoryRepository extends GenericRepository<Category, Integer> {
    Optional<Category> findByCode(int code);
}
