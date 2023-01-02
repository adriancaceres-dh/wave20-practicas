package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Category;

public interface ICategoryRepository {
    Category findById(Integer categoryId);
}
