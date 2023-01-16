package com.bootcamp.be_java_hisp_w20_g2.util;

import com.bootcamp.be_java_hisp_w20_g2.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.PostResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.dto.response.UserFollowersCountResponseDTO;
import com.bootcamp.be_java_hisp_w20_g2.model.Category;
import com.bootcamp.be_java_hisp_w20_g2.model.Post;
import com.bootcamp.be_java_hisp_w20_g2.model.Product;
import com.bootcamp.be_java_hisp_w20_g2.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class UtilsTest {
    public static HashMap<Integer,User> generateUsersToTestFollow(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user1.addFollower(user2);


        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static HashMap<Integer,User> generateUsersForTestTwo(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2.addFollower(user1);
        user1.getFollowing().add(user2);
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static HashMap<Integer,User> generateUsersToTestExistingFollow(){
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user2.addFollower(user1);
        user1.getFollowing().add(user2);
        HashMap<Integer,User> users = new HashMap<>();
        users.put(1,user1);
        users.put(2,user2);
        return users;

    }

    public static User generateUserToTestFollowerList(){
        User user = new User("Mariano");
        user.setId(2);
        user.addFollower(new User("Luis"));
        user.addFollower(new User("Francisco"));
        user.addFollower(new User("Lorenzo"));
        return user;
    }

    public static User generateUserWithPostExist() {
        User user1 = new User(1,"usuario1",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        User user2 = new User(2,"usuario2",new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        user1.follow(user2);
        user2.addFollower(user1);

        Product silla = new Product(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        Product mesa = new Product(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        Post primerPost = new Post(0, LocalDate.now(), mesa, new Category(13, "Armas"), 100000);
        Post segundoPost = new Post(1, LocalDate.of(2023, 1, 10), silla, new Category(200, "Teteras"), 120000);

        user2.addPost(primerPost);
        user2.addPost(segundoPost);

        return user1;
    }

    public static PostResponseDTO generatePostResponseDTOAsc() {
        ProductDTO producto1 = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        ProductDTO producto2 = new ProductDTO(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        PostWithIdDTO post1 = new PostWithIdDTO(2, LocalDate.of(2023, 1, 10), producto1, 200, 120000.0, 1);
        PostWithIdDTO post2 = new PostWithIdDTO(2, LocalDate.now(), producto2, 13, 100000.0, 0);

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(post1);
        postResponseDTO.addPost(post2);

        return postResponseDTO;
    }

    public static PostResponseDTO generatePostResponseDTODesc() {
        ProductDTO producto1 = new ProductDTO(1000, "Silla gamer", "Gamer", "Redragon", "Negro", "");
        ProductDTO producto2 = new ProductDTO(1001, "Mesa", "Mueble", "Vaca mistica", "Blanco", "");

        PostWithIdDTO post1 = new PostWithIdDTO(2, LocalDate.of(2023, 1, 10), producto1, 200, 120000.0, 1);
        PostWithIdDTO post2 = new PostWithIdDTO(2, LocalDate.now(), producto2, 13, 100000.0, 0);

        PostResponseDTO postResponseDTO = new PostResponseDTO(1);
        postResponseDTO.addPost(post2);
        postResponseDTO.addPost(post1);

        return postResponseDTO;
    }
}
