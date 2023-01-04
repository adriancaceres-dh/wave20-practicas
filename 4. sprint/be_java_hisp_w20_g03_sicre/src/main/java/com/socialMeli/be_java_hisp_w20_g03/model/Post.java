package com.socialMeli.be_java_hisp_w20_g03.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int postId;
    private int userId;
    private int category;
    private double price;
    private Product product;
    private LocalDate date;

    private boolean hasPromo = false;

    private double discount = 0.0;

}
