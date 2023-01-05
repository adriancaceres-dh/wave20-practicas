package com.socialmeli.be_java_hisp_w20_g8.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.socialmeli.be_java_hisp_w20_g8.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PostRequestDTO {
    @JsonProperty("user_id")
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    @JsonProperty("product")
    private ProductDTO product;
    private Integer category;
    private Double price;
    private boolean has_promo;
    private Double discount;
}
