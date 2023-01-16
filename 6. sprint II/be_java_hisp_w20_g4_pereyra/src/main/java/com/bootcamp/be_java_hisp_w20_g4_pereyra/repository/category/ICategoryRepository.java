package com.bootcamp.be_java_hisp_w20_g4_pereyra.repository.category;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Category;

public interface ICategoryRepository {
    Category findById(Integer categoryId);
}
