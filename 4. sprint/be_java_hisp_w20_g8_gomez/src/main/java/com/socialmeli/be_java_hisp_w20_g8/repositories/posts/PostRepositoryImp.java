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
    private final Map<Integer,Post> posts;
    private int postCount;

    public PostRepositoryImp(Map<Integer, PostDTO> mapPosts) {
        this.mapPosts = mapPosts;
        this.posts = new HashMap<Integer,Post>();
        loadPost();
        this.postCount = posts.size();
    }


    @Override
    public Set<PostDTO> findPostsById(Set<Integer> listPostId) {
        return listPostId.stream().map(mapPosts::get).filter(post -> ChronoUnit.WEEKS.between(post.getDate(), LocalDate.now()) <= 2).collect(Collectors.toSet());
    }

    @Override
    public Post getPostById(Integer id) {
        return posts.get(id);
    }


    @Override
    public int createPost(Post post, PostDTO postDTO) {
        post.setId(++postCount);
        posts.put(postCount,post);
        postDTO.setPost_id(postCount);
        mapPosts.put(post.getId(), postDTO);
        return postCount;
    }

    public Map<Integer, PostDTO> loadPost(){
        posts.put(1,new Post(1, 5, LocalDate.of(2022, 12, 29), 1, 2, 2000));
        posts.put(2,new Post(2, 5, LocalDate.of(2022, 12, 28), 2, 2, 2000));
        posts.put(3,new Post(3, 7, LocalDate.of(2022, 11, 29), 3, 2, 2000));
        posts.put(4,new Post(4, 6, LocalDate.of(2022, 11, 27), 4, 2, 2000));
        posts.put(5,new Post(5, 5, LocalDate.of(2022, 12, 30), 5, 2, 2000,true,0.2));

        mapPosts.put(1, PostDTO.builder().post_id(1).user_id(5).date(LocalDate.of(2022, 12, 29)).product(
                ProductDTO.builder().product_id(1).product_name("Television").type("Technology").brand("Samsung").color("Black").notes("TV 68 inches").build()
        ).category(2).price(2000).build());
        mapPosts.put(2, PostDTO.builder().post_id(2).user_id(5).date(LocalDate.of(2022, 12, 28)).product(
                ProductDTO.builder().product_id(2).product_name("Freezer").type("Technology").brand("Samsung").color("Black").notes("Freezer").build()
        ).category(2).price(2000).build());
        mapPosts.put(3, PostDTO.builder().post_id(3).user_id(7).date(LocalDate.of(2022, 11, 29)).product(
                ProductDTO.builder().product_id(3).product_name("Blender").type("Technology").brand("Samsung").color("Black").notes("9 liters").build()
        ).category(2).price(2000).build());
        mapPosts.put(4, PostDTO.builder().post_id(4).user_id(6).date(LocalDate.of(2022, 11, 27)).product(
                ProductDTO.builder().product_id(4).product_name("Shirt").type("Clothes").brand("Woft").color("Black").notes("Sports shirt").build()
        ).category(2).price(2000).build());
        mapPosts.put(5, PostDTO.builder().post_id(5).user_id(5).date(LocalDate.of(2022, 12, 30)).product(
                ProductDTO.builder().product_id(5).product_name("TShirt").type("Clothes").brand("CAP").color("Blue").notes("Sports shirt").build()
        ).category(2).price(2000).build());

       return mapPosts;
    }
}
