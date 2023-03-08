package com.bootcamp.clothes.service.interfaces;

import com.bootcamp.clothes.dto.request.ClotheDTO;
import com.bootcamp.clothes.entity.Clothe;
import com.bootcamp.clothes.service.interfaces.generics.ICrudService;

public interface IClotheService extends ICrudService<ClotheDTO, Integer> {
}
