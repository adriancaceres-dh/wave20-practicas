package com.socialmeli.be_java_hisp_w20_g8.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostPromo {

    @JsonProperty("user_id")
    private int userId;
    @JsonProperty("post_id")
    private int postId;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    private Product product;
    private Integer category;
    private double price;
    private boolean hashPromo;
    private double discount;

}



