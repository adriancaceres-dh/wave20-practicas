package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class PostRepositoryImp implements PostRepository{

    private final Map<Integer, PostDTO> mapPosts;

    public PostRepositoryImp(Map<Integer, PostDTO> mapPosts) {
        this.mapPosts = mapPosts;
        loadPost();
    }

    @Override
    public Set<PostDTO> findPostsById(Set<Integer> listPostId) {
        return listPostId.stream().map(p -> mapPosts.get(p)).filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= 2).collect(Collectors.toSet());
    }


    public Map<Integer, PostDTO> loadPost(){
        mapPosts.put(1, PostDTO.builder().postId(1).userId(1).date(LocalDate.of(2022, 12, 29)).productDTO(
                ProductDTO.builder().idProduct(1).nameProduct("Televisor").type("Tecnologia").brand("Samsung").color("Negro").note("TV 58 pulgadas").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(2, PostDTO.builder().postId(2).userId(2).date(LocalDate.of(2022, 12, 28)).productDTO(
                ProductDTO.builder().idProduct(1).nameProduct("Nevera").type("Tecnologia").brand("Samsung").color("Negro").note("nevera").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(3, PostDTO.builder().postId(3).userId(3).date(LocalDate.of(2022, 11, 29)).productDTO(
                ProductDTO.builder().idProduct(1).nameProduct("Licuadora").type("Tecnologia").brand("Samsung").color("Negro").note("9 litros").build()
        ).caregory(2).price(2.000).build());
        mapPosts.put(4, PostDTO.builder().postId(4).userId(4).date(LocalDate.of(2022, 11, 27)).productDTO(
                ProductDTO.builder().idProduct(1).nameProduct("Camisetas").type("Ropa").brand("Woft").color("Negro").note("tela fria").build()
        ).caregory(2).price(2.000).build());

       return mapPosts;
    }
}
