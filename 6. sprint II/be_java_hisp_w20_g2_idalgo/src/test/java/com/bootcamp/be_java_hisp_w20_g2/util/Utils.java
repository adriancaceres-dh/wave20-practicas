package com.bootcamp.be_java_hisp_w20_g2.util;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Utils {

    public static HashMap<Integer, User> generateUsers() {
        User user1 = new User(1, "Luis", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Mariano", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Lorenzo", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user2.addFollower(user1);
        user1.follow(user2);
        user1.addFollower(user3);
        user1.addFollower(user2);

        HashMap<Integer, User> users = new HashMap<>();
        users.put(1, user1);
        users.put(2, user2);
        users.put(3, user3);
        return users;
    }

    public static void addPostsToUser(User user) {
        Product silla = new Product(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        Product mesa = new Product(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        Post primerPost = new Post(0, LocalDate.now(), mesa, new Category(13, "Armas"), 100000);
        Post segundoPost = new Post(1, LocalDate.of(2023, 1, 10), silla, new Category(200, "Teteras"), 120000);

        user.addPost(primerPost);
        user.addPost(segundoPost);
    }

    public static PostDTO generatePostDTO(int userId) {
        ProductDTO productDTO = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        return new PostDTO(userId, LocalDate.now(), productDTO, 125, 100d);
    }

    public static PostDTO generatePostDTOWithNegativePrice(int userId) {
        ProductDTO productDTO = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        return new PostDTO(userId, LocalDate.now(), productDTO, 125, -100d);
    }

    public static PostDTO generatePostDTOWithUnnamedProduct(int userId) {
        ProductDTO productDTO = new ProductDTO(1000, "", "Gamer", "Redragon", "Negro", "");
        return new PostDTO(userId, LocalDate.now(), productDTO, 125, 100d);
    }

    public static PostDTO generatePostDTOWithInvalidCategory(int userId) {
        ProductDTO productDTO = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        return new PostDTO(userId, LocalDate.now(), productDTO, 100000, 100d);
    }

    public static PostResponseDTO generatePostResponseDTOAsc() {
        List<PostWithIdDTO> posts = generatePostsWithIdDTO();

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(posts.get(0));
        postResponseDTO.addPost(posts.get(1));

        return postResponseDTO;
    }

    public static PostResponseDTO generatePostResponseDTODesc() {
        List<PostWithIdDTO> posts = generatePostsWithIdDTO();

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(posts.get(1));
        postResponseDTO.addPost(posts.get(0));

        return postResponseDTO;
    }

    private static List<PostWithIdDTO> generatePostsWithIdDTO() {
        ProductDTO producto1 = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        ProductDTO producto2 = new ProductDTO(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        PostWithIdDTO post1 = new PostWithIdDTO(2, LocalDate.of(2023, 1, 10), producto1, 200, 120000.0, 1);
        PostWithIdDTO post2 = new PostWithIdDTO(2, LocalDate.now(), producto2, 13, 100000.0, 0);

        return List.of(post1, post2);
    }
}
