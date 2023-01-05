package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.ProductPromoDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserListPostProductPromoDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserProductPromoCountDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.DataIsnotCorrectException;
import com.bootcamp.be_java_hisp_w20_g7.exception.PostEmptyException;
import com.bootcamp.be_java_hisp_w20_g7.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g7.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository iPostRepository;

    @Autowired
    IFollowRepository iFollowRepository;

    @Autowired
    IUserRepository iUserRepository;

    ModelMapper modelMapper;

    public PostService() {
        modelMapper = new ModelMapper();
    }


    @Override
    public String createPost(PostCreateDto postCreateDto) {

        User user = iUserRepository.findById(postCreateDto.getUserId());
        if (user == null) throw new UserNotFoundException("User with id " + postCreateDto.getUserId() + " not found");
        if (postCreateDto == null) {
            throw new PostEmptyException("Post is empty");
        }
        Post post = modelMapper.map(postCreateDto, Post.class);
        calculateId(post);
        if (post.getPrice() <= 0) {
            throw new DataIsnotCorrectException("Price incorrect, it should be greater than 0");
        }
        if (iPostRepository.save(post)) {
            return "Post registered successfully";
        } else {
            return "Could no register post";
        }
    }

    public void calculateId(Post post) {
        post.setPostId(iPostRepository.findAll().stream().filter(post1 -> post.getUserId() == post1.getUserId())
                .map(Post::getPostId)
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElseGet(() -> 0) + 1);
    }

    @Override
    public UserPostFollowedDto postUsersFollowed(int userId, String order) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");
        List<Integer> followedIds = iFollowRepository.findAll().stream().filter(e -> e.getIdFollower() == userId).map(Follow::getIdFollowed).collect(Collectors.toList());
        List<Post> posts;
        if (order == null) order = "";
        if (order.equals("date_desc")) {
            posts = iPostRepository.findAll().stream()
                    .filter(e -> followedIds.contains(e.getUserId()) && !e.getDate().isBefore(LocalDate.now().minusDays(15)))
                    .sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
        } else {
            posts = iPostRepository.findAll().stream()
                    .filter(e -> followedIds.contains(e.getUserId()) && !e.getDate().isBefore(LocalDate.now().minusDays(15)))
                    .sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
        }

        List<PostDto> postDtos = posts.stream().map(e -> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
        return new UserPostFollowedDto(userId, postDtos);
    }

    public String createPostProductPromo(ProductPromoDto productPromoDto){

        User user = iUserRepository.findById(productPromoDto.getUserId());
        if (user == null) throw new UserNotFoundException("User not found");
        if (productPromoDto == null) throw new PostEmptyException("Post is empty");

        Post post = modelMapper.map(productPromoDto, Post.class);

        calculateId(post);
        if (post.getPrice() <= 0) {
            throw new DataIsnotCorrectException("The price should be greater than 0");
        }
        if (iPostRepository.save(post)) {
            return "Post registered successfully";
        } else {
            return "Could no register post";
        }
    }

    @Override
    public UserProductPromoCountDto countProductPromo(int userId) {

        User user = iUserRepository.findById(userId);

        if (user == null) throw new UserNotFoundException("user not found");

        int productPromoCount = (int) iPostRepository.findAll().stream().filter(e -> e.getUserId() == userId && e.isHasPromo()).count();

        return new UserProductPromoCountDto(userId, user.getUserName(), productPromoCount);

    }

    @Override
    public UserListPostProductPromoDto listPostProductPromo(int userId) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");

        List<PostDto> listPostPromo = iPostRepository.findAll().stream().filter(p -> p.getUserId() == userId && p.isHasPromo())
                .map(p -> modelMapper.map(p, PostDto.class)).collect(Collectors.toList());

        return new UserListPostProductPromoDto(userId, user.getUserName(), listPostPromo);
    }
}
