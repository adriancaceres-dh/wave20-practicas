package com.bootcamp.be_java_hisp_w20_g1.util;

import com.bootcamp.be_java_hisp_w20_g1.Parameter;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.PostRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.request.ProductRequestDto;
import com.bootcamp.be_java_hisp_w20_g1.dto.response.*;
import com.bootcamp.be_java_hisp_w20_g1.model.Post;
import com.bootcamp.be_java_hisp_w20_g1.model.User;
import com.bootcamp.be_java_hisp_w20_g1.repository.PostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.ProductRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g1.repository.interfaces.IProductRepository;
import com.bootcamp.be_java_hisp_w20_g1.service.PostService;
import com.bootcamp.be_java_hisp_w20_g1.service.ProductService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IPostService;
import com.bootcamp.be_java_hisp_w20_g1.service.interfaces.IProductService;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;
import java.util.*;
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
                name("Joe").
                followers(followers).
                isSeller(isSeller).
                build();
    }

    public static User getUserWithFollowed(boolean isSeller){
        Set<Integer> followed = new HashSet<>();
        followed.add(2);
        followed.add(3);

        return User.builder().
                id(1).
                name("Joe").
                followed(followed).
                isSeller(isSeller).
                build();
    }

    public static User getSellerUser(String name, int id){
        return User.builder().
                id(id).
                name(name).
                isSeller(true).
                build();
    }

    public static UserFollowersResponseDto getUserFollowersResponseDto(User mainUser, User ...userToFollow) {
        List<UserResponseDto> users = new ArrayList<>();
        Arrays.stream(userToFollow)
                .forEach(user -> users.add(new UserResponseDto(user.getId(), user.getName())));

        UserFollowersResponseDto userFollowersResponseDto = new UserFollowersResponseDto();
        userFollowersResponseDto.setUserId(mainUser.getId());
        userFollowersResponseDto.setUserName(mainUser.getName());
        userFollowersResponseDto.setFollowers(users);
        return userFollowersResponseDto;
    }

    public static UserFollowedResponseDto getUserFollowedResponseDto(User mainUser, User ...followedUser) {
        List<UserResponseDto> users = new ArrayList<>();
        Arrays.stream(followedUser)
                .forEach(user -> users.add(new UserResponseDto(user.getId(), user.getName())));

        UserFollowedResponseDto userFollowedResponseDto = new UserFollowedResponseDto();
        userFollowedResponseDto.setUserId(mainUser.getId());
        userFollowedResponseDto.setUserName(mainUser.getName());
        userFollowedResponseDto.setFollowed(users);
        return userFollowedResponseDto;
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

    public static PostRequestDto postForSaveTest(){
        IPostRepository postRepository = new PostRepository();
        IProductRepository productRepository = new ProductRepository();

        int numProduct = productRepository.getProducts().size()+1;
        int userId = postRepository.getPosts().stream().map(x->x.getUserId()).findFirst().get();


        PostRequestDto postRequestDto = new PostRequestDto();
        ProductRequestDto productRequestDto = new ProductRequestDto();
        productRequestDto.setProductId(numProduct);
        productRequestDto.setProductName("Silla Gamer");
        productRequestDto.setType("nose");
        productRequestDto.setNotes("notas");
        productRequestDto.setColor("rojo");
        productRequestDto.setBrand("hjh");
        postRequestDto.setCategory(1);
        postRequestDto.setDate(LocalDate.now());
        postRequestDto.setPrice(2000D);
        postRequestDto.setUserId(userId);
        postRequestDto.setProduct(productRequestDto);

        return postRequestDto;

    }
    public static int getPostNumber(){
        IPostRepository postRepository = new PostRepository();
        return  postRepository.getPosts().size()+1;
    }

}