package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.request.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import com.socialMeli.be_java_hisp_w20_g03.model.User;
import com.socialMeli.be_java_hisp_w20_g03.utils.DateOrder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
        for (User user : userEx.getFollowed()) {
            postList.addAll(postRepository.getPostsByUserId(user.getUserId()).stream()
                    .map(u -> mapper.map(u, PostDTO.class)).collect(Collectors.toList()));
        }
        if (order != null ) {
            if (order.equals(DateOrder.date_desc.toString())) {
                postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate, Comparator.reverseOrder())).collect(Collectors.toList());
            } else if (order.equals(DateOrder.date_asc.toString())) {
                postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
            } else {
                throw new NotFoundException("El orden ingresado no es valido.");
            }
        }  else {
            postList = postList.stream().sorted(Comparator.comparing(PostDTO::getDate)).collect(Collectors.toList());
        }
        return postList;
    }
}
