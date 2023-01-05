package com.bootcamp.be_java_hisp_w20_g7_anttury.service;

import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.PostDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.PostPromoDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.UserDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.request.PostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.request.PromoPostCreateDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserPostFollowedDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserPromoPostCountDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.dto.response.UserPromoPostListDto;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Follow;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.Post;
import com.bootcamp.be_java_hisp_w20_g7_anttury.entity.User;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.DataIsnotCorrectException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.PostEmptyException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.exception.UserNotFoundException;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IFollowRepository;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IPostRepository;
import com.bootcamp.be_java_hisp_w20_g7_anttury.repository.IUserRepository;
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
        post.setPostId(iPostRepository.findAll().stream().filter(post1 -> post.getUserId() == post1.getUserId()).map(Post::getPostId).sorted(Comparator.reverseOrder()).findFirst().orElseGet(() -> 0) + 1);
    }

    @Override
    public UserPostFollowedDto postUsersFollowed(int userId, String order) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("user with id " + userId + " not found");
        List<Integer> followedIds = iFollowRepository.findAll().stream().filter(e -> e.getIdFollower() == userId).map(Follow::getIdFollowed).collect(Collectors.toList());
        List<Post> posts;
        if (order == null) order = "";
        if (order.equals("date_desc")) {
            posts = iPostRepository.findAll().stream().filter(e -> followedIds.contains(e.getUserId()) && !e.getDate().isBefore(LocalDate.now().minusDays(15))).sorted(Comparator.comparing(Post::getDate)).collect(Collectors.toList());
        } else {
            posts = iPostRepository.findAll().stream().filter(e -> followedIds.contains(e.getUserId()) && !e.getDate().isBefore(LocalDate.now().minusDays(15))).sorted(Comparator.comparing(Post::getDate).reversed()).collect(Collectors.toList());
        }

        List<PostDto> postDtos = posts.stream().map(e -> modelMapper.map(e, PostDto.class)).collect(Collectors.toList());
        return new UserPostFollowedDto(userId, postDtos);
    }

    /*
    Aquí empiezan los requerimientos individuales.
     */
    @Override
    public String createPromoPost(PromoPostCreateDto promoPostCreateDto) {
        User user = iUserRepository.findById(promoPostCreateDto.getUserId());

        if (user == null)
            throw new UserNotFoundException("User with id " + promoPostCreateDto.getUserId() + " not found");
        if (promoPostCreateDto == null) {
            throw new PostEmptyException("Post is empty");
        }
        if (promoPostCreateDto.isHasPromo() == false || promoPostCreateDto.getDiscount() <= 0) {
            throw new DataIsnotCorrectException("The post has not promo or discount");
        }

        Post post = modelMapper.map(promoPostCreateDto, Post.class);
        calculateId(post);

        if (post.getPrice() <= 0) {
            throw new DataIsnotCorrectException("Price incorrect, it should be greater than 0");
        }
        if (iPostRepository.save(post)) {
            return "Post with promo registered successfully";
        } else {
            return "Could no register post with promo";
        }
    }

    @Override
    public UserPromoPostCountDto countPromoPost(int userId) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("User with id " + userId + " not found");

        int countPromoPost = (int) iPostRepository.findAll().stream().filter(p -> p.getUserId() == userId && p.isHasPromo()).count();

        return new UserPromoPostCountDto(user.getUserId(), user.getUserName(), countPromoPost);
    }

    public UserPromoPostListDto getPostPromoList(int userId) {

        User user = iUserRepository.findById(userId);
        if (user == null) throw new UserNotFoundException("User with id " + userId + " not found");

        List<Post> postList = iPostRepository.findAll().stream().filter(p -> p.getUserId() == userId && p.isHasPromo()).collect(Collectors.toList());
        List<PostPromoDto> postPromoDtoList = postList.stream().map(p -> modelMapper.map(p, PostPromoDto.class)).collect(Collectors.toList());

        return new UserPromoPostListDto(user.getUserId(), user.getUserName(), postPromoDtoList);
    }

}
