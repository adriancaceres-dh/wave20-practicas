package com.bootcamp.be_java_hisp_w20_g2_idalgo.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.PostWithPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.dto.request.PromoPostRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.CategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_idalgo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductMapper productMapper;

    public Post toPost(PostDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(),
                product,
                postCategory,
                postDTO.getPrice(),
                userRepository.findOne(postDTO.getUserId()));
    }

    public Post toPost(PromoPostRequestDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getPost().getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postDTO.getPost().getCategory());

        return new Post(postDTO.getPost().getDate(),
                product,
                postCategory,
                postDTO.getPost().getPrice(),
                userRepository.findOne(postDTO.getPost().getUserId()),
                postDTO.isHasPromo(),
                postDTO.getDiscount());
    }

    public PostDTO toDTO(Post post) {
        return new PostDTO(post.getAuthor().getId(),
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice());
    }

    public PostWithIdDTO toWithIdDTO(Post post) {
        return new PostWithIdDTO(post.getAuthor().getId(),
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.getId());
    }

    public PostWithPromoDTO toWithPromoDTO(Post post) {
        return new PostWithPromoDTO(post.getAuthor().getId(),
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    private Category getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
    }

}