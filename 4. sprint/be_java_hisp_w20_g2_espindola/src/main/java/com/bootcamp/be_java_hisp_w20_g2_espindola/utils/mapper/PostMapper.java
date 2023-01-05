package com.bootcamp.be_java_hisp_w20_g2_espindola.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostPromoDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.dto.request.PostPromoRequestDTO;
import com.bootcamp.be_java_hisp_w20_g2_espindola.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_espindola.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_espindola.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostMapper {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductMapper productMapper;

    public Post toPost(PostDTO postDTO) {
        Product product = productMapper.toProduct(postDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postDTO.getCategory());

        return new Post(postDTO.getDate(), product, postCategory, postDTO.getPrice());
    }

    public Post toPostPromo(PostPromoRequestDTO postPromoRequestDTO) {
        Product product = productMapper.toProduct(postPromoRequestDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(postPromoRequestDTO.getCategory());

        return new Post(postPromoRequestDTO.getDate(), product, postCategory, postPromoRequestDTO.getPrice(), postPromoRequestDTO.isHasPromo(), postPromoRequestDTO.getDiscount());
    }

    public PostPromoDTO toPostPromoDTO(Post post, int userId) {
        return new PostPromoDTO(
                userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.getId(),
                post.isHasPromo(),
                post.getDiscount()
        );
    }

    public PostDTO toDTO(Post post, int userId) {
        return new PostDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice());
    }

    public PostWithIdDTO toWithIdDTO(Post post, int userId) {
        return new PostWithIdDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.getId());
    }

    private Category getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
    }
}