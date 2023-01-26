package com.bootcamp.clothes_relational.service;

import com.bootcamp.clothes_relational.dto.common.GarmentDTO;

import java.util.List;

public interface IGarmentService extends ICrudService<GarmentDTO> {

    List<GarmentDTO> getBySizeEquals(String size);

    List<GarmentDTO> getByNameContaining(String term);
}
