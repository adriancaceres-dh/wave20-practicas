package com.socialmeli.be_java_hisp_w20_g8.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@Data
public class PostRequestDTO {
    @JsonProperty("user_id")
    private Integer user_id;
    @JsonFormat(pattern = "dd-MM-yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate date;
    @JsonProperty("product")
    private ProductDTO productDTO;
    private Integer category;
    private Double price;
}
