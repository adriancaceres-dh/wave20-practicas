package com.bootcamp20.lasPerlas.service;

import com.bootcamp20.lasPerlas.dtos.JewelryDTO;
import com.bootcamp20.lasPerlas.dtos.MessageDTO;

import java.util.List;

public interface IJewelryService {
    MessageDTO saveJewelry(JewelryDTO jewelryDTO);

    JewelryDTO getJewelryById(Integer nro_identifying);

    MessageDTO updateJewelry(Integer id_modify, JewelryDTO jewelryDTO);

    List<JewelryDTO> getAllJewelry();

    MessageDTO deleteJewelry(Integer nro_identifying);


}
