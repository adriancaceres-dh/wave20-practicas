package com.spring.lasperlas.service;

import com.spring.lasperlas.dto.MessageDTO;
import com.spring.lasperlas.dto.request.JewelRequestDTO;
import com.spring.lasperlas.dto.response.JewelListedDTO;

public interface IJewelService {
    MessageDTO createJewel(JewelRequestDTO jewelRequestDTO);

    JewelListedDTO getJewerly();

    MessageDTO deleteJewelLogically(Long id);

    MessageDTO updateJewel(Long id, JewelRequestDTO jewelRequestDTO);
}
