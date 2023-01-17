package com.bootcamp.be_java_hisp_w20_g2_alderete.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.PostPromotionDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.dto.request.PromotionRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_alderete.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_alderete.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.CategoryRepository;
import com.bootcamp.be_java_hisp_w20_g2_alderete.repository.UserRepository;
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

    public Post toPost(PromotionRequestDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(),
                product,
                postCategory,
                postDTO.getPrice(),
                userRepository.findOne(postDTO.getUserId()),
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

    public PostPromotionDTO toWithPromoDTO(Post post) {
        return new PostPromotionDTO(post.getAuthor().getId(),
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    private Category getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Código inválido."));
    }

}