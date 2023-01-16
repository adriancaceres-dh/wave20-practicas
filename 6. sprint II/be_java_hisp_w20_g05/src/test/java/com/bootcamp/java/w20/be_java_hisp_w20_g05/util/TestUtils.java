package com.bootcamp.java.w20.be_java_hisp_w20_g05.util;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    public static User getTestUser(int id) {
        return TestUtils.createMockUsers().stream().filter(user -> user.getId() == id).findFirst().orElseThrow();
    }

    public static FollowedListDTO getTestFollowedListDTO (String order) {
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();

        if (order.equalsIgnoreCase("name_asc")) {
            for (int i = 0; i < 5; i++) {
                userResponseDTOList.add( new UserResponseDTO (i, TestUtils.getTestUser(i).getUserName()));
            }
        } else if (order.equalsIgnoreCase("name_desc")) {
            for (int i = 5; i > 0; i--) {
                userResponseDTOList.add( new UserResponseDTO (i, TestUtils.getTestUser(i).getUserName()));
            }
        }

        return new FollowedListDTO(5, "Test", userResponseDTOList);

    }
}
