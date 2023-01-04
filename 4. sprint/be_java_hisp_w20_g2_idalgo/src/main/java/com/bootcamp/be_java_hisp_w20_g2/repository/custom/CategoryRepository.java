package com.bootcamp.be_java_hisp_w20_g2.repository.custom;

import com.bootcamp.be_java_hisp_w20_g2.model.PostCategory;
import com.bootcamp.be_java_hisp_w20_g2.repository.interfaces.ICategoryRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {
    private static int currentId = 0;
    private HashMap<Integer, PostCategory> categories; // Se crea por tema de búsqueda, de actualización y eliminación.

    public CategoryRepository() {
        categories = new HashMap<>();
    }


    @Override
    public Optional<PostCategory> findByCode(int code) {
        return categories.entrySet().stream()
                .filter(e -> e.getValue().getCode() == code)
                .findAny().map(Map.Entry::getValue);
    }

    @Override
    public PostCategory save(PostCategory postCategory) {
        if (postCategory.getId() == null) {
            postCategory.setId(currentId++);
        }
        categories.put(postCategory.getId(), postCategory);
        return postCategory;
    }

    @Override
    public PostCategory findOne(Integer key) {
        return categories.get(key);
    }

    @Override
    public boolean exists(Integer key) {
        return categories.containsKey(key);
    }

}
