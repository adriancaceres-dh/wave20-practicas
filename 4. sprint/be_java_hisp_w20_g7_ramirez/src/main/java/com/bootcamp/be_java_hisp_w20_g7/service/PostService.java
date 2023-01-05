package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PostCountProductDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PostListPromoDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.DataIsnotCorrectException;
import com.bootcamp.be_java_hisp_w20_g7.exception.PostDiscountException;
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

        //US 0010 Validation when it is promotion
        if (postCreateDto.isHasPromo() && (postCreateDto.getDiscount() <= 0 || postCreateDto.getDiscount() >= 1)) {
            throw new PostDiscountException("The discount value is not valid.");
        }

        //US 0010 Reset discount value to zero as it is not a promotion
        if (!postCreateDto.isHasPromo()) {
            postCreateDto.setDiscount(0);
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

    /**
     * US 0011 Obtener la cantidad de productos en promoción de un determinado vendedor
     * @param userId
     * @return
     */
    @Override
    public PostCountProductDto postCountProduct(int userId) {

        User user = iUserRepository.findById(userId);

        if (user == null) {
            throw new UserNotFoundException("User with id" + userId + " not found");
        }

        // User post that has promo
        List<Post> posts = iPostRepository.findAll()
                .stream()
                .filter(p -> p.getUserId() == userId && p.isHasPromo())
                .collect(Collectors.toList());

        PostCountProductDto dto = new PostCountProductDto(userId, user.getUserName(), posts.size());

        return dto;
    }

    /**
     * US 0012 Obtener un listado de todos los productos en promoción de un determinado vendedor
     * @param userId
     * @return
     */
    @Override
    public PostListPromoDto listPromo(int userId) {
        User user = iUserRepository.findById(userId);

        if (user == null) {
            throw new UserNotFoundException("User with id" + userId + " not found");

        }
            //List<Post> posts = iPostRepository.findAll()
                    //.stream()
                    //.filter(p -> p.getUserId() == userId && p.isHasPromo())
                    //.collect(Collectors.toList());


            List<PostDto> postListPromo = iPostRepository.findAll()
                    .stream()
                    .filter(p -> p.getUserId() == userId && p.isHasPromo())
                    .map(p -> modelMapper.map(p, PostDto.class))
                    .collect(Collectors.toList());


            return new PostListPromoDto(userId, user.getUserName(), postListPromo);

        }
    }