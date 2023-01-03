package com.socialMeli.be_java_hisp_w20_g03.service;

import com.socialMeli.be_java_hisp_w20_g03.dto.PostDTO;
import com.socialMeli.be_java_hisp_w20_g03.exception.NotFoundException;
import com.socialMeli.be_java_hisp_w20_g03.model.Post;
import com.socialMeli.be_java_hisp_w20_g03.model.Product;
import com.socialMeli.be_java_hisp_w20_g03.repository.IPostRepository;
import com.socialMeli.be_java_hisp_w20_g03.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService implements IPostService {

    @Autowired
    IPostRepository postRepository;
    @Autowired
    IUserRepository userRepository;

    @Override
    public boolean addPost(PostDTO postDTO){

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
            return postRepository.addPost(post);
        } else {
            throw new NotFoundException("User not found");
        }
    }

    @Override
    public List<PostDTO> getPost(int userId) {
        return null;
    }
}
