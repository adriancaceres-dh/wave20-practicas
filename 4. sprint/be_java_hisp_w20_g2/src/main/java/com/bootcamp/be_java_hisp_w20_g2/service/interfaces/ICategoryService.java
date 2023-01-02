package com.bootcamp.be_java_hisp_w20_g2.service.interfaces;

import com.bootcamp.be_java_hisp_w20_g2.model.Category;

import java.util.Optional;

public interface ICategoryService {

    Optional<Category> findCategoryByCode(int categoryCode);
}
