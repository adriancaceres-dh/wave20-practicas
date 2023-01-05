package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication;

import com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.product.ProductDTO;
import com.bootcamp.be_java_hisp_w20_g4_pereyra.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListedPublicationsDTO {
   private List<PublicationDiscountDTO> posts;
}
