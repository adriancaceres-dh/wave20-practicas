package com.bootcamp.be_java_hisp_w20_g4.dto.response.product;

import com.bootcamp.be_java_hisp_w20_g4.dto.response.publication.ListedPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductWithPostListDTO {
    private Integer product_id;
    private String product_name;
    private List<ListedPostDTO> publications;
}
