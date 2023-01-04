package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.dto.UserDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
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
    public String addPost(PostDTO postDTO){

        if (userRepository.getUserById(postDTO.getUser_id()) != null) {
            Product product = Product.builder()
                    .product_id(postDTO.getProduct().getProduct_id())
                    .product_name(postDTO.getProduct().getProduct_name())
                    .type(postDTO.getProduct().getType())
                    .brand(postDTO.getProduct().getBrand())
                    .color(postDTO.getProduct().getColor())
                    .notes(postDTO.getProduct().getNotes())
                    .build();
            Post post = Post.builder()
                    .user_id(postDTO.getUser_id())
                    .category(postDTO.getCategory())
                    .price(postDTO.getPrice())
                    .product(product)
                    .date(postDTO.getDate())
                    .build();
            postRepository.addPost(post);
            return "Publicacion agregada";
        } else {
            throw new NotFoundException("El usuario ingresado no existe");
        }
    }

    @Override
    public List<PostDTO> getPost(int userId, String order) {
        LocalDate dateNow = LocalDate.now();
        List<PostDTO> postList = new ArrayList<>();

        User userEx = userRepository.getUserById(userId);
        if (userEx == null){
            throw new NotFoundException("El usuario ingresado no existe.");
        }

            for (User user : userRepository.getUserById(userId).getFollowed()) {
                postList.addAll(postRepository.getPosts().stream().filter(post -> post.getUser_id() == user.getUser_id())
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
