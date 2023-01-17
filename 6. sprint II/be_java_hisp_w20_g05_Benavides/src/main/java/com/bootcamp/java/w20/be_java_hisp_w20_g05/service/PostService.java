package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.MessageExceptionDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.FollowedUsersPostsResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.InvalidPostDataException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.exceptions.WrongRequestParamException;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
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
    private int post_id = 39;
    @Autowired
    public IPostRepository postRepository;
    @Autowired
    public IUserService userService;

    private final ModelMapper mapper;

    public PostService() {
        mapper = new ModelMapper();
        mapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE);
    }

    @Override
    public PostResponseDTO newPost(PostRequestDTO postRequestDTO) {
        if (postRequestDTO == null) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));
        Post newPost = mapper.map(postRequestDTO, Post.class);
        newPost.setId(++post_id);

        if(!postRepository.add(newPost)) throw new InvalidPostDataException(new MessageExceptionDTO("Invalid data"));

        return mapper.map(newPost, PostResponseDTO.class);
    }

    //Requerimiento 006 + 009
    public FollowedUsersPostsResponseDTO getFollowedUsersPosts(int userId, String order){
        User userInBd = userService.getById(userId);

        List<Post> followedUsersPosts = postRepository.getAll().stream()
                .filter(post -> userInBd.getFollowing().contains(post.getUserId()) &&
                        post.getDate().isAfter(LocalDate.now().minusDays(14)))
                .collect(Collectors.toList());

        orderList(followedUsersPosts, order);

        List<PostResponseDTO> postResults = new ArrayList<>();
        followedUsersPosts.forEach(post -> postResults.add(mapper.map(post, PostResponseDTO.class)));

        return new FollowedUsersPostsResponseDTO(userId, postResults);
    }

    private void orderList(List<Post> posts, String order) {
        if (order != null) {
            validateOrder(order);
            posts.sort((x,y) -> (order.equalsIgnoreCase("date_asc") ? 1 : -1) *
                    x.getDate().compareTo(y.getDate()));
        }
    }

    private void validateOrder(String order){
        if (!order.equalsIgnoreCase("date_asc") && !order.equalsIgnoreCase("date_desc"))
            throw new WrongRequestParamException(new MessageExceptionDTO("WRONG ORDER PARAMETER"));
    }
}
