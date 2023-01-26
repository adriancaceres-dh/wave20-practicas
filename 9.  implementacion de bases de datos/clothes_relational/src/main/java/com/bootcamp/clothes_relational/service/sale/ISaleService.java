package com.bootcamp.clothes_relational.service.sale;

import com.bootcamp.clothes_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_relational.dto.common.SaleDTO;
import com.bootcamp.clothes_relational.service.common.ICrudService;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService extends ICrudService<SaleDTO> {

    List<SaleDTO> getAllByDateEquals(LocalDate date);
    List<GarmentDTO> getClothesBySaleNumber(Long number);
}
