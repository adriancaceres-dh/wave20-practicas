package com.bootcamp.be_java_hisp_w20_g1_hoffman.util;

import com.bootcamp.be_java_hisp_w20_g1_hoffman.Parameter;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.Post;
import com.bootcamp.be_java_hisp_w20_g1_hoffman.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.util.ResourceUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class TestUtil {

    private static Set<User> users = new HashSet<>();

    static ModelMapper mapper = new ModelMapper();

    public static List<Post> getPostsByUserId(int id) {
        List<Post> posts = new ArrayList<>();
        posts.add(Post.builder().
                userId(id).
                price(500D).
                productId(1).
                date(LocalDate.now()).
                category(100).
                build());

        posts.add(Post.builder().
                userId(id).
                price(400D).
                productId(2).
                date(LocalDate.now().minusDays(Parameter.getInteger("NumberOfDays")-1)).
                category(50).
                build());

        return posts;
    }

    public static Post getPostFromFifteenDaysAgo() {

        return Post.builder().
                userId(3).
                price(500D).
                productId(1).
                date(LocalDate.now().minusDays(Parameter.getInteger("NumberOfDays"))).
                category(100).
                build();

    }

    public static ProductResponseDto getProductById(int id) {
        return ProductResponseDto.builder().
                productId(id).
                productName("Producto generico").
                type("Tipo generico").
                brand("Marca generica").
                color("Rojo").
                notes("").
                build();
    }

    public static PostListResponseDto getPostListResponseDto(int id, int seller) {
        List<Post> posts = getPostsByUserId(seller);
        List<PostResponseDto> postDto = posts.stream().
                map(p -> mapper.map(p, PostResponseDto.class)).
                collect(Collectors.toList());

        for (int i = 0; i < 2; i++) {
            postDto.get(i).setProduct(getProductById(i + 1));
        }
        return new PostListResponseDto(id, postDto);
    }

    public static User getUserWithFollowers(boolean isSeller){
        Set<Integer> followers = new HashSet<>();
        followers.add(2);
        followers.add(3);

        return User.builder().
                id(1).
                name("Joe").
                followers(followers).
                isSeller(isSeller).
                build();
    }

    public static User getUserWithFollowed(boolean isSeller){
        Set<Integer> followed = new HashSet<>();
        followed.add(2);
        followed.add(3);

        return User.builder().
                id(1).
                name("Joe").
                followed(followed).
                isSeller(isSeller).
                build();
    }

    public static User getSellerUser(String name, int id){
        return User.builder().
                id(id).
                name(name).
                isSeller(true).
                build();
    }

    public static UserFollowersResponseDto getUserFollowersResponseDto(User mainUser, User ...userToFollow) {
        List<UserResponseDto> users = new ArrayList<>();
        Arrays.stream(userToFollow)
                .forEach(user -> users.add(new UserResponseDto(user.getId(), user.getName())));

        UserFollowersResponseDto userFollowersResponseDto = new UserFollowersResponseDto();
        userFollowersResponseDto.setUserId(mainUser.getId());
        userFollowersResponseDto.setUserName(mainUser.getName());
        userFollowersResponseDto.setFollowers(users);
        return userFollowersResponseDto;
    }

    public static UserFollowedResponseDto getUserFollowedResponseDto(User mainUser, User ...followedUser) {
        List<UserResponseDto> users = new ArrayList<>();
        Arrays.stream(followedUser)
                .forEach(user -> users.add(new UserResponseDto(user.getId(), user.getName())));

        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto();
        userFollowedResponseDto.setUserId(mainUser.getId());
        userFollowedResponseDto.setUserName(mainUser.getName());
        userFollowedResponseDto.setFollowed(users);
        return userFollowedResponseDto;
    }
    public static List<PostResponseDto> ascPostResponseDTOBuilder(int userId, int productId){
        List<Post> posts = new ArrayList<>();
        posts.add(Post.builder().
                userId(userId).
                price(500D).
                productId(productId).
                date(LocalDate.now()).
                category(100).
                build());

        posts.add(Post.builder().
                userId(userId+1).
                price(400D).
                productId(productId).
                date(LocalDate.now().minusDays(3)).
                category(50).
                build());

        posts.add(Post.builder().
                userId(userId+2).
                price(600D).
                productId(productId).
                date(LocalDate.now().minusDays(7)).
                category(50).
                build());

        return posts.stream().
                map(p -> mapper.map(p, PostResponseDto.class)).
                collect(Collectors.toList());
    }


    public static void loadData() {
        Set<User> loadedData = new HashSet<>();

        ObjectMapper objectMapper = new ObjectMapper();
        File file;
        try {
            file = ResourceUtils.getFile("classpath:users.json");
            loadedData = objectMapper.readValue(file, new TypeReference<Set<User>>(){});
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your resources files");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed while initializing DB, check your JSON formatting.");
        }

        users = loadedData;
    }
    

    public static Set<User> getUsers() {
        return users;
    }
}

