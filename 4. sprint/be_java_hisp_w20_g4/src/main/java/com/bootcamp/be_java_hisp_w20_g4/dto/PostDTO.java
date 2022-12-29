package com.bootcamp.be_java_hisp_w20_g4.dto;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDTO {
    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private List<ProductDTO> productDTOList;
    private Integer category;
    private String notes;
}
