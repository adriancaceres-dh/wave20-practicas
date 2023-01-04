package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication.ListedPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductTwoWeeksResponseDTO {
    private Integer user_id;
    private List<ListedPostDTO> posts;
}
