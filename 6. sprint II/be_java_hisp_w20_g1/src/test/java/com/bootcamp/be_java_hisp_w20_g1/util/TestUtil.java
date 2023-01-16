package com.bootcamp.be_java_hisp_w20_g1.util;

import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestUtil {

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
                date(LocalDate.of(2023, 01, 10)).
                category(50).
                build());

        return posts;
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
            postDto.get(i).setProduct(getProductById(i+1));
        }
        return new PostListResponseDto(id, postDto);
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

}
