package com.bootcamp.java.w20.be_java_hisp_w20_g05.service;

import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.request.PostRequestDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response.PostResponseDTO;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Post;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.model.Product;
import com.bootcamp.java.w20.be_java_hisp_w20_g05.repository.IRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService implements IPostService{
    private int post_id = 0;
    @Autowired
    public IRepository<Post> postRepository;
    @Override
    public List<PostResponseDTO> filterBy(String name) {
        return null;
    }

    @Override
    public Post newPost(PostRequestDTO postRequestDTO) {
        Post newPost = Post.builder()
                .id(++post_id)
                .category(postRequestDTO.getCategory())
                .price(postRequestDTO.getPrice())
                .discount(0)
                .date(postRequestDTO.getDate())
                .product(Product.builder()
                            .id(postRequestDTO.getProduct().getProduct_id())
                            .name(postRequestDTO.getProduct().getProduct_name())
                            .brand(postRequestDTO.getProduct().getBrand())
                            .color(postRequestDTO.getProduct().getColor())
                            .notes(postRequestDTO.getProduct().getNotes())
                            .type(postRequestDTO.getProduct().getType())
                            .build()
                        )
                .build();
        return newPost;
        //postRepository.add();
    }
}
