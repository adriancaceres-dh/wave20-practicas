package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.socialmeli.be_java_hisp_w20_g8.models.Post;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@JsonPropertyOrder(value = {"user_id", "post_id", "date", "product", "category", "price", "has_promo", "discount"})
public class PromoPostResponseDTO extends PostDTO {
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PromoPostResponseDTO(Post post, ProductDTO productDTO, boolean hasPromo, double discount) {
        super(post, productDTO);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
