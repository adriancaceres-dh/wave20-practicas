package com.socialmeli.be_java_hisp_w20_g03.model;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Post {
    @NonNull
    private int postId;
    @NonNull
    private int userId;
    @NonNull
    private int category;
    @NonNull
    private double price;
    @NonNull
    private Product product;
    @NonNull
    private LocalDate date;
    private boolean hasPromo = false;
    private double discount = 0;
}
