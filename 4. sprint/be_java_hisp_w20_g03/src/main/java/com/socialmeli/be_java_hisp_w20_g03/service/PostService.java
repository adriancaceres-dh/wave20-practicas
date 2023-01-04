package com.socialmeli.be_java_hisp_w20_g03.service;

import com.socialmeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.PromoPostDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.SellerPromoCountDTO;
import com.socialmeli.be_java_hisp_w20_g03.dto.SellerPromoListDTO;
import com.socialmeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialmeli.be_java_hisp_w20_g03.model.Post;
import com.socialmeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialmeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialmeli.be_java_hisp_w20_g03.model.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;
    ModelMapper mapper = new ModelMapper();

    @Override
    public String addPost(PostDTO postDTO) {
        if (userRepository.getUserById(postDTO.getUserId()) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        Post post = mapper.map(postDTO, Post.class);
        post.setPostId(postRepository.getPosts().size() + 1);
        postRepository.addPost(post);
        return "Publicacion agregada";
    }

    @Override
    public SellerPromoCountDTO getPromoPostCount(int userId) {
        if (userRepository.getUserById(userId) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        int count = (int) postRepository.getPosts().stream()
                .filter(post -> post.getUserId() == userId)
                .filter(Post::isHasPromo)
                .count();
        return SellerPromoCountDTO.builder()
                .userId(userId)
                .userName(userRepository.getUserById(userId).getUserName())
                .promoCount(count)
                .build();
    }

    @Override
    public SellerPromoListDTO getPromoPostList(int userId) {
        if (userRepository.getUserById(userId) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        List<Post> posts = postRepository.getPosts().stream()
                .filter(post -> post.getUserId() == userId)
                .filter(Post::isHasPromo)
                .collect(Collectors.toList());
        List<PromoPostDTO> postDTOS = new ArrayList<>();
        for (Post post : posts) {
            postDTOS.add(mapper.map(post, PromoPostDTO.class));
        }
        return SellerPromoListDTO.builder()
                .userId(userId)
                .userName(userRepository.getUserById(userId).getUserName())
                .posts(postDTOS)
                .build();
    }

    @Override
    public List<PostDTO> getPost(int userId, String order) {
        LocalDate dateNow = LocalDate.now();
        List<PostDTO> postList = new ArrayList<>();
        User userEx = userRepository.getUserById(userId);

        if (userEx == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        for (User user : userRepository.getUserById(userId).getFollowed()) {
            postList.addAll(postRepository.getPosts().stream().filter(post -> post.getUserId() == user.getUserId())
                    .filter(post -> DAYS.between(post.getDate(), dateNow) <= 15)
                    .map(u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList()));
        }
        if (order != null && order.equals("date_desc")) {
            postList = postList.stream().sorted(Comparator.comparing(x -> x.getDate(), Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            postList = postList.stream().sorted(Comparator.comparing(x -> x.getDate())).collect(Collectors.toList());
        }
        return postList;
    }
}
