package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostCountDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.PromoPostDTO;
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
    public String addPromoPost(PromoPostDTO postPromoDto) {
        if (userRepository.getUserById(postPromoDto.getUserId()) == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        Product product = Product.builder()
                .productId(postPromoDto.getProduct().getProductId())
                .productName(postPromoDto.getProduct().getProductName())
                .type(postPromoDto.getProduct().getType())
                .brand(postPromoDto.getProduct().getBrand())
                .color(postPromoDto.getProduct().getColor())
                .notes(postPromoDto.getProduct().getNotes())
                .build();
        Post post = Post.builder()
                .postId(postRepository.getPosts().size() + 1)
                .userId(postPromoDto.getUserId())
                .category(postPromoDto.getCategory())
                .price(postPromoDto.getPrice())
                .product(product)
                .date(postPromoDto.getDate())
                .hasPromo(postPromoDto.isHasPromo())
                .discount(postPromoDto.getDiscount())
                .build();
        postRepository.addPost(post);
        return "Publicación con promoción agregada";
    }

    @Override
    public PromoPostCountDTO getPromoPostCountById(int userId) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        int count = (int) postRepository.getPosts().stream().filter(p -> p.getUserId() == userId && p.isHasPromo())
                .count();
        return new PromoPostCountDTO(user.getUserId(), user.getUserName(), count);
    }

    @Override
    public List<PromoPostDTO> getPromoPostById(int userId, String order) {
        User user = userRepository.getUserById(userId);
        if (user == null) {
            throw new NotFoundException("El usuario ingresado no existe");
        }
        List<PromoPostDTO> postList= postRepository.getPosts().stream()
                .filter(p -> p.getUserId() == userId && p.isHasPromo()).map(p -> mapper.map(p, PromoPostDTO.class))
                .collect(Collectors.toList());
        if (order != null && order.equals("date_desc")) {
            postList = postList.stream().sorted(Comparator.comparing(x -> x.getDate(), Comparator.reverseOrder())).collect(Collectors.toList());
        } else {
            postList = postList.stream().sorted(Comparator.comparing(x -> x.getDate())).collect(Collectors.toList());
        }
        return postList;
    }
}
