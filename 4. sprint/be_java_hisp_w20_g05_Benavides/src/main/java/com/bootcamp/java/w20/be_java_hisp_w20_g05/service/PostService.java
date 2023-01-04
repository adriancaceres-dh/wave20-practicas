package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostWithDiscountRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountCountDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.UserProductDiscountListDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.IdNotFoundException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import java.time.LocalDate;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{
    private int post_id = 36;
    @Autowired
    public IPostRepository postRepository;
    @Autowired
    public IUserService userService;
    @Override
    public List<PostResponseDTO> filterBy(String name) {
        return null;
    }

    @Override
    public Post newPost(PostRequestDTO postRequestDTO) {
        if(postRequestDTO == null) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        Post newPost = Post.builder()
                .id(++post_id)
                .category(postRequestDTO.getCategory())
                .price(postRequestDTO.getPrice())
                .userId(postRequestDTO.getUserId())
                .discount(0)
                .date(postRequestDTO.getDate())
                .userId(postRequestDTO.getUserId())
                .product(Product.builder()
                            .id(postRequestDTO.getProduct().getProduct_id())
                            .name(postRequestDTO.getProduct().getProduct_name())
                            .brand(postRequestDTO.getProduct().getBrand())
                            .color(postRequestDTO.getProduct().getColor())
                            .notes(postRequestDTO.getProduct().getNotes())
                            .type(postRequestDTO.getProduct().getType())
                            .build()
                        )
                .build();
        if(!postRepository.add(newPost)) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        // --> Pendiente chequear esta excepcion, validar datos para que dispare.
        return newPost;
    }

    //Requerimiento 006 + 009
    public FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order){
        User userInBd = userService.getById(userId);
        FollowedUsersPostsResponse result = new FollowedUsersPostsResponse();

        try
        {
            Collection<Post> followedUsersPosts = new ArrayList<>();

            userInBd.getFollowing()
                    .stream().forEach(followedUsersIds -> followedUsersPosts
                            .addAll(postRepository
                                    .filterByUserId(followedUsersIds)
                                    .stream().filter(post -> post
                                            .getDate()
                                            .isAfter(LocalDate.now().minusDays(14)))
                                    .collect(Collectors.toList())));

            Collection<FollowedUserPostDTO> postResults = new ArrayList<>();

            int auxSign = (order!= null && order.equalsIgnoreCase("date_asc"))? 1 : -1;
            followedUsersPosts.stream()
                    .sorted((x,y) -> auxSign*(x.getDate().compareTo(y.getDate())))
                    .forEach(post ->
                    postResults.add(new FollowedUserPostDTO(post.getUserId(),
                            post.getId(),
                            post.getDate(),
                            new FollowedUserProductDTO(post.getProduct().getId(), post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes()),
                            post.getCategory(),
                            post.getPrice())));

            result = new FollowedUsersPostsResponse(userInBd.getId(), postResults);

        } catch (IdNotFoundException ex){

        }

        return result;
    }

    @Override
    public void newPostWithDiscount(PostWithDiscountRequestDTO postWithDiscountRequestDTO) {
        if(postWithDiscountRequestDTO == null) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        Post newPostWithDiscount = Post.builder()
                .id(++post_id)
                .userId(postWithDiscountRequestDTO.getUserId())
                .date(postWithDiscountRequestDTO.getDate())
                .category(postWithDiscountRequestDTO.getCategory())
                .price(postWithDiscountRequestDTO.getPrice())
                .discount(postWithDiscountRequestDTO.getDiscount())
                .product(Product.builder()
                        .id(postWithDiscountRequestDTO.getProduct().getProduct_id())
                        .name(postWithDiscountRequestDTO.getProduct().getProduct_name())
                        .brand(postWithDiscountRequestDTO.getProduct().getBrand())
                        .color(postWithDiscountRequestDTO.getProduct().getColor())
                        .notes(postWithDiscountRequestDTO.getProduct().getNotes())
                        .type(postWithDiscountRequestDTO.getProduct().getType())
                        .build()
                )
                .build();
        if(!postRepository.add(newPostWithDiscount))
            throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        //Check with validations in next sprint;
    }

    @Override
    public UserProductDiscountCountDTO getDiscountUserProducts(int userId) {
        int userPosts = postRepository.getAll().stream().filter(post -> post.getUserId() == userId
            && post.getDiscount() > 0).collect(Collectors.toList()).size();
        String userName = userService.getById(userId).getUserName();
        return UserProductDiscountCountDTO.builder()
                .user_id(userId)
                .user_name(userName)
                .promo_products_count(userPosts)
                .build();
    }

    @Override
    public UserProductDiscountListDTO getDiscountedUserProductList(int userId) {
        String userName = userService.getById(userId).getUserName();
        List<Post> userPosts = postRepository.getAll().stream().filter(post -> post.getUserId() == userId
            && post.getDiscount() > 0).collect(Collectors.toList());
        return UserProductDiscountListDTO.builder()
                .user_id(userId)
                .user_name(userName)
                .posts(userPosts)
                .build();
    }
}
