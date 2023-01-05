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
public class PostRepositoryImp implements IPostRepository {

    private final Map<Integer, PostDTO> mapPosts;
    private final Set<Post> posts;
    private int postCount;
    private int promoCount;

    public PostRepositoryImp(Map<Integer, PostDTO> mapPosts) {
        this.mapPosts = mapPosts;
        this.posts = new HashSet<>();
        loadPost();
        this.postCount = posts.size();
    }


    @Override
    public Set<PostDTO> findPostsById(Set<Integer> listPostId) {
        return listPostId.stream().map(mapPosts::get).filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= 2).collect(Collectors.toSet());
    }

    @Override
    public int createPost(Post post, PostDTO postDTO) {
        post.setId(++postCount);
        posts.add(post);
        postDTO.setPost_id(postCount);
        mapPosts.put(post.getId(), postDTO);

        return postCount;
    }

    @Override
    public int countProductPromo(int idUser){
        promoCount = 0;
        mapPosts.entrySet().forEach(x-> {
            if (x.getValue().isHas_promo() && x.getValue().getUser_id() == idUser){
                promoCount+=1;
            }
        });
        return promoCount;
    }

    @Override
    public Set<PostDTO> findAllProductsPromoByIdUser(int idUser){
        Set<PostDTO> postProductsPromo = new HashSet<>();
        mapPosts.entrySet().forEach(x-> {
            if (x.getValue().isHas_promo() && x.getValue().getUser_id() == idUser){
                postProductsPromo.add(x.getValue());
            }
        });
        return postProductsPromo;
    }


    public Map<Integer, PostDTO> loadPost(){
        posts.add(new Post(1, 5, LocalDate.of(2022, 12, 29), 1, 2, 2000));
        posts.add(new Post(2, 5, LocalDate.of(2022, 12, 28), 2, 2, 2000));
        posts.add(new Post(3, 7, LocalDate.of(2022, 11, 29), 3, 2, 2000));
        posts.add(new Post(4, 6, LocalDate.of(2022, 11, 27), 4, 2, 2000));


        mapPosts.put(1, PostDTO.builder().post_id(1).user_id(5).date(LocalDate.of(2022, 12, 29)).product(
                ProductDTO.builder().product_id(1).product_name("Television").type("Technology").brand("Samsung").color("Black").notes("TV 68 inches").build()
        ).category(2).price(2000).build());
        mapPosts.put(2, PostDTO.builder().post_id(2).user_id(5).date(LocalDate.of(2022, 12, 28)).product(
                ProductDTO.builder().product_id(1).product_name("Freezer").type("Technology").brand("Samsung").color("Black").notes("Freezer").build()
        ).category(2).price(2000).build());
        mapPosts.put(3, PostDTO.builder().post_id(3).user_id(7).date(LocalDate.of(2022, 11, 29)).product(
                ProductDTO.builder().product_id(1).product_name("Blender").type("Technology").brand("Samsung").color("Black").notes("9 liters").build()
        ).category(2).price(2000).build());
        mapPosts.put(4, PostDTO.builder().post_id(4).user_id(6).date(LocalDate.of(2022, 11, 27)).product(
                ProductDTO.builder().product_id(1).product_name("Shirt").type("Clothes").brand("Woft").color("Black").notes("Sports shirt").build()
        ).category(2).price(2000).build());

       return mapPosts;
    }
}
