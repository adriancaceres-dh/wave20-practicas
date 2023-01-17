package com.bootcamp.java.w20.be_java_hisp_w20_g05.util;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.ProductResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class TestUtils {
    public static Set<User> createMockUsers() {
        File file = null;
        String path = "classpath:testUsers.json"; // "./src/test/resources/testUsers.json"
        try {
            file = ResourceUtils.getFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<Set<User>> typeRef = new TypeReference<>() {};
        Set<User> users = null;

        try {
            users = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static Set<Post> createMockPosts() {
        File file = null;
        String path = "classpath:testPosts.json"; // "./src/test/resources/testPosts.json"
        try {
            file = ResourceUtils.getFile(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        TypeReference<Set<Post>> typeRef = new TypeReference<>() {};
        Set<Post> posts = null;

        try {
            posts = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return posts;
    }

    public static FollowedUsersPostsResponseDTO getFollowedUsersPosts(int userId) {

        //Crear un dto de FollowedUsersPostsResponseDTO con 3 posts.
        ProductResponseDTO product1 = new ProductResponseDTO(userId, "Silla Gamer", "Gamer", "Acer", "Negra", "Muy comoda");
        ProductResponseDTO product2 = new ProductResponseDTO(userId, "Pelota de futbol", "Fulbo 11", "Penalty", "Blanca y negra", "Simil cuero");
        ProductResponseDTO product3 = new ProductResponseDTO(userId, "Afeitadora", "3 hojas", "Gillete", "Gris", "Afeita todo");

        PostResponseDTO post1 = new PostResponseDTO(1,userId, LocalDate.of(2023,02,5), product1,"",3000);
        PostResponseDTO post2 = new PostResponseDTO(2,userId, LocalDate.of(2023,02,10), product2,"",3000);
        PostResponseDTO post3 = new PostResponseDTO(3,userId, LocalDate.of(2023,02,15), product3,"",3000);

        Collection<PostResponseDTO> collectionPost = new ArrayList<>();
        collectionPost.add(post1);
        collectionPost.add(post2);
        collectionPost.add(post3);

        FollowedUsersPostsResponseDTO result = new FollowedUsersPostsResponseDTO(1, collectionPost);

        return result;
    }

    public static FollowedUsersPostsResponseDTO getFollowedUsersPostsDesc(int userId) {

        //Crear un dto de FollowedUsersPostsResponseDTO con 3 posts.
        ProductResponseDTO product1 = new ProductResponseDTO(userId, "Silla Gamer", "Gamer", "Acer", "Negra", "Muy comoda");
        ProductResponseDTO product2 = new ProductResponseDTO(userId, "Pelota de futbol", "Fulbo 11", "Penalty", "Blanca y negra", "Simil cuero");
        ProductResponseDTO product3 = new ProductResponseDTO(userId, "Afeitadora", "3 hojas", "Gillete", "Gris", "Afeita todo");

        PostResponseDTO post1 = new PostResponseDTO(1,userId, LocalDate.of(2023,02,15), product1,"",3000);
        PostResponseDTO post2 = new PostResponseDTO(2,userId, LocalDate.of(2023,02,10), product2,"",3000);
        PostResponseDTO post3 = new PostResponseDTO(3,userId, LocalDate.of(2023,02,5), product3,"",3000);

        Collection<PostResponseDTO> collectionPost = new ArrayList<>();
        collectionPost.add(post1);
        collectionPost.add(post2);
        collectionPost.add(post3);

        FollowedUsersPostsResponseDTO result = new FollowedUsersPostsResponseDTO(1, collectionPost);

        return result;
    }

    public static User getUserWithId(int userId)
    {
        Set<Integer> flwrs = new HashSet<>();
        flwrs.add(1);
        flwrs.add(2);
        flwrs.add(3);

        Set<Integer> flwng = new HashSet<>();
        flwng.add(4);
        flwng.add(5);
        flwng.add(6);

        return new User(userId,"Pepe",flwrs,flwng);


    }

    public static Set<Post> get3PostsWithUserId(int userId)
    {
        Product pr1 = new Product(6, "Silla Gamer", "Acer", "Gamer", "Negra","Muy comoda");
        Product pr2 = new Product(5, "Pelota de futbol", "Penalty", "Fulbo 11", "Blanca y negra","Simil cuero");
        Product pr3 = new Product(4, "Afeitadora", "Gillete", "3 hojas", "Gris","Afeita todo");

        Post p1 = new Post(1, 1, 4,LocalDate.of(2023,02,15),2000,0.4, pr1);
        Post p2 = new Post(2, 2, 5,LocalDate.of(2023,02,10),3000,0.5, pr2);
        Post p3 = new Post(3, 3, 6,LocalDate.of(2023,02,5),4000,0.6, pr3);

        Set<Post> posts = Set.of(p1,p2,p3);

        return posts;
    }
}
