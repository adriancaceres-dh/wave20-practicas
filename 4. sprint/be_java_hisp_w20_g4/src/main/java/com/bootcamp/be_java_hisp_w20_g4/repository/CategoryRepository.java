package com.bootcamp.be_java_hisp_w20_g4.repository;

import com.bootcamp.be_java_hisp_w20_g4.model.Category;
import com.bootcamp.be_java_hisp_w20_g4.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
public class CategoryRepository implements ICategoryRepository{

    public List<Category> categories = loadCategories();

    private List<Category> loadCategories() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:categories.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Category>> typeRef = new TypeReference<>() {};
        List<Category> categories = null;
        try {
            categories = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category findById(Integer categoryId) {
        return categories.stream().filter(x->x.getId() == categoryId).findFirst().orElse(null);
    }
}
