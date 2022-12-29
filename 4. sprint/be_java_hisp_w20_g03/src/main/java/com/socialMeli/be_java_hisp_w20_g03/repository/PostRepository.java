package com.socialMeli.be_java_hisp_w20_g03.repository;

import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import com.socialMeli.be_java_hisp_w20_g03.model.Post;

@Repository
public class PostRepository implements IPostRepository {

    private List<Post> postsList;

    public PostRepository() {
        postsList = new ArrayList<>();

        Product producto1 = new Product(1,"Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition");
        Product producto62 = new Product(62,"Headset RGB Inalámbrico", "Gamer", "Razer", "Green with RGB", "Sin Batería");

        postsList.add(new Post(1, 1, 1000, false, 100, 1,LocalDate.parse("2022-12-03") ));
        postsList.add(new Post(1, 2, 1500, true, 500, 2,LocalDate.parse("2022-12-03") ));
        postsList.add(new Post(1, 1, 1000, false, 100, 1,LocalDate.parse("2022-12-03") ));
        postsList.add(new Post(1, 1, 1000, false, 100, 1,LocalDate.parse("2022-12-03") ));
        postsList.add(new Post(1, 1, 1000, false, 100, 1,LocalDate.parse("2022-12-03") ));
        postsList.add(new Post(1, 1, 1000, false, 100, 1,LocalDate.parse("2022-12-03") ));


    }

    public boolean addPost(Post post) {
        return false;
    }

    public List<Post> getPosts() {
        return this.postsList;
    }

}
