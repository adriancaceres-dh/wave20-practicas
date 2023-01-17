package com.bootcamp.java.w20.be_java_hisp_w20_g05.util;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.ProductRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.ProductResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowersBySellerDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.modelmapper.ModelMapper;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


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
        try {
            file = ResourceUtils.getFile("classpath:testPosts.json");
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
    
    public static User getTestUser(int id) {
        return TestUtils.createMockUsers().stream().filter(user -> user.getId() == id).findFirst().get();
    }

    public static FollowedListDTO getTestFollowedListDTO (String order) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        if (order.equalsIgnoreCase("name_asc")) {
            userResponseDTOList.add(new UserResponseDTO(2, TestUtils.getTestUser(2).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(4, TestUtils.getTestUser(4).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(3, TestUtils.getTestUser(3).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(1, TestUtils.getTestUser(1).getUserName()));
        } else if (order.equalsIgnoreCase("name_desc")) {
            userResponseDTOList.add(new UserResponseDTO(1, TestUtils.getTestUser(1).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(3, TestUtils.getTestUser(3).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(4, TestUtils.getTestUser(4).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(2, TestUtils.getTestUser(2).getUserName()));
        }

        return new FollowedListDTO(5, "Test", userResponseDTOList);
    }

    public static FollowersBySellerDTO getTestFollowersBySellerDTO (String order) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        if (order.equalsIgnoreCase("name_asc")) {
            userResponseDTOList.add(new UserResponseDTO(2, TestUtils.getTestUser(2).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(4, TestUtils.getTestUser(4).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(3, TestUtils.getTestUser(3).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(1, TestUtils.getTestUser(1).getUserName()));
        } else if (order.equalsIgnoreCase("name_desc")) {
            userResponseDTOList.add(new UserResponseDTO(1, TestUtils.getTestUser(1).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(3, TestUtils.getTestUser(3).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(4, TestUtils.getTestUser(4).getUserName()));
            userResponseDTOList.add(new UserResponseDTO(2, TestUtils.getTestUser(2).getUserName()));
        }

        return new FollowersBySellerDTO(5, "Test", userResponseDTOList);
    }

    public static List<UserResponseDTO> createFollsListDto(Integer id, boolean followed){
        return createMockUsers().stream()
                .filter(user -> (followed)?
                        user.getFollowers().contains(id):
                        user.getFollowing().contains(id))
                .map(user -> new UserResponseDTO(user.getId(), user.getUserName()))
                .collect(Collectors.toList());
    }

    public static FollowedListDTO getFollowedListDTOForIntegrationTest (String order) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        if (order.equalsIgnoreCase("name_asc")) {
            userResponseDTOList.add(new UserResponseDTO(4, "jmedcraft2"));
            userResponseDTOList.add(new UserResponseDTO(3, "qropcke1"));
        } else if (order.equalsIgnoreCase("name_desc")) {
            userResponseDTOList.add(new UserResponseDTO(3, "qropcke1"));
            userResponseDTOList.add(new UserResponseDTO(4, "jmedcraft2"));
        }

        return new FollowedListDTO(2, "hbowstead0", userResponseDTOList);
    }

    public static FollowersBySellerDTO getFollowersBySellerDTOForIntegrationTest (String order) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        if (order.equalsIgnoreCase("name_asc")) {
            userResponseDTOList.add(new UserResponseDTO(4, "jmedcraft2"));
            userResponseDTOList.add(new UserResponseDTO(3, "qropcke1"));
        } else if (order.equalsIgnoreCase("name_desc")) {
            userResponseDTOList.add(new UserResponseDTO(3, "qropcke1"));
            userResponseDTOList.add(new UserResponseDTO(4, "jmedcraft2"));
        }

        return new FollowersBySellerDTO(2, "hbowstead0", userResponseDTOList);
    }

    public static PostRequestDTO getPostRequestDTOForIntegrationTest (int userId, int productId) {

        PostRequestDTO postRequestDTO = new PostRequestDTO(
                userId,
                LocalDate.now(),
                new ProductRequestDTO(
                        productId,
                        "Test",
                        "Test",
                        "Test",
                        "Test",
                        "Test"
                ),
                99,
                99.99);

        return postRequestDTO;
    }

    public static String getExpectedResponseUS0005ForIntegrationTest () {
        return "{\"user_id\":16,\"post_id\":40,\"date\":\"2023-01-17\",\"product\":{\"id\":99,\"name\":\"Test\",\"type\":\"Test\",\"brand\":\"Test\",\"color\":\"Test\",\"notes\":\"Test\"},\"category\":\"99\",\"price\":99.99}";

    }
}
