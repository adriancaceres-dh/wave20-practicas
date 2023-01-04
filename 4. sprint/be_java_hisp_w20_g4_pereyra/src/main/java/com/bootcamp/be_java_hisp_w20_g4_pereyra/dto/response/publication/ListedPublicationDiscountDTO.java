package com.bootcamp.be_java_hisp_w20_g4_pereyra.dto.response.publication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListedPublicationDiscountDTO {
    private int user_id;
    private String user_name;
    private List<PublicationDiscountDTO> posts;
}
