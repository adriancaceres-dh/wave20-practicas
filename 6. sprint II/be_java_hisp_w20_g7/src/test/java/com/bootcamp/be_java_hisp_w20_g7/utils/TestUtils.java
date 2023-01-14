package com.bootcamp.be_java_hisp_w20_g7.utils;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.ProductDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.Product;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class TestUtils {
    public static LocalDate date = LocalDate.parse("2022-12-30");
    public static Product product = new Product(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
    public static Product product2 = new Product(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
    public static ProductDto productDto = new ProductDto(3, "Silla Gamer", "Gamer", "Racer", "Black", "Special Edition");
    public static ProductDto productDto2 = new ProductDto(3, "Silla Gamer", "Gamer", "Racer", "Pink", "Special Edition");
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
}
