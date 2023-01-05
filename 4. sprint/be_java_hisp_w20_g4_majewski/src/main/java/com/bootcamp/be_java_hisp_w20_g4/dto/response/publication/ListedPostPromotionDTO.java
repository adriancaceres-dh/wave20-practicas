package com.bootcamp.be_java_hisp_w20_g4.dto.response.publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListedPostPromotionDTO extends ListedPostDTO{

    private boolean hasPromo;
    private double discount;
}
