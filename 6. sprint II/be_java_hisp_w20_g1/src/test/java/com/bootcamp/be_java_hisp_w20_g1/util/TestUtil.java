package com.bootcamp.be_java_hisp_w20_g1.util;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostListResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.PostResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.ProductResponseDto;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.Product;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
                name("Enrique").
                followers(followers).
                isSeller(isSeller).
                build();
    }

}
