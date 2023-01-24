package com.bootcamp.joyeria.joyeria.service;

import com.bootcamp.joyeria.joyeria.dot.JewelDTO;
import com.bootcamp.joyeria.joyeria.dot.MessageDTO;
import com.bootcamp.joyeria.joyeria.models.Jewel;

import java.util.List;
import java.util.Optional;

public interface IJewelService {
    JewelDTO saveJewel(JewelDTO jewelDTO);
    Optional<Jewel> findJewel(Long id);
    List<JewelDTO> getAllJewels();
    MessageDTO deleteJewel(Long id);
}
