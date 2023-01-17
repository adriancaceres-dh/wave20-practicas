package com.bootcamp.be_java_hisp_w20_g2.repository;

import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {
    private int currentId = 0;
    private HashMap<Integer, Category> categories; // Se crea por tema de búsqueda, de actualización y eliminación.

    public CategoryRepository() {
        categories = new HashMap<>();
    }


    @Override
    public Optional<Category> findByCode(int code) {
        return categories.entrySet().stream()
                .filter(e -> e.getValue().getCode() == code)
                .findAny().map(Map.Entry::getValue);
    }

    @Override
    public Category save(Category category) {
        if (category.getId() == null) {
            category.setId(currentId++);
        }
        categories.put(category.getId(), category);
        return category;
    }

    @Override
    public Category findOne(Integer key) {
        return categories.get(key);
    }

    @Override
    public boolean exists(Integer key) {
        return categories.containsKey(key);
    }

}
