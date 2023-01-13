package com.bootcamp.java.w20.be_java_hisp_w20_g05.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonPropertyOrder({"userId", "id", "date", "product", "category", "price"})
public class PostResponseDTO {
    @JsonProperty("post_id")
    private int id;
    @JsonProperty("user_id")
    private int userId;
    private LocalDate date;
    private ProductResponseDTO product;
    private String category;
    private double price;
}
