package com.bootcamp.be_java_hisp_w20_g4.service.publication;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.product.ProductTwoWeeksResponseDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;

public interface IServicePublication {


    PublicationDTO addPublication(PostDTO publication);
    ProductTwoWeeksResponseDTO getLastTwoWeeksPublications(int userId, String order);

}
