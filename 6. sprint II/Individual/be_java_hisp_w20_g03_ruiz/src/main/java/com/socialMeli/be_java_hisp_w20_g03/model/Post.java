package com.socialMeli.be_java_hisp_w20_g03.model;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Post {
    private int postId;
    private int userId;
    private int category;
    private double price;
    private Product product;
    private LocalDate date;
}
