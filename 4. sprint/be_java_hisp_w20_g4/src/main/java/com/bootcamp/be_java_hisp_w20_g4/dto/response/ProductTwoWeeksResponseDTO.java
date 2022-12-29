package com.bootcamp.be_java_hisp_w20_g4.dto.response;

import com.bootcamp.be_java_hisp_w20_g4.dto.PostDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTwoWeeksResponseDTO {
    private Integer user_id;
    private List<PostDTO> postDTOList;
    private Integer category;
    private Double price;

}
