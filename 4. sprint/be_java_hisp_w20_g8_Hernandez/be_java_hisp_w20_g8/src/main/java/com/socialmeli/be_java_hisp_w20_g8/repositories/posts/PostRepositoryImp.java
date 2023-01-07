package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostPromoDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import com.socialmeli.be_java_hisp_w20_g8.models.PostPromo;
import com.socialmeli.be_java_hisp_w20_g8.models.Product;
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
    private final Map<Integer, PostPromo> mapPostsPromos;
    private final Set<Post> posts;
    private int postCount;

    public PostRepositoryImp(Map<Integer, PostDTO> mapPosts, Map<Integer, PostPromo> mapPostsPromos, Set<PostPromo> postPromos) {
        this.mapPosts = mapPosts;
        this.mapPostsPromos = mapPostsPromos;
        this.posts = new HashSet<>();
        loadPost();
        loadPostPromo();
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
    public boolean createPostPromo(PostPromo postPromo) {
        boolean isSave = false;
        int sizeMapPostPromos = mapPostsPromos.size();
        mapPostsPromos.forEach((k, v) -> {
            int userId = v.getUserId();
            int productId = v.getProduct().getProduct_id();
            if (userId == postPromo.getUserId()) {
                if (productId == postPromo.getProduct().getProduct_id()) {
                    throw new OperationFailedException("Product already exits");
                }
            }
        });

        postPromo.setPostId(sizeMapPostPromos + 1);
        mapPostsPromos.put(sizeMapPostPromos + 1, postPromo);
        if (mapPostsPromos.size() > 4) isSave = true;
        return isSave;
    }

    @Override
    public int postPromoCountUser(int userId) {
        return (int) mapPostsPromos.entrySet().stream().filter(p -> p.getValue().getUserId() == userId && p.getValue()
                .isHashPromo()).count();
    }

    @Override
    public Map<Integer, PostPromo> getMapPostsPromos() {
        return mapPostsPromos;
    }

    public Map<Integer, PostPromo> loadPostPromo() {

        mapPostsPromos.put(1, new PostPromo(5, 1, LocalDate.of(2022, 12, 29), new Product(
                1, "Television", "Technology", "Samsung", "Black", "TV 68 inches"),
                2, 2000, true, 0.25));

        mapPostsPromos.put(2, new PostPromo(5, 2, LocalDate.of(2022, 12, 28), new Product(
                2, "Freezer", "Technology", "Samsung", "Black", "Freezer"),
                2, 2000, true, 0.25));

        mapPostsPromos.put(3, new PostPromo(7, 3, LocalDate.of(2022, 11, 29), new Product(
                1, "Blender", "Technology", "Samsung", "Black", "9 Liters"),
                2, 2000, true, 0.20));

        mapPostsPromos.put(4, new PostPromo(6, 4, LocalDate.of(2022, 11, 27), new Product(
                1, "Shirt", "Clothes", "Soft", "Black", "Sports shirt"),
                2, 2000, true, 0.20));

        return mapPostsPromos;
    }

    public Map<Integer, PostDTO> loadPost() {
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
