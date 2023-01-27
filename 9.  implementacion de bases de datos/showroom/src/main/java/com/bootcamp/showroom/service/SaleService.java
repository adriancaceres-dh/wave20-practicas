package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.MessageDto;
import com.bootcamp.showroom.dto.SaleRequestDto;
import com.bootcamp.showroom.dto.SaleResponseDto;
import com.bootcamp.showroom.entity.Clothing;
import com.bootcamp.showroom.entity.Sale;
import com.bootcamp.showroom.repository.ClothingRepository;
import com.bootcamp.showroom.repository.SaleRepository;
import com.bootcamp.showroom.service.interfaces.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService implements ISaleService {

    private final ClothingRepository clothingRepo;
    private final SaleRepository saleRepo;
    private final ModelMapper mapper;

    public SaleService(SaleRepository saleRepo, ClothingRepository clothingRepo) {
        this.saleRepo = saleRepo;
        this.clothingRepo = clothingRepo;
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
        if (!saleRepo.existsById(id)) throw new RuntimeException("Requested id does not exist.");

        Sale updatedSale = buildSale(saleRequestDto);
        updatedSale.setId(id);
        saleRepo.save(updatedSale);
        return mapper.map(updatedSale, SaleResponseDto.class);
    }

    @Override
    public MessageDto deleteSaleById(Long id) {
        if (!saleRepo.existsById(id)) throw new RuntimeException("Requested id does not exist.");
        saleRepo.deleteById(id);
        return MessageDto.builder()
                .message("Requested entry was deleted successfully")
                .action("DELETE")
                .statusCode(HttpStatus.OK.value())
                .build();
    }

    @Override
    public List<SaleResponseDto> getAllSalesByDate(LocalDate date) {
        if (date == null) return getAllSales();

        return saleRepo.getAllByDate(date).stream()
                .map(sale -> mapper.map(sale, SaleResponseDto.class))
                .collect(Collectors.toList());
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
