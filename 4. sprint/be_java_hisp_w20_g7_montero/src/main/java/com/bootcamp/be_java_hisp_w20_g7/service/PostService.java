package com.bootcamp.be_java_hisp_w20_g7.service;

import com.bootcamp.be_java_hisp_w20_g7.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.PostPromoDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.request.PostPromoCreateDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PromoProductsCountDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.PromoProductsDto;
import com.bootcamp.be_java_hisp_w20_g7.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7.entity.User;
import com.bootcamp.be_java_hisp_w20_g7.exception.DataIsnotCorrectException;
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

    ModelMapper modelMapperPromo;

    public PostService() {
        modelMapper = new ModelMapper();
        modelMapperPromo = new ModelMapper();
    }

    @Override
    public String createPost(PostCreateDto postCreateDto) {

        User user = iUserRepository.findById(postCreateDto.getUserId());
        if (user == null) throw new UserNotFoundException("User with id " + postCreateDto.getUserId() + " not found");
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

    @Override
    public String createPromoPost(PostPromoCreateDto promoPost) {
        User user = iUserRepository.findById(promoPost.getUserId());
        if (user == null) throw new UserNotFoundException("User with id " + promoPost.getUserId() + " not found");
        if (promoPost.getDiscount() <= 0 || !promoPost.isHasPromo())
            throw new DataIsnotCorrectException("You should have a product in Promo and with discount");
        Post postPromo = modelMapperPromo.map(promoPost, Post.class);
        calculateId(postPromo);
        if (iPostRepository.save(postPromo)) {
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

    @Override
    public PromoProductsCountDto countProductPromo(int userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");
        return new PromoProductsCountDto(userId, iUserRepository.findById(userId).getUserName(), iPostRepository.findAll()
                .stream().filter(post -> post.isHasPromo() && post.getUserId() == userId).count());
    }

    @Override
    public PromoProductsDto promoProductsList(int userId) {
        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");
        return new PromoProductsDto(userId, iUserRepository.findById(userId).getUserName(), iPostRepository.findAll().stream()
                .filter(post -> post.getUserId() == userId && post.isHasPromo())
                .map(e -> modelMapper.map(e, PostPromoDto.class))
                .collect(Collectors.toList()));
    }
}
