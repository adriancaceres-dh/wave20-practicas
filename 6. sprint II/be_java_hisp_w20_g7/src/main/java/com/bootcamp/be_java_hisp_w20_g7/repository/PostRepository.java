package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.Product;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PostRepository implements IPostRepository {

    List<Post> posts;

    public PostRepository() {
        posts = loadData();
        posts = new ArrayList<>();
        LocalDate date = LocalDate.parse("2022-12-30");
        Product product = new Product(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        Product product2 = new Product(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
        Post post = new Post(3, 1, date, product, 100, 2, false, 22.0);
        Post post2 = new Post(3, 2, LocalDate.parse("2022-11-30"), product2, 100, 2, false, 22.0);
        Post post3 = new Post(3, 3, LocalDate.parse("2023-01-01"), product2, 100, 2, false, 22.0);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public boolean save(Post post) {
        return posts.add(post);

    }

    public List<Post> loadData(){
        List<Post> loadedData = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            File file = ResourceUtils.getFile("./src/main/resources/posts.json");
            loadedData = objectMapper.readValue(file, new TypeReference<List<Post>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        return loadedData;
    }
}
