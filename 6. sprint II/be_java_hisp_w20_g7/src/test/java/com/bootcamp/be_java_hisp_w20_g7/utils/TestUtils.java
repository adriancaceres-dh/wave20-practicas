package com.bootcamp.be_java_hisp_w20_g7.utils;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserFollowersDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.Product;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static LocalDate date = LocalDate.parse("2022-12-30");
    public static Product product = new Product(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
    public static Product product2 = new Product(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
    public static ProductDto productDto = new ProductDto(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
    public static ProductDto productDto2 = new ProductDto(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
    public static UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto(1, "Soraya", 2);

    public static List<User> users() {
        return Arrays.asList(new User(1, "Soraya"), new User(3, "Nathalia"));
    }

    public static List<Post> postListTestToTest() {
        List<Post> posts = Arrays.asList(new Post(3, 1, date, product, 100, 2000, false, 22.0),
                new Post(3, 2, LocalDate.parse("2022-11-30"), product2, 100, 2500, false, 22.0),
                new Post(3, 3, LocalDate.parse("2023-01-01"), product2, 100, 3000, false, 22.0));
        return posts;
    }

    public static List<Follow> followListToTest() {
        List<Follow> follows = Arrays.asList(new Follow(1, 3), new Follow(2, 3),
                new Follow(8, 3), new Follow(4, 3), new Follow(5, 4),
                new Follow(5, 2));
        return follows;
    }

    public static List<PostDto> postDtoAscOrder() {

        List<PostDto> postDtosExpectAsc = Arrays.asList(new PostDto(3, 3, LocalDate.parse("2023-01-01"), productDto2, 100, 3000),
                new PostDto(3, 1, date, productDto, 100, 2000));
        return postDtosExpectAsc;
    }

    public static List<PostDto> postDtoDescOrder() {

        List<PostDto> postDtosExpectDesc = Arrays.asList(
                new PostDto(3, 1, date, productDto, 100, 2000), new PostDto(3, 3, LocalDate.parse("2023-01-01"), productDto2, 100, 3000));
        return postDtosExpectDesc;
    }

    public static List<Follow> userFollowsTestOK() {

        List<Follow> follows = new ArrayList<>();
        follows.add(new Follow(2, 1));
        follows.add(new Follow(3, 1));
        follows.add(new Follow(1, 5));

        return follows;
    }

    public static List<Follow> userFollowsTest() {

        List<Follow> follows = new ArrayList<>();
        follows.add(new Follow(2, 1));
        follows.add(new Follow(3, 1));
        follows.add(new Follow(4, 1));
        follows.add(new Follow(5, 1));
        follows.add(new Follow(1, 5));

        return follows;
    }

    public static UserFollowersDto userFollowersDtoTest(String order) {

        List<UserDto> list = new ArrayList();

        if (order.equals("name_asc")) {
            list.add(new UserDto(5, "Manuel"));
            list.add(new UserDto(4, "Ronald"));
            list.add(new UserDto(2, "Sebatian"));
            list.add(new UserDto(3, "Tomas"));
        }

        if (order.equals("name_desc")) {
            list.add(new UserDto(3, "Tomas"));
            list.add(new UserDto(2, "Sebatian"));
            list.add(new UserDto(4, "Ronald"));
            list.add(new UserDto(5, "Manuel"));
        }

        UserFollowersDto userFollowersDto = new UserFollowersDto(1, "Nathalia", list);

        return userFollowersDto;
    }

    public static List<User> usersTest() {

        List<User> list = new ArrayList<>();
        list.add(new User(2, "Sebatian"));
        list.add(new User(3, "Tomas"));
        list.add(new User(4, "Ronald"));
        list.add(new User(5, "Manuel"));
        list.add(new User(1, "Nathalia"));


        return list;
    }

    public static List<Post> postListTestToTest0008() {
        List<Post> posts = Arrays.asList(new Post(3, 1, date, product, 100, 2000, false, 0.0),
                new Post(3, 2, LocalDate.parse("2022-11-30"), product2, 100, 2500, false, 0.0),
                new Post(3, 3, LocalDate.parse("2023-01-01"), product2, 100, 3000, false, 0.0),
                new Post(3, 4, LocalDate.parse("2022-12-17"), product2, 100, 3500, false, 0.0));
        return posts;
    }

    public static List<PostDto> postDtoBetween15Days() {

        List<PostDto> postDtosExpectAsc = Arrays.asList(new PostDto(3, 3, LocalDate.parse("2023-01-01"),
                        productDto2, 100, 3000),
                new PostDto(3, 1, date, productDto, 100, 2000));
        return postDtosExpectAsc;
    }
}
