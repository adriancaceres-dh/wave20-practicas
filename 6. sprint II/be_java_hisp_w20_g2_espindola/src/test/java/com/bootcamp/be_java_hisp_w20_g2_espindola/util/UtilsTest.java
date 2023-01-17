package com.bootcamp.be_java_hisp_w20_g2_espindola.util;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UtilsTest {

    public static HashMap<Integer,User> generateUsers() {
        User user1 = new User(1, "Luis", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user2 = new User(2, "Mariano", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        User user3 = new User(3, "Lorenzo", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

        user2.addFollower(user1);
        user1.follow(user2);
        user1.addFollower(user3);
        user1.addFollower(user2);

        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        users.put(3,user3);
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

    public static PostResponseDTO generatePostResponseDTOAsc() {
        List<PostWithIdDTO> posts = generatePostsDTO();

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(posts.get(0));
        postResponseDTO.addPost(posts.get(1));

        return postResponseDTO;
    }

    public static PostResponseDTO generatePostResponseDTODesc() {
        List<PostWithIdDTO> posts = generatePostsDTO();

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(posts.get(1));
        postResponseDTO.addPost(posts.get(0));

        return postResponseDTO;
    }

    public static PostDTO generatePostDTO(Integer userId) {
        ProductDTO producto = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");

        return new PostDTO(userId, LocalDate.now(), producto, 12, 1500.50);
    }

    public static PostDTO generatePostDTOInvalidCategory(Integer userId) {
        ProductDTO producto = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");

        return new PostDTO(userId, LocalDate.now(), producto, 0, 1500.50);
    }

    public static PostDTO generatePostDTOInvalidProductId(Integer userId) {
        ProductDTO producto = new ProductDTO(-15, "Silla gamer", "Gamer", "Redragon", "Negro", "");

        return new PostDTO(userId, LocalDate.now(), producto, 0, 1500.50);
    }

    public static PostDTO generatePostDTOInvalidType(Integer userId) {
        ProductDTO producto = new ProductDTO(1, "Silla gamer", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Redragon", "Negro", "");

        return new PostDTO(userId, LocalDate.now(), producto, 0, 1500.50);
    }

    public static PostDTO generatePostDTOInvalidPrice(Integer userId) {
        ProductDTO producto = new ProductDTO(1, "Silla gamer", "Gamer", "Redragon", "Negro", "");

        return new PostDTO(userId, LocalDate.now(), producto, 0, 150000000000000.50);
    }

    private static List<PostWithIdDTO> generatePostsDTO() {
        ProductDTO producto1 = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        ProductDTO producto2 = new ProductDTO(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        PostWithIdDTO post1 = new PostWithIdDTO(2, LocalDate.of(2023, 1, 10), producto1, 200, 120000.0, 1);
        PostWithIdDTO post2 = new PostWithIdDTO(2, LocalDate.now(), producto2, 13, 100000.0, 0);

        return List.of(post1, post2);
    }
}
