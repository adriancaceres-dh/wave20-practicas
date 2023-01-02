package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
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

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Post newPost = Post.builder()
                .id(++post_id)
                .category(String.valueOf(postRequestDTO.getCategory()))
                .price(postRequestDTO.getPrice())
                .discount(0)
                .date(postRequestDTO.getDate())
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
}
