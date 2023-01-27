package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.SaleRequestDto;
import com.bootcamp.showroom.dto.SaleResponseDto;
import com.bootcamp.showroom.entity.Clothing;
import com.bootcamp.showroom.entity.Sale;
import com.bootcamp.showroom.repository.ClothingRepository;
import com.bootcamp.showroom.repository.SaleRepository;
import com.bootcamp.showroom.service.interfaces.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    private final ClothingRepository clothingRepo;
    private final SaleRepository saleRepo;
    private final ClothingService clothingService;
    private final ModelMapper mapper;

    public SaleService(SaleRepository saleRepo, ClothingRepository clothingRepo, ClothingService clothingService) {
        this.saleRepo = saleRepo;
        this.clothingRepo = clothingRepo;
        this.clothingService = clothingService;
        this.mapper = new ModelMapper();
    }

    @Override
    public SaleResponseDto createSale(SaleRequestDto saleRequestDto) {
        Sale newSale = buildSale(saleRequestDto);
        Long id = saveSale(newSale);
        return mapper.map(newSale, SaleResponseDto.class);
    }

    @Override
    public List<SaleResponseDto> getAllSales() {
        return saleRepo.findAll().stream()
                .map(sale -> mapper.map(sale, SaleResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public SaleResponseDto getSaleById(Long id) {
        return mapper.map(saleRepo.findById(id), SaleResponseDto.class);
    }

    @Override
    public SaleResponseDto updateSaleById(SaleRequestDto saleRequestDto, Long id) {
         Sale updatedSale = buildSale(saleRequestDto);
         updatedSale.setId(id);
         saleRepo.save(updatedSale);
         return mapper.map(updatedSale, SaleResponseDto.class);
    }

    private Long saveSale(Sale sale) {
        return saleRepo.save(sale).getId();
    }

    private Sale buildSale(SaleRequestDto saleRequestDto) {
        List<Long> clothingIdList = saleRequestDto.getClothingIdList();
        List<Clothing> clothingList = clothingRepo.findAllById(clothingIdList);

        if (clothingList.isEmpty()) throw new RuntimeException("No valid clothing on sale.");

        return Sale.builder()
                .date(saleRequestDto.getDate())
                .total(clothingRepo.calculateTotalPrice(clothingIdList))
                .paymentMethod(saleRequestDto.getPaymentMethod())
                .clothingList(clothingList)
                .build();
    }
}
