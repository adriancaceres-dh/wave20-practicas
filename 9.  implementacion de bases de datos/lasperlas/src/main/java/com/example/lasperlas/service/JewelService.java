package com.example.lasperlas.service;

import com.example.lasperlas.dto.JewelOperationResponseDto;
import com.example.lasperlas.dto.JewelRequestDto;
import com.example.lasperlas.dto.JewelResponseDto;

import java.util.List;

public interface JewelService {
    JewelOperationResponseDto addJewel(JewelRequestDto jewelRequestDto);
    JewelOperationResponseDto setAsUnsellable(Long id);
    JewelOperationResponseDto updateJewel(Long id, JewelRequestDto jewelRequestDto);
    List<JewelResponseDto> getAllSellableJewels();
}
