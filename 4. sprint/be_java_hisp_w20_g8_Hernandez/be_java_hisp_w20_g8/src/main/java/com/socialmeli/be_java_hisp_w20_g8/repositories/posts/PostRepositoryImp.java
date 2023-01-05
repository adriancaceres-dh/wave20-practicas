package com.socialmeli.be_java_hisp_w20_g8.repositories.posts;

import com.socialmeli.be_java_hisp_w20_g8.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.PostPromoDTO;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;

import com.socialmeli.be_java_hisp_w20_g8.exceptions.OperationFailedException;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import com.socialmeli.be_java_hisp_w20_g8.models.PostPromo;
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
    private final Map<Integer, PostPromoDTO> mapPostsPromos;
    private final Set<Post> posts;
    private int postCount;

    public PostRepositoryImp(Map<Integer, PostDTO> mapPosts, Map<Integer, PostPromoDTO> mapPostsPromos, Set<PostPromo> postPromos) {
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
            int productId = v.getProductDTO().getProduct_id();
            if (userId == postPromo.getUserId()) {
                if (productId == postPromo.getProduct().getProduct_id()) {
                    throw new OperationFailedException("Product already exits");
                }
            }
        });
        PostPromoDTO postPromoDTO = PostPromoDTO.builder()
                .userId(postPromo.getUserId())
                .date(postPromo.getDate())
                .productDTO(
                        ProductDTO.builder()
                                .product_id(postPromo.getProduct().getProduct_id())
                                .product_name(postPromo.getProduct().getProduct_name())
                                .type(postPromo.getProduct().getType())
                                .brand(postPromo.getProduct().getBrand())
                                .color(postPromo.getProduct().getColor())
                                .notes(postPromo.getProduct().getNotes())
                                .build()
                )
                .category(postPromo.getCategory())
                .price(postPromo.getPrice())
                .hashPromo(postPromo.isHashPromo())
                .discount(postPromo.getDiscount())
                .build();
        mapPostsPromos.put(sizeMapPostPromos + 1, postPromoDTO);
        if (mapPostsPromos.size() > 4) isSave = true;
        return isSave;
    }

    @Override
    public int postPromoCountUser(int userId) {
        return (int) mapPostsPromos.entrySet().stream().filter(p -> p.getValue().getUserId() == userId && p.getValue().isHashPromo()).count();
    }

    public Map<Integer, PostPromoDTO> loadPostPromo() {

        mapPostsPromos.put(1, PostPromoDTO.builder().userId(5).date(LocalDate.of(2022, 12, 29)).productDTO(
                ProductDTO.builder().product_id(1).product_name("Television").type("Technology").brand("Samsung").color("Black").notes("TV 68 inches").build()
        ).category(2).price(2000).hashPromo(true).discount(0.23).build());
        mapPostsPromos.put(2, PostPromoDTO.builder().userId(5).date(LocalDate.of(2022, 12, 28)).productDTO(
                ProductDTO.builder().product_id(1).product_name("Freezer").type("Technology").brand("Samsung").color("Black").notes("Freezer").build()
        ).category(2).price(2000).hashPromo(true).discount(0.23).build());
        mapPostsPromos.put(3, PostPromoDTO.builder().userId(7).date(LocalDate.of(2022, 11, 29)).productDTO(
                ProductDTO.builder().product_id(1).product_name("Blender").type("Technology").brand("Samsung").color("Black").notes("9 liters").build()
        ).category(2).price(2000).build());
        mapPostsPromos.put(4, PostPromoDTO.builder().userId(6).date(LocalDate.of(2022, 11, 27)).productDTO(
                ProductDTO.builder().product_id(1).product_name("Shirt").type("Clothes").brand("Woft").color("Black").notes("Sports shirt").build()
        ).category(2).price(2000).hashPromo(true).discount(0.23).build());

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
