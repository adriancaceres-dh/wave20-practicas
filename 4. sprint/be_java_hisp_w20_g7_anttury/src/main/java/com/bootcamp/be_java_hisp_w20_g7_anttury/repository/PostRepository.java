package com.bootcamp.be_java_hisp_w20_g7_anttury.repository;

import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Product;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
public class PostRepository implements IPostRepository {

    List<Post> posts;

    public PostRepository() {
        posts = new ArrayList<>();
        LocalDate date = LocalDate.parse("2022-12-30");
        Product product = new Product(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
        Product product2 = new Product(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
        Product product3 = new Product(3, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Post post = new Post(3, 1, date, product, 100, 2, false, 22.0);
        Post post2 = new Post(3, 2, LocalDate.parse("2022-11-30"), product2, 100, 2, false, 22.0);
        Post post3 = new Post(3, 3, LocalDate.parse("2023-01-01"), product2, 100, 2, false, 22.0);
        Post post4 = new Post(1, 4, LocalDate.parse("2023-01-02"), product3, 100, 1500.50, true, 0.25);
        Post post5 = new Post(1, 4, LocalDate.parse("2023-01-02"), product2, 100, 1200, true, 0.15);
        Post post6 = new Post(3, 4, LocalDate.parse("2023-01-02"), product3, 100, 500.50, true, 0.10);

        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        posts.add(post4);
        posts.add(post5);
        posts.add(post6);
    }

    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public boolean save(Post post) {
        return posts.add(post);

    }
}
