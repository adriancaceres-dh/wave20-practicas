package com.bootcamp.clothes.service.interfaces;

import com.bootcamp.clothes.dto.request.SaleDTO;
import com.bootcamp.clothes.service.interfaces.generics.ICrudService;

import java.time.LocalDate;

public interface ISaleService extends ICrudService<SaleDTO, Integer> {
}
