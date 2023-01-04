package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;

import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import java.util.HashSet;
import java.util.Set;

@Repository
public class IPostRepositoryImp implements IPostRepository {

    private final Map<Integer, PostDTO> mapPosts;
    private final Set<Post> posts;
    private int postCount;

    public IPostRepositoryImp(Map<Integer, PostDTO> mapPosts) {
        this.mapPosts = mapPosts;
        this.posts = new HashSet<>();
        this.postCount = 0;
        loadPost();
    }

    @Override
    public Set<PostDTO> findPostsById(Set<Integer> listPostId) {
        return listPostId.stream().map(p -> mapPosts.get(p)).filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= 2).collect(Collectors.toSet());
    }

    @Override
    public int createPost(Post post) {
        post.setId(++postCount);
        posts.add(post);
        return postCount;
    }

    public Map<Integer, PostDTO> loadPost(){
        mapPosts.put(1, PostDTO.builder().post_id(1).userId(5).date(LocalDate.of(2022, 12, 29)).product(
                ProductDTO.builder().product_id(1).product_name("Televisor").type("Tecnologia").brand("Samsung").color("Negro").notes("TV 58 pulgadas").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(2, PostDTO.builder().post_id(2).userId(5).date(LocalDate.of(2022, 12, 28)).product(
                ProductDTO.builder().product_id(1).product_name("Nevera").type("Tecnologia").brand("Samsung").color("Negro").notes("nevera").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(3, PostDTO.builder().post_id(3).userId(7).date(LocalDate.of(2022, 11, 29)).product(
                ProductDTO.builder().product_id(1).product_name("Licuadora").type("Tecnologia").brand("Samsung").color("Negro").notes("9 litros").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(4, PostDTO.builder().post_id(4).userId(6).date(LocalDate.of(2022, 11, 27)).product(
                ProductDTO.builder().product_id(1).product_name("Camisetas").type("Ropa").brand("Woft").color("Negro").notes("tela fria").build()
        ).caregory(2).price(2.000).build());

       return mapPosts;
    }
}
