package com.bootcamp.be_java_hisp_w20_g2_podio.utils.mapper;

import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PostWithIdDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.dto.PromoPostDTO;
import com.bootcamp.be_java_hisp_w20_g2_podio.exception.PostCreationException;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Category;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Post;
import com.bootcamp.be_java_hisp_w20_g2_podio.model.Product;
import com.bootcamp.be_java_hisp_w20_g2_podio.repository.CategoryRepository;
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

    public Post toPromoPost(PromoPostDTO promoPostDTO) {
        Product product = productMapper.toProduct(promoPostDTO.getProduct());

        Category postCategory = getPostCategoryByCodeOrThrow(promoPostDTO.getCategory());

        return new Post(promoPostDTO.getDate(), product, postCategory, promoPostDTO.getPrice(),
                promoPostDTO.isHasPromo(), promoPostDTO.getDiscount());
    }

    public PostDTO toDTO(Post post, int userId) {
        return new PostDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount());
    }

    public PostWithIdDTO toWithIdDTO(Post post, int userId) {
        return new PostWithIdDTO(userId,
                post.getDate(),
                productMapper.toDTO(post.getProduct()),
                post.getCategory().getCode(),
                post.getPrice(),
                post.isHasPromo(),
                post.getDiscount(),
                post.getId());
    }

    private Category getPostCategoryByCodeOrThrow(int code) {
        return categoryRepository.findByCode(code)
                .orElseThrow(() -> new PostCreationException("Invalid category code"));
    }
}