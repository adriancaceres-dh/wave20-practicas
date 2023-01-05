package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.*;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{
    private int post_id = 36;
    @Autowired
    private IPostRepository postRepository;
    @Autowired
    private IUserRepository userRepository;
    private final ModelMapper mapper;

    public PostService() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public void newPost(PostRequestDTO postRequestDTO) {
        if (postRequestDTO == null) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        Post newPost = mapper.map(postRequestDTO, Post.class);
        newPost.setId(++post_id);

        if(!postRepository.add(newPost)) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
    }

    @Override
    public UserPostsCountDTO getPromoPostsCount(int userId) {
        User user = userRepository.getBy(userId);
        long promoPostsCount = postRepository.getAll().stream()
                .filter(post -> post.getUserId() == userId &&
                                post.getDiscount() > 0)
                .count();
        return new UserPostsCountDTO(userId, user.getUserName(), promoPostsCount);
    }

    @Override
    public PromoPostsListDTO getPromoPostsList(int userId) {
        User user = userRepository.getBy(userId);

        List<Post> promoPosts = postRepository.getAll().stream()
                .filter(post -> post.getUserId() == userId &&
                                post.getDiscount() > 0)
                .collect(Collectors.toList());

        List<PromoPostResponseDTO> promoPostResults = new ArrayList<>();

        promoPosts.forEach(post -> promoPostResults.add(mapper.map(post, PromoPostResponseDTO.class)));

        return new PromoPostsListDTO(userId, promoPostResults);
    }

    public FollowingUsersPostsResponseDTO getFollowingUsersPosts(int userId, String order){
        User userInBd = userRepository.getBy(userId);

        List<Post> followedUsersPosts = postRepository.getAll().stream()
                .filter(post -> userInBd.getFollowing().contains(post.getUserId()) &&
                                post.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());

        orderList(followedUsersPosts, order);

        List<PostResponseDTO> postResults = new ArrayList<>();
        followedUsersPosts.forEach(post -> postResults.add(mapper.map(post, PostResponseDTO.class)));

        return new FollowingUsersPostsResponseDTO(userId, postResults);
    }

    public void orderList(List<Post> posts, String order) {
        if (order != null) {
            validateOrder(order);
            posts.sort((x,y) -> (order.equalsIgnoreCase("date_asc") ? 1 : -1) *
                    x.getDate().compareTo(y.getDate()));
        }
    }

    public void validateOrder(String order){
        if (!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc"))
            throw new WrongRequestParamException(new MessageExceptionDTO("WRONG ORDER PARAMETER"));
    }
}
