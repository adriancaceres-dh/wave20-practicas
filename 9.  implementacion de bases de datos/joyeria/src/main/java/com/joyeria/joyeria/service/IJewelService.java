package com.joyeria.joyeria.service;

import com.joyeria.joyeria.dto.JewelRequestDto;
import com.joyeria.joyeria.dto.JewelResponseDto;
import com.joyeria.joyeria.dto.JewelryListResponseDto;
import com.joyeria.joyeria.dto.MessageDto;

public interface IJewelService {
    JewelResponseDto createJewel(JewelRequestDto jewelDto);

    JewelryListResponseDto getAll();

    MessageDto delete(Integer id);

    JewelResponseDto updateJewel(JewelRequestDto jewelDto);
}
