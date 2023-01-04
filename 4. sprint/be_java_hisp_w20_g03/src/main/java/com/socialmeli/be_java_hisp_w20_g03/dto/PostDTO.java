package com.socialmeli.be_java_hisp_w20_g03.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PostDTO {
    @JsonProperty("post_id")
    private int postId;
    @JsonProperty("user_id")
    private int userId;
    @JsonFormat(shape= JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private double price;

}
