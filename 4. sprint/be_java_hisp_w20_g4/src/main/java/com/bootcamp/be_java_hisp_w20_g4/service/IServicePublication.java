package com.bootcamp.be_java_hisp_w20_g4.service;

import com.bootcamp.be_java_hisp_w20_g4.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w20_g4.dto.response.PublicationDTO;

public interface IServicePublication {


    public PublicationDTO addPublication(PostDTO publication);

}
