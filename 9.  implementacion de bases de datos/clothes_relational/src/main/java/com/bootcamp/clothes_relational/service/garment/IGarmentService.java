package com.bootcamp.clothes_relational.service.garment;

import com.bootcamp.clothes_relational.dto.common.GarmentDTO;
import com.bootcamp.clothes_relational.service.common.ICrudService;

import java.util.List;

public interface IGarmentService extends ICrudService<GarmentDTO> {

    List<GarmentDTO> getBySizeEquals(String size);

    List<GarmentDTO> getByNameContaining(String term);
}
