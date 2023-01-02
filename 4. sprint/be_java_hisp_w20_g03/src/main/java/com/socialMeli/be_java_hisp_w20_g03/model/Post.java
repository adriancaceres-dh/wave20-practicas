package com.socialMeli.be_java_hisp_w20_g03.model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private int user_id;
    private int category;
    private double price;
    private Product product;
    private LocalDate date;
}
