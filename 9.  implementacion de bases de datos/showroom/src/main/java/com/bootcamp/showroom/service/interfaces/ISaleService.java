package com.bootcamp.showroom.service.interfaces;

import com.bootcamp.showroom.dto.MessageDto;
import com.bootcamp.showroom.dto.SaleRequestDto;
import com.bootcamp.showroom.dto.SaleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleResponseDto createSale(SaleRequestDto saleRequestDto);
    List<SaleResponseDto> getAllSales();
    SaleResponseDto getSaleById(Long id);
    SaleResponseDto updateSaleById(SaleRequestDto saleRequestDto, Long id);
    MessageDto deleteSaleById(Long id);
    List<SaleResponseDto> getAllSalesByDate(LocalDate date);
}
