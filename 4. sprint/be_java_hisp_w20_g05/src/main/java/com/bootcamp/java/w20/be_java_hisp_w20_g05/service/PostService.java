package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserPostDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUserProductDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.followed_users_posts.FollowedUsersPostsResponse;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.User;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IPostRepository;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService{
    @Autowired
    public IPostRepository postRepository;
    @Autowired
    public IUserService userService;
    @Override
    public List<PostResponseDTO> filterBy(String name) {
        return null;
    }

    //Requerimiento 006 + 009
    public FollowedUsersPostsResponse getFollowedUsersPosts(int userId, String order){
        User userInBd = userService.getById(userId);

        Collection<Post> followedUsersPosts = new ArrayList<>();
        userInBd.getFollowing()
                .stream().forEach(followedUsersIds -> followedUsersPosts
                        .addAll(postRepository
                                .filterByUserId(followedUsersIds)
                                .stream().filter(post -> post
                                        .getDate()
                                        .isAfter(LocalDate.now().minusDays(14)))
                                .collect(Collectors.toList())));

        if (order.equalsIgnoreCase("date_asc"))
            followedUsersPosts.stream().sorted((x,y) -> x.getDate().compareTo(y.getDate()));

        if (order.equalsIgnoreCase("date_desc"))
            followedUsersPosts.stream().sorted((x,y) -> - x.getDate().compareTo(y.getDate()));

        Collection<FollowedUserPostDTO> postResults = new ArrayList<>();

        followedUsersPosts.stream().forEach(post ->
                postResults.add(new FollowedUserPostDTO(post.getUserId(),
                        post.getId(),
                        post.getDate(),
                        new FollowedUserProductDTO(post.getProduct().getId(), post.getProduct().getName(), post.getProduct().getType(), post.getProduct().getBrand(), post.getProduct().getColor(), post.getProduct().getNotes()),
                        post.getCategory(),
                        post.getPrice())));

        FollowedUsersPostsResponse result = new FollowedUsersPostsResponse(userInBd.getId(), postResults);

        return result;
    }
}
