package com.bootcamp.be_java_hisp_w20_g7.repository;

import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.Product;
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
        Post post = new Post(3, 1, date, product, 100, 2, false, 0.0);
        Post post2 = new Post(3, 2, LocalDate.parse("2022-11-30"), product2, 100, 2, false, 0.0);
        Post post3 = new Post(3, 3, LocalDate.parse("2023-01-01"), product2, 100, 2, false, 0.0);
        posts.add(post);
        posts.add(post2);
        posts.add(post3);
        Product productPromo = new Product(3, "Silla Gamer", "Gamer", "X Rocker", "Tiger", "Special Edition");
        Product product2Promo = new Product(3, "Silla Gamer", "Gamer", "X Rocker", "Zebra", "Special Edition");
        Post postP = new Post(2, 1, date, product, 100, 2, true, 20.0);
        Post postP2 = new Post(2, 2, LocalDate.parse("2022-11-30"), productPromo, 100, 2, true, 50.0);
        Post postP3 = new Post(2, 3, LocalDate.parse("2023-01-01"), product2Promo, 100, 2, true, 30.0);
        posts.add(postP);
        posts.add(postP2);
        posts.add(postP3);
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
