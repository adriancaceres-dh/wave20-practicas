package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.*;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
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
        Product product = Product.builder()
                .productId(postDTO.getProduct().getProductId())
                .productName(postDTO.getProduct().getProductName())
                .type(postDTO.getProduct().getType())
                .brand(postDTO.getProduct().getBrand())
                .color(postDTO.getProduct().getColor())
                .notes(postDTO.getProduct().getNotes())
                .build();
        Post post = Post.builder()
                .postId(postRepository.getPosts().size() + 1)
                .userId(postDTO.getUserId())
                .category(postDTO.getCategory())
                .price(postDTO.getPrice())
                .product(product)
                .date(postDTO.getDate())
                .build();
        postRepository.addPost(post);
        return "Publicacion agregada";
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
    @Override
    public String addPromoPost(PromoPostDTO postDTO) {
        if (userRepository.getUserById(postDTO.getUserId()) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        Product product = Product.builder()
                .productId(postDTO.getProduct().getProductId())
                .productName(postDTO.getProduct().getProductName())
                .type(postDTO.getProduct().getType())
                .brand(postDTO.getProduct().getBrand())
                .color(postDTO.getProduct().getColor())
                .notes(postDTO.getProduct().getNotes())
                .build();
        Post post = Post.builder()
                .postId(postRepository.getPosts().size() + 1)
                .userId(postDTO.getUserId())
                .category(postDTO.getCategory())
                .price(postDTO.getPrice())
                .product(product)
                .date(postDTO.getDate())
                .hasPromo(postDTO.isHasPromo())
                .discount(postDTO.getDiscount())
                .build();
        postRepository.addPost(post);
        return "Publicacion con promocion agregada";
    }
    @Override
    public UserPromoPostResponseDTO getPostPromoCount(int userId) {
        User user = userRepository.getUserById(userId);
         if (user == null) {
           throw new NotFoundException("El usuario ingresado no existe.");
        }
        List<Post> postList = postRepository.getPosts().stream().filter(p->p.getUserId() == user.getUserId()).collect(Collectors.toList());
         int quantityPost = postList.size();
         if(quantityPost == 0){
             throw new NotFoundException("El usuario " + user.getUserName() + " no cuenta con publicaciones");
         }
        List<Post> hasPromoList = postList.stream().filter(p-> p.isHasPromo() == true).collect(Collectors.toList());
        int count = hasPromoList.size();
        return new UserPromoPostResponseDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public PromoPostResponseDTO getPostPromoList(int userId, String order) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe.");
        }
        List<Post> postList = postRepository.getPosts().stream().filter(p->p.getUserId() == user.getUserId()).collect(Collectors.toList());
        int quantityPost = postList.size();
        if(quantityPost == 0){
            throw new NotFoundException("El usuario " + user.getUserName() + " no cuenta con publicaciones");
        }
        List<PromoPostDTO> hasPromoList = postList.stream().filter(p-> p.isHasPromo() == true)
                .map(u -> mapper.map(u, PromoPostDTO.class)).collect(Collectors.toList());
        if (order != null && order.equals("name_product_desc")) {
            hasPromoList = hasPromoList.stream().sorted(Comparator.comparing(x -> x.getProduct().getProductName(), Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            hasPromoList = hasPromoList.stream().sorted(Comparator.comparing(x -> x.getProduct().getProductName())).collect(Collectors.toList());
        }
        return new PromoPostResponseDTO(user.getUserId(),user.getUserName(),hasPromoList);
    }
}
