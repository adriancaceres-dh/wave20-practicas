package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
@JsonPropertyOrder(value = {"user_id", "user_name", "posts"})
public class SellerPromoPostsResponseDTO {
    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("user_name")
    private String userName;
    private List<PromoPostResponseDTO> posts;
}
